package org.creativecoding.resonate.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.creativecoding.resonate.LabelArchive;
import org.creativecoding.resonate.LabelArchive.Artist;
import org.creativecoding.resonate.LabelArchive.Release;

import processing.core.PApplet;


public class LabelArchiveArtistReleasesExample extends PApplet {
	
	LabelArchive label;
	
	public void setup () {
		
		HashMap<String, ArrayList<Release>> artists = new HashMap<String, ArrayList<Release>> ();
		
		label = LabelArchive.loadFromJson (this, "discogs/Warp Records-full.json");
		
		// For each release...
		for (Release r : label.mReleases) {
			
			// For each artist per release...
			for (Artist a : r.mArtists) {
				
				// If we don't know the artist yet...
				if (!artists.containsKey (a.mName)) {
					// Put it in our map
					artists.put (a.mName, new ArrayList <Release> ());
				}
				
				// Flag representing the relation status,
				// by default false.
				boolean hasRelease = false;
				
				// For every release of the artist that
				// we came across so far...
				for (Release v : artists.get (a.mName)) {
					
					// Check if the release name equals the name
					// of the current release 'r'
					if (v.mTitle.equalsIgnoreCase (r.mTitle)) {
						
						// If so, set flag to true
						hasRelease = true;
						break;
					}
				}
				
				// Only add release if flag is 'false';
				// if a release with such title isn't 
				// stored yet.
				if (!hasRelease)
					artists.get (a.mName).add (r);
			}
		}
		
		// Finally go through all artists...
		for (String key : artists.keySet ()) {
			
			// Print out artist name
			System.out.println (" === " + key + " === ");
			
			// Print out release titles
			for (Release r : artists.get (key)) {
				System.out.println (r.mTitle);
			}
		}
		
		exit ();
	}
}
