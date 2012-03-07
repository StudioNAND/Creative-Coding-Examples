package org.creativecoding;

import org.creativecoding.audio.analysis.svl.AnnotationLayer;
import org.creativecoding.audio.analysis.svl.SonicVisualiserSession;

import processing.core.PApplet;

public class UsingSonicVisualiserData extends PApplet
{
	public SonicVisualiserSession mSession;
	
	public AnnotationLayer mBeatTracker;
	public AnnotationLayer mOnsetsDS;
	public AnnotationLayer mChordEstimates;
	public AnnotationLayer mPolyphonicTranscription;
	
	public void setup()
	{
		size( 1280, 720 );
		background( 255 );
		noLoop();
		
		mSession = new SonicVisualiserSession( this );
		mBeatTracker = mSession.addAnnotationLayer( "sonicvisualiser/Aubio Beat Tracker.svl" );
		mOnsetsDS = mSession.addAnnotationLayer( "sonicvisualiser/OnsetsDS Onset Detector.svl" );
		mChordEstimates = mSession.addAnnotationLayer( "sonicvisualiser/Chord Estimate.svl" );
		mPolyphonicTranscription = mSession.addAnnotationLayer( "sonicvisualiser/Polyphonic Transcription.svl" );
	}
	
	public void draw()
	{
		noFill();
		stroke( 0 );
		for ( AnnotationLayer.Point point : mBeatTracker.getPoints() )
		{
			float x = map( point.mFrame, mSession.getStart(), mSession.getEnd(), 0, width );
			line( x, 0, x, height );
		}
		
		noFill();
		stroke( 255, 0, 0 );
		for ( AnnotationLayer.Point point : mOnsetsDS.getPoints() )
		{
			float x = map( point.mFrame, mSession.getStart(), mSession.getEnd(), 0, width );
			line( x, 0, x, height );
		}
		
		noFill();
		stroke( 255, 255, 0 );
		for ( AnnotationLayer.Point point : mChordEstimates.getPoints() )
		{
			float x = map( point.mFrame, mSession.getStart(), mSession.getEnd(), 0, width );
			line( x, 0, x, height );
		}
		
		fill( 0, 0, 255 );
		noStroke();
		for ( AnnotationLayer.Point point : mPolyphonicTranscription.getPoints() )
		{
			float x = map( point.mFrame, mSession.getStart(), mSession.getEnd(), 0, width );
			float y = height - map( point.mValue, mPolyphonicTranscription.getMinimum(), mPolyphonicTranscription.getMaximum(), 0, height );
			ellipse( x, y, 4, 4 );
		}
	}
	
	public static void main( String[] args )
	{
		PApplet.main( new String[] { UsingSonicVisualiserData.class.getName() } );
	}

}
