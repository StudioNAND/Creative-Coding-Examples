/**
 * Kinect-library: http://www.shiffman.net/p5/kinect/
 */
import org.openkinect.*;
import org.openkinect.processing.*;

// Kinect-Reference
Kinect kinect;

void setup () {
  size (1280, 480);
  // Initialise Kinect interface
  kinect = new Kinect (this);
  kinect.start ();
  // Enable depth image
  kinect.enableDepth (true);
  // Enable video image
  kinect.enableRGB (true);
}

void draw () {
  // Draw depth and video image
  image (kinect.getDepthImage (), 0, 0);
  image (kinect.getVideoImage (), 640, 0);
}

void stop () {
  kinect.quit ();
  super.stop ();
}
