package org.creativecoding.resonate.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.creativecoding.resonate.LabelArchive;
import org.creativecoding.resonate.LabelArchive.Release;

import processing.core.PApplet;


public class LabelArchiveGenreReleaseExample extends PApplet {
	
	LabelArchive label;
	
	
	public void setup () {
		
		HashMap<String, ArrayList<Release>> genres = new HashMap<String, ArrayList<Release>> ();
		
		label = LabelArchive.loadFromJson (this, "discogs/Warp Records-full.json");
		
		// For each release...
		for (Release r : label.mReleases) {
			
			// For each genre...
			for (String g : r.mGenres) {
				
				// If we don't know the genre already...
				if (!genres.containsKey (g)) {
					// Store it in our map
					genres.put (g, new ArrayList<LabelArchive.Release> ());
				}
				
				// Flag representing the relation status,
				// by default false.
				boolean hasRelease = false;
				
				// For every release of this genre that
				// we came across so far...
				for (Release v : genres.get (g)) {
					
					// If the current release title equals 
					// the title of a release that we already
					// added; set our flag to 'true' for not
					// saving that one as well
					if (v.mTitle.equals (r.mTitle)) {
						hasRelease = true;
						break;
					}
				}
				
				// If store-flag is still false
				if (!hasRelease)
					genres.get (g).add (r);
			}
		}
		
		// Finally loop through all genres and 
		// print out release names
		
		// For each genre...
		for (String genre : genres.keySet ()) {
			
			System.out.println ("\n === " + genre + " ===\n");
			
			// For each release per genre...
			for (Release release : genres.get (genre)) {
				System.out.println (release.mTitle);
			}
		}
	}
}
