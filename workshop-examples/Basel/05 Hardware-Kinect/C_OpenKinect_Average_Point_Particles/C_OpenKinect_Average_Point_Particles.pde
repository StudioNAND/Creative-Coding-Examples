/**
 * Kinect-library: http://www.shiffman.net/p5/kinect/
 * Physics-library: http://toxiclibs.org/downloads/
 */
import processing.opengl.*;

import toxi.geom.*;
import toxi.physics2d.constraints.*;
import toxi.physics2d.behaviors.*;
import toxi.physics2d.*;
import org.openkinect.*;
import org.openkinect.processing.*;

boolean displayKinect = false;

KinectTracker tracker;
Kinect kinect;

int particleNum = 500;
int particleDiam = 10;
VerletPhysics2D physics;
AttractionBehavior finger;


void setup() {
    size(640, 480, OPENGL);
    noStroke ();
    
    // Initialise Kinect-Interface
    kinect = new Kinect(this);
    // Initialise Kinect-Tracking
    tracker = new KinectTracker();
    
    // Initialise physics simulation
    physics = new VerletPhysics2D ();
    physics.addBehavior (new GravityBehavior (new Vec2D (0, 0.05)));
    physics.setDrag (0.05);
    physics.setWorldBounds (new Rect (0, 0, width, height));
    
    // Create 500 particles at random positions
    for (int i=0; i < particleNum; i++) {
        Vec2D v = new Vec2D (random (width), random (height));
        VerletParticle2D particle = new VerletParticle2D (v);
        physics.addParticle (particle);
        // Create small negative attraction between partilces
        physics.addBehavior (new AttractionBehavior (particle, particleDiam + 1, -0.2));
    }
    
    // Attraction behaviour that will be later 
    // positioned by the Kinect-mid-point
    finger = new AttractionBehavior (new Vec2D (0, 0), 250, 0.3);
    physics.addBehavior (finger);
    
    println ("[k] turn on/off depth image");
}

void draw () {
    background(0);

    // read and analyse Kinect-data
    tracker.track();
    // Get tracked Kinect-mid-point
    PVector midPoint = tracker.getLerpedPos ();
    // Set Attractor position to Kinect-mid-point
    finger.setAttractor (new Vec2D (midPoint.x, midPoint.y));

    if (displayKinect) {
        // Show kinect image
        noSmooth ();
        tracker.display();
    }

    smooth ();

    // Display Kinect-mid-point
    noStroke ();
    fill (100, 250, 50);
    ellipse (midPoint.x, midPoint.y, particleDiam, particleDiam);

    // Draw all particles
    strokeWeight (2);
    stroke (255, 130);
    noFill ();
    for (VerletParticle2D particle : physics.particles) {
        ellipse (particle.x, particle.y, particleDiam, particleDiam);
    }
    
    // Update particle simulation
    physics.update ();
}

void keyPressed() {

    if (keyCode == 75)
        displayKinect = !displayKinect;

    if (key == CODED) {
        if (keyCode == UP)
            tracker.setThreshold (tracker.getThreshold () + 5);
        else if (keyCode == DOWN)
            tracker.setThreshold (tracker.getThreshold () - 5);
    }
}

/**
 * Stop Kinect-interface when 
 * sketch quits...
 */
void stop() {
    tracker.quit();
    super.stop();
}
