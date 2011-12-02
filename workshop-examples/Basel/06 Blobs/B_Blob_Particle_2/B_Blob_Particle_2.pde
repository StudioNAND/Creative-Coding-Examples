/**
 * Examples use blob detection as input to control particles
 * by moving arround attractors.
 * Blob-library: http://www.v3ga.net/processing/BlobDetection/
 * Physics-library: http://toxiclibs.org/downloads/
 */

import toxi.geom.*;
import toxi.physics2d.*;
import toxi.physics2d.behaviors.*;
import processing.video.*;
import blobDetection.*;

Capture cam;
BlobDetection blobDetection;
PImage img;
boolean newFrame=false;

VerletPhysics2D physics;
ArrayList<AttractionBehavior> finger;


void setup() {
    size(640, 480);

    // setup PHYSICS
    physics = new VerletPhysics2D();
    physics.addBehavior( new GravityBehavior( new Vec2D( 0, 0.1 ) ) );
    physics.setDrag( 0.001 );
    physics.setWorldBounds( new Rect( 0, 0, width, height ) );

    // Create 100 particles which try
    // to aviod each other (small distance)
    for (int i=0; i < 100; i++) {
        Vec2D v = new Vec2D (random (width), random (height));
        VerletParticle2D particle = new VerletParticle2D (v);
        physics.addParticle (particle);
        // Negative attraction between particles
        physics.addBehavior (new AttractionBehavior (particle, 20, -0.5));
    }

    // An empty list of blob-centers
    finger = new ArrayList<AttractionBehavior> ();

    // setup CAMERA und BLOB DETECTION
    cam = new Capture (this, 40 * 4, 30 * 4, 15);
    img = new PImage (80, 60); 
    blobDetection = new BlobDetection (img.width, img.height);
    blobDetection.setPosDiscrimination (true);
    blobDetection.setThreshold (0.8f);
}


void draw () {
    
    // If a new frame is available...
    if (newFrame) {
        
        fill (0, 30);
        rect (0, 0, width, height);

        // Set image flag back to false
        newFrame = false;
        // Copy image buffer
        img.copy (cam, 0, 0, cam.width, cam.height, 0, 0, img.width, img.height);

        // Detect all blobs inside camera image
        blobDetection.computeBlobs (img.pixels);

        // Create new Attraction 'fingers' if the number of 
        // Blobs is bigger than the current number of fingers
        while (blobDetection.getBlobNb () > finger.size ()) {
            AttractionBehavior a = new AttractionBehavior (new Vec2D (), 100, 0.3);
            finger.add (a);
            physics.addBehavior (a);
        }

        // Reduce the number of Attraction 'fingers' if 
        // the number of Blobs is bigger.
        while (blobDetection.getBlobNb () < finger.size ()) {
            AttractionBehavior a = finger.get (finger.size () - 1);
            physics.removeBehavior (a);
            finger.remove (a);
        }
        
        // For every blob...
        for (int i=0; i < blobDetection.getBlobNb (); i++) {
            
            // Get single blob at position 'i'
            Blob b = blobDetection.getBlob (i);

            // If blob is not corrupt
            if (b != null) {
                // Calculate blob position on screen
                float x = b.xMin * width + (b.w * width) / 2;
                float y = b.yMin * height + (b.h * height) / 2;
                // Set attractor position to blob center position 
                finger.get (i).setAttractor (new Vec2D (x, y));
                
                // Draw blob center
                stroke (255,0,120);
                line (x-5, y, x+5, y);
                line (x, y-5, x, y+5);
            }
        }
    }
    
    // Draw all particles
    fill (255);
    noStroke ();
    for (VerletParticle2D particle : physics.particles) {
        ellipse (particle.x, particle.y, 5, 5);
    }

    // Update particle position
    // for next frame
    physics.update ();
}

/**
 * Method is called each time a new image
 * from the capture device (camera) is available.
 */
void captureEvent (Capture cam) {
    // Read cam image
    cam.read ();
    // Set new-frame flag true
    newFrame = true;
}
