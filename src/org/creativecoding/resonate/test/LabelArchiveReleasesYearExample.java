package org.creativecoding.resonate.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.creativecoding.resonate.LabelArchive;
import org.creativecoding.resonate.LabelArchive.Release;

import processing.core.PApplet;


public class LabelArchiveReleasesYearExample extends PApplet {
	
	LabelArchive label;
	
	
	public void setup () {
		
		HashMap<Integer, ArrayList<Release>> years = new HashMap<Integer, ArrayList<Release>> ();
		
		label = LabelArchive.loadFromJson (this, "discogs/Warp Records-full.json");
		
		// For each release...
		for (Release r : label.mReleases) {
			
			// If the year doesn't exists in our map...
			if (!years.containsKey (r.mYear)) {
				// Add it!
				years.put (r.mYear, new ArrayList<Release> ());
			}
			
			boolean hasRealse = false;
			
			// For every release of the current year
			// that we know so far
			for (Release v : years.get (r.mYear)) {
				// Check if we have already stored the
				// release title
				if (v.mTitle.equalsIgnoreCase (r.mTitle)) {
					hasRealse = true;
					break;
				}
			}
			
			// If we havn't stored the 
			// release yet, do it now
			if (!hasRealse)
				years.get (r.mYear).add (r);
		}
		
		// Finally simply print out all years and their releases
		
		// For every year...
		for (Integer year : years.keySet ()) {
			System.out.println (" === " + year + " ===");
			
			// For every releases per year...
			for (Release release : years.get (year)) {
				System.out.println (release.mTitle);
			}
		}
		
		// Exit sketch
		exit ();
	}
}
