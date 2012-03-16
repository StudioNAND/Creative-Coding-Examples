package org.creativecoding.resonate.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.creativecoding.resonate.LabelArchive;
import org.creativecoding.resonate.LabelArchive.Artist;
import org.creativecoding.resonate.LabelArchive.Release;

import processing.core.PApplet;


public class StreamGraphCSV extends PApplet {
	
	public void setup () {
		
		HashMap<String, Integer[]> map = new HashMap<String, Integer[]> ();
		
		ArrayList<String> style = new ArrayList<String> ();
		ArrayList<String> gengre = new ArrayList<String> ();
		
		LabelArchive label = LabelArchive.loadFromJson (this, "discogs/Warp Records-full.json");
		
		int max = Integer.MIN_VALUE;
		int num = 0;
		
		for (Release r : label.mReleases) {
			
			if (r.mReleased != null) {
				
				int yearIndex = Integer.valueOf (r.mReleased.split ("-")[0]) - 1989;
				
				if (r.mStyles != null) {
					for (String s : r.mStyles) {
						if (!style.contains (s)) {
							style.add (s);
						}
					}
				}

				for (String s : r.mGenres) {
					if (!gengre.contains (s)) {
						gengre.add (s);
					}
				}
				
				if (yearIndex >= 0 && yearIndex <= 23)
					for (Artist artist : r.mArtists) {
				
						if (!map.containsKey (artist.mName)) {
							map.put (artist.mName, new Integer[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
						}
						
						num += r.mTracklist.size ();
						
						map.get (artist.mName)[yearIndex] += r.mTracklist.size ();
						
						if (max < map.get (artist.mName)[yearIndex])
							max = map.get (artist.mName)[yearIndex];
					}
			}
		}
		
		String[] csv = new String[map.size ()];
		
		System.out.println ("artist num: " + csv.length);
		System.out.println ("track num:  " + num);
		System.out.println ("style num:  " + style.size ());
		System.out.println ("gengre num: " + gengre.size ());
		
		int i = 0;
		
		for (String key : map.keySet ()) {
			
			String list = "";
			
			for (Integer count : map.get (key)) {
				list += "," + Float.toString ((float)count / (float)max);
			}
			
			csv[i] = key.replace (",", "") + list;
			
			i++;
		}
		
		saveStrings ("warp - artist release stream.csv", csv);
		exit ();
	}
	
}
