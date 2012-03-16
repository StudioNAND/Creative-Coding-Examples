package org.creativecoding.resonate.test;

import java.util.HashMap;

import org.creativecoding.resonate.LabelArchive;
import org.creativecoding.resonate.LabelArchive.Artist;
import org.creativecoding.resonate.LabelArchive.Release;

import processing.core.PApplet;


/**
 * 
 * @author Steffen Fiedler (steffen{near}nand{stop}io)
 * 
 * <code>
 * Pivot: 9
 * Ghostface Killah: 1
 * Move D: 3
 * Eskmo: 1
 * Jamie Lidell: 50
 * Cant (2): 3
 * Haswell & Hecker: 1
 * </code>
 * 
 */
public class LabelArchiveArtistReleaseCountExample extends PApplet {

	LabelArchive label;
	
	
	public void setup () {
		
		// Map for all artists and their number of releases
		HashMap<String, Integer> artists = new HashMap<String, Integer> ();
		
		label = LabelArchive.loadFromJson (this, "discogs/Warp Records-full.json");
		
		// For each release...
		for (Release r : label.mReleases) {
			
			// For each artist...
			for (Artist a : r.mArtists) {
				
				// If we don't know the artist yet...
				if (!artists.containsKey (a.mName)) {
					// Store it in our map: initial value 1
					artists.put (a.mName, 1);
				}else{
					// Otherwise, level up release count
					artists.put (a.mName, artists.get (a.mName) + 1);
				}
			}
		}
		
		// Go through all artists and print the number of releases
		for (String key : artists.keySet ()) {
			System.out.println (key + ": " + artists.get (key));
		}
		
		// Exit program
		exit ();
	}
	
}
