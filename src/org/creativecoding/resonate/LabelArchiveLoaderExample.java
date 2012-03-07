package org.creativecoding.resonate;

import processing.core.PApplet;

public class LabelArchiveLoaderExample extends PApplet
{
	public void setup()
	{
		LabelArchive l = LabelArchive.loadFromJson( this, "discogs/Warp Records-full.json" );
	}
	
	public void draw()
	{
		
	}
	
	public static void main( String[] args )
	{
		PApplet.main( new String[] { LabelArchiveLoaderExample.class.getName() } );
	}

}
