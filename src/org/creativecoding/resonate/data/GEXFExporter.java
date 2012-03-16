package org.creativecoding.resonate.data;

import java.util.ArrayList;
import java.util.HashMap;

import org.creativecoding.resonate.LabelArchive;
import org.creativecoding.resonate.LabelArchive.Artist;
import org.creativecoding.resonate.LabelArchive.Release;

import processing.core.PApplet;


public class GEXFExporter extends PApplet {
	
	HashMap<String, Integer> nodes;
	ArrayList<Edge> edges; 
	
	public void setup () {
		
		nodes = new HashMap<String, Integer> ();
		edges = new ArrayList<Edge> ();
		
		// Initialise label model with JSON data
		LabelArchive label = LabelArchive.loadFromJson (this, "discogs/Warp Records-full.json");
		
		// Get all label artists
		for (Release release : label.mReleases) {
			
			if (release.mArtists.size () > 1)
				for (Artist artist : release.mArtists) {
				
					if (!nodes.containsKey (artist.mName)) {
						int id = nodes.size ();
						nodes.put (artist.mName, id);
					}
				}
		}
		
		for (Release release : label.mReleases) {
			
			// If there are more than one artist
			// involved in this release...
			if (release.mArtists.size () > 1) {
				
				for (int i=0; i < release.mArtists.size () - 1; i++) {
					for (int j=i+1; j < release.mArtists.size (); j++) {
						
						Edge e = new Edge ();
						e.mNodeA = nodes.get (release.mArtists.get (i).mName);
						e.mNodeB = nodes.get (release.mArtists.get (j).mName);
						e.mTitle = release.mTitle;
						
						if (!hasEdge (e))
							edges.add (e);
					}
				}
			}
		}
		
		String gexf = "";
		gexf += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		gexf += "<gexf xmlns=\"http://www.gexf.net/1.2draft\" version=\"1.2\">";
		
		gexf += "<graph mode=\"static\" defaultedgetype=\"directed\">";
		
		gexf += "<nodes>";
		
		for (String key : nodes.keySet ()) {
			gexf += "<node id=\"" + String.valueOf (nodes.get (key)) + "\" label=\"" + key.replace ("&", "and") + "\" />";
		}
		
		gexf += "</nodes>";
		
		gexf += "<edges>";
		
		for (int i=0; i < edges.size (); i++) {
			gexf += "<edge id=\"" + i +"\" source=\"" + String.valueOf (edges.get (i).mNodeA) + "\" target=\"" + String.valueOf (edges.get (i).mNodeB) + "\" />";
		}
		
		gexf += "</edges>";
		
		gexf += "</graph>";
		gexf += "</gexf>";
		
		saveStrings ("label-network.gexf", new String[] {gexf});
		
		exit ();
	}
	
	public boolean hasEdge (Edge edge) {
		for (Edge e : edges) {
			if (e.equals (edge))
				return true;
		}
		return false;
	}
	
	/* Class representing a GEXF edge
	 */
	public class Edge {
		
		// Artist A
		public int mNodeA;
		
		// Artist B
		public int mNodeB;
		
		// Release name
		public String mTitle;
		
		public boolean equals (Edge e) {
			return (e.mNodeA == mNodeA && e.mNodeB == mNodeB || e.mNodeA == mNodeB && e.mNodeB == mNodeB);
		}
	}
}
