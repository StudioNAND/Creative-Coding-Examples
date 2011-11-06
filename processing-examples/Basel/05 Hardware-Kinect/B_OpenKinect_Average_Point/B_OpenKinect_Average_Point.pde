/**
 * Kinect-libraray: http://www.shiffman.net/p5/kinect/
 */
import org.openkinect.*;
import org.openkinect.processing.*;

KinectTracker tracker;
Kinect kinect;

void setup() {
    size(640, 520);
    // Initialise Kinect-interface
    kinect = new Kinect(this);
    // Initialise Kinect-Tracking
    tracker = new KinectTracker();
}

void draw() {
    background(255);

    // Run the tracking analysis
    tracker.track();
    // Display tracking image
    tracker.display();

    // Define center point in tracked space
    PVector midPoint = tracker.getLerpedPos ();
    // Display center point
    fill (100, 250, 50);
    ellipse (midPoint.x, midPoint.y, 20, 20);
}

void keyPressed() {
    // Change threshold limit
    if (key == CODED) {
        if (keyCode == UP)
            tracker.setThreshold (tracker.getThreshold () + 5);
        else if (keyCode == DOWN)
            tracker.setThreshold (tracker.getThreshold () - 5);
    }
}

/**
 * Stop Kinect connection when 
 * program quits...
 */
void stop() {
    tracker.quit();
    super.stop();
}

