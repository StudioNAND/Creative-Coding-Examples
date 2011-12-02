/**
 * This sketch shows how to establish a network connection
 * between a processing sketch and osc-compatible hardware;
 * i.e. the MRMR app (ios).
 *
 * osc-library: http://www.sojamo.de/libraries/oscP5/
 */
import oscP5.*;
import netP5.*;

// OSC-Network interface object for 
// sending and receiving OSC messages
OscP5 oscP5;

// Float-var 'fillValue' will represent the
// last received message value send from an mrmr
// application (iphone/ipad)
float fillValue = 0;

void setup() {
    size (400, 400);
    frameRate (25);

    // create a new instance of oscP5. 
    // 8887 is the port number you are listening 
    // for incoming osc messages.
    oscP5 = new OscP5 (this, 8887);
}

void draw () {
    // Fill the sketch canvas with a grey shade,
    // depending on the last received osc-value.
    background (255 * fillValue);
}

/**
 * This method is triggered when the sketch receives
 * an OSC message. It grabs the argument as float value
 * and updates the 'fillValue'.
 */
void oscEvent (OscMessage theOscMessage) {
    // get and print the address pattern and the 
    // typetag of the received OscMessage
    println("### received an osc message with addrpattern "+theOscMessage.addrPattern()+" and typetag "+theOscMessage.typetag());

    // Get all message arguments
    Object[] args = theOscMessage.arguments ();

    // When there is aleast one of them
    if (args.length > 0) {
        // Get the first one...
        OscArgument arg = theOscMessage.get (0);
        if (arg != null) {
            // Update our float value
            fillValue = arg.floatValue ();
        }
    }
}

