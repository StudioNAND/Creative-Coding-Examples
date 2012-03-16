package org.creativecoding.resonate.test;

import java.util.HashMap;

import org.creativecoding.resonate.LabelArchive;
import org.creativecoding.resonate.LabelArchive.Artist;
import org.creativecoding.resonate.LabelArchive.Release;

import processing.core.PApplet;


public class LabelArchiveArtistGengreExample extends PApplet {

	LabelArchive label;
	
	
	public void setup () {
		
		
		HashMap<String, HashMap<String, Integer>> artists = new HashMap<String, HashMap<String, Integer>> ();
		
		label = LabelArchive.loadFromJson (this, "discogs/Warp Records-full.json");
		
		// For each release...
		for (Release r :  label.mReleases) {
			
			// For each artist per release...
			for (Artist a : r.mArtists) {
				
				// Store the artist name
				String artistName = a.mName;
				
				// If we don't know this artist yet...
				if (!artists.containsKey (artistName)) {
					// Store it in our map
					artists.put (artistName, new HashMap<String, Integer> ());
				}
				
				// For each genre per release...
				for (String genreName : r.mGenres) {
					
					// If the artist doesn't have the genre yet...
					if (!artists.get (artistName).containsKey (genreName)) {
						// Store the genre for that artist
						artists.get (artistName).put (genreName, 0);
					}
					
					// Get the current count of that genre for the artist
					int artistGenreCount = artists.get (artistName).get (genreName);
					
					// Level up the genre count +1
					artists.get (artistName).put (genreName, artistGenreCount + 1);
				}
			}
		}
		
		
		// Finally loop through all artists and their
		// genre counts -> print them to console
		
		// For each artist...
		for (String artist : artists.keySet ()) {
			
			System.out.println (" === " + artist + " === ");
			
			// For each genre
			for (String genre : artists.get (artist).keySet ()) {
				
				int count = artists.get (artist).get (genre);
				System.out.println (count + "x " + genre);
			}
		}
		
		// Exit sketch
		exit ();
	}
}
