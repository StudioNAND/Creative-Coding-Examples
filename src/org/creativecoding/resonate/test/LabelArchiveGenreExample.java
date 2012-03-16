package org.creativecoding.resonate.test;

import org.creativecoding.resonate.LabelArchive;
import org.creativecoding.resonate.LabelArchive.Release;

import processing.core.PApplet;


public class LabelArchiveGenreExample extends PApplet {
	
	LabelArchive label;
	
	public void setup () {
		
		label = LabelArchive.loadFromJson (this, "discogs/Warp Records-full.json");
		
		// For each release...
		for (Release r : label.mReleases) {
			
			// Base string for genre list
			// and genre separator
			String genre = "";
			String sep = "";
			
			// Add each genre to the list
			for (String g : r.mGenres) {
				genre += sep + g;
				sep = ", ";
			}
			
			// Print out release title and genre(s)
			System.out.println (r.mTitle + " -- " + genre);
		}
		
		// Exit sketch
		exit ();
	}
	
}
