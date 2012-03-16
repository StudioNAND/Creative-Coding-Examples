package org.creativecoding.resonate.test;

import org.creativecoding.resonate.LabelArchive;
import org.creativecoding.resonate.LabelArchive.Release;
import processing.core.PApplet;

/**
 * Example code for the Resonate workshop held by Studio NAND and Warp records.
 * 
 * This sketch outlines how to simply load the Warp JSON archive file (based
 * on Discogs.com data) and output all release titles including their label 
 * codes in the console.
 * 
 * @author Steffen Fiedler (steffen{near}nand{stop}io)
 */
public class LabelArchiveReleaseExample extends PApplet {
	
	LabelArchive label;
	
	public void setup () {
		
		// Load label json archive
		label = LabelArchive.loadFromJson (this, "discogs/Warp Records-full.json");
		
		// For every release...
		for (Release r : label.mReleases) {
			
			// If further label information exists
			// for this release...
			if (r.mLabels != null) {
				
				// Print label code + release title
				println ("[" + r.mLabels.get (0).mCatNo + "] " + r.mTitle);
			}
			
		}
	}
}
