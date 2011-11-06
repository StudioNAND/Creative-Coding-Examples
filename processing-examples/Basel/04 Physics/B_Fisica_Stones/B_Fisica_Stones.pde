/**
 * fisica-library: http://www.ricardmarxer.com/fisica/
 */
import fisica.*;

FWorld world;
FPoly poly;
FBox myBox;

void setup () {
    size (600, 600);
    smooth ();
    
    // Initialise physics library
    Fisica.init (this);

    // Create a new 'world' and set
    // its properties
    world = new FWorld ();
    world.setGravity (0, 800);
    world.setEdges (0, 0, width, height);
    world.setEdgesFriction (20);
    world.setEdgesRestitution (0);
}

void draw () {
    background (255);
    
    // Update physics simulation
    world.step ();
    // Draw elements
    world.draw (this);  
    
    // Draw the polygon while
    // while it is being created
    // and hasn't been added to the
    // world yet
    if (poly != null)
        poly.draw (this);
}

void mousePressed () {
    // Only draw a polygon if there isn't 
    // another on at this position...
    if (world.getBody (mouseX, mouseY) != null) 
        return;
    
    // Otherwise create a new polygon
    poly = new FPoly ();
    // Set visual properties
    poly.setStrokeWeight (2);
    poly.setFill (250);
    poly.setDensity (1);
    poly.setRestitution (0.0);
    // Add first vertex
    poly.vertex (mouseX, mouseY);
}

// Add another vertex to the polygon...
void mouseDragged () {
    if (poly != null) {
        poly.vertex (mouseX, mouseY);
    }
}

// Stop drawing the current polygon 
// and add it to the simulation.
void mouseReleased () {
    if (poly != null) {
        world.add (poly);
        poly = null;
    }
}
