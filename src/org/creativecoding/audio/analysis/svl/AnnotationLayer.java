package org.creativecoding.audio.analysis.svl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="sv")
public class AnnotationLayer
{
	@XmlElement(name="data")
	public Data mData;
	
	public static class Data
	{
		@XmlElement(name="model")
		public Model mModel;
		
		@XmlElement(name="dataset")
		public DataSet mDataSet;
		
		@XmlElement(name="display")
		public Display mDisplay;
	}
	
	public static class Model
	{
		@XmlAttribute(name="id")
		public int mId;
		
		@XmlAttribute(name="name")
		public String mName;
		
		@XmlAttribute(name="sampleRate")
		public int mSampleRate;
		
		@XmlAttribute(name="start")
		public long mStart;
		
		@XmlAttribute(name="end")
		public long mEnd;
		
		@XmlAttribute(name="type")
		public String mType;
		
		@XmlAttribute(name="dimensions")
		public int mDimensions;
		
		@XmlAttribute(name="resolution")
		public int mResolution;
		
		@XmlAttribute(name="notifyOnAdd")
		public boolean mNotifyOnAdd;
		
		@XmlAttribute(name="dataset")
		public int mDataset;
		
		@XmlAttribute(name="subtype")
		public String mSubtype;
		
		@XmlAttribute(name="valueQuantization")
		public int mValueQuantization;
		
		@XmlAttribute(name="minimum")
		public int mMinimum;
		
		@XmlAttribute(name="maximum")
		public int mMaximum;
		
		@XmlAttribute(name="units")
		public String mUnits;
	}
	
	public static class DataSet
	{
		@XmlAttribute(name="id")
		public int mId;
		
		@XmlAttribute(name="dimensions")
		public int mDimensions;
		
		@XmlElement(name="point")
		public List<Point> mDataPoints = new ArrayList<Point>();
	}
	
	public static class Point
	{
		@XmlAttribute(name="frame")
		public long mFrame;
		
		@XmlAttribute(name="value")
		public float mValue;
		
		@XmlAttribute(name="duration")
		public long mDuration;
		
		@XmlAttribute(name="level")
		public float mLevel;
		
		@XmlAttribute(name="label")
		public String mLabel;
	}
	
	public static class Display
	{
		@XmlElement(name="layer")
		public Layer mLayer;
		
		public static class Layer
		{
			@XmlAttribute(name="id")
			public int mId;
			
			@XmlAttribute(name="type")
			public String mType;
			
			@XmlAttribute(name="name")
			public String mName;
			
			@XmlAttribute(name="model")
			public int mModel;
			
			@XmlAttribute(name="verticalScale")
			public int mVerticalScale;
			
			@XmlAttribute(name="scaleMinimum")
			public int mScaleMinimum;
			
			@XmlAttribute(name="scaleMaximum")
			public int mScaleMaximum;
			
			@XmlAttribute(name="colourName")
			public String mColourName;
			
			@XmlAttribute(name="colour")
			public String mColour;
			
			@XmlAttribute(name="darkBackground")
			public boolean mDarkBackground;
		}
	}
	
	/**
	 * SOME DIRECT ACCESSORS
	 */
	
	/**
	 * get the layer’s name
	 */
	public String getName()
	{
		return mData.mModel.mName;
	}
	
	public long getStart()
	{
		return mData.mModel.mStart;
	}
	
	public long getEnd()
	{
		return mData.mModel.mEnd;
	}
	
	public int getMinimum()
	{
		return mData.mModel.mMinimum;
	}
	
	public int getMaximum()
	{
		return mData.mModel.mMaximum;
	}
	
	/**
	 * get all datapoints from this layer
	 */
	public List<Point> getPoints()
	{
		return  mData.mDataSet.mDataPoints;
	}
}
