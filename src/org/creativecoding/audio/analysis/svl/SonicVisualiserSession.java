
package org.creativecoding.audio.analysis.svl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import processing.core.PApplet;

public class SonicVisualiserSession
{
	public List<AnnotationLayer> mAnnotationLayers;
	
	public long mStart;
	public long mEnd;
	
	private PApplet mParent;

	public SonicVisualiserSession(PApplet parent)
	{
		mParent = parent;
		
		mAnnotationLayers = new ArrayList<AnnotationLayer>();
		mStart = Long.MAX_VALUE;
		mEnd = Long.MIN_VALUE;
	}

	public AnnotationLayer loadAnnotationLayer( String fileName )
	{
		try
		{
			JAXBContext context = JAXBContext.newInstance( AnnotationLayer.class );
			return (AnnotationLayer) context.createUnmarshaller().unmarshal( mParent.createInput( fileName ) );
		}
		catch ( JAXBException e )
		{
			System.err.println( "Error parsing Annotation Layer XML" );
			e.printStackTrace();
		}

		return null;
	}

	public AnnotationLayer addAnnotationLayer( String fileName )
	{
		AnnotationLayer layer = loadAnnotationLayer( fileName );
		mAnnotationLayers.add( layer );
		
		if ( layer.getEnd() > mEnd )
			mEnd = layer.getEnd();
		
		if ( layer.getStart() < mStart )
			mStart = layer.getStart();
		
		return layer;
	}

	public List<AnnotationLayer> getAnnotationLayers()
	{
		return mAnnotationLayers;
	}
	
	public AnnotationLayer getLayerByName( String name )
	{
		for ( AnnotationLayer l : mAnnotationLayers )
			if ( l.getName().equalsIgnoreCase( name ) )
				return l;
		System.out.println( "WARNING: Layer not found with name " + name );
		return null;
	}
	
	public long getStart()
	{
		if ( mStart == Long.MAX_VALUE )
			return 0;
		return mStart;
	}
	
	public long getEnd()
	{
		if ( mEnd == Long.MIN_VALUE )
			return 0;
		return mEnd;
	}
}
