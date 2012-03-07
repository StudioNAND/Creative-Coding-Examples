
package org.creativecoding.resonate;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import processing.core.PApplet;

@XmlRootElement(name = "Content")
public class LabelArchive
{
	public static LabelArchive loadFromJson( PApplet parent, String fileName )
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
			// make deserializer use JAXB annotations (only)
			mapper.getDeserializationConfig().setAnnotationIntrospector( introspector );
			// make serializer use JAXB annotations (only)
			mapper.getSerializationConfig().setAnnotationIntrospector( introspector );

			return mapper.readValue( parent.createInput( fileName ), LabelArchive.class );
		}
		catch ( Exception e )
		{
			System.err.println("ERROR parsing JSON file " + fileName );
			e.printStackTrace();
		}
		return null;
	}

	@XmlAttribute(name = "profile")
	public String mProfile;

	@XmlAttribute(name = "releases_url")
	public String mReleasesUrl;

	@XmlAttribute(name = "name")
	public String mName;

	@XmlAttribute(name = "uri")
	public String mUri;

	@XmlAttribute(name = "resource_url")
	public String mResourceUrl;

	@XmlAttribute(name = "contactinfo")
	public String mContactInfo;

	@XmlAttribute(name = "id")
	public String mId;

	@XmlAttribute(name = "data_quality")
	public String mDataQuality;

	@XmlAttribute(name = "sublabels")
	List<String> mSublabels;

	@XmlAttribute(name = "urls")
	List<String> mUrls;

	@XmlAttribute(name = "images")
	List<Image> mImages;
	
	@XmlAttribute(name = "releases")
	List<Release> mReleases;

	public static class Release
	{
		@XmlAttribute(name = "year")
		public int mYear;

		@XmlAttribute(name = "id")
		public int mId;
		
		@XmlAttribute(name = "master_id")
		public int mMasterId;

		@XmlAttribute(name = "thumb")
		public String mThumb;

		@XmlAttribute(name = "title")
		public String mTitle;

		@XmlAttribute(name = "status")
		public String mStatus;

		@XmlAttribute(name = "released_formatted")
		public String mReleasedFormatted;

		@XmlAttribute(name = "released")
		public String mReleased;

		@XmlAttribute(name = "country")
		public String mCountry;

		@XmlAttribute(name = "notes")
		public String mNotes;

		@XmlAttribute(name = "uri")
		public String mUri;

		@XmlAttribute(name = "resource_url")
		public String mResourceUrl;
		
		@XmlAttribute(name = "master_url")
		public String mMasterUrl;

		@XmlAttribute(name = "data_quality")
		public String mDataQuality;

		@XmlAttribute(name = "styles")
		List<String> mStyles;

		@XmlAttribute(name = "series")
		List<Series> mSeries;

		@XmlAttribute(name = "labels")
		List<Label> mLabels;

		@XmlAttribute(name = "artists")
		List<Artist> mArtists;

		@XmlAttribute(name = "images")
		List<Image> mImages;

		@XmlAttribute(name = "genres")
		List<String> mGenres;

		@XmlAttribute(name = "extraartists")
		List<Artist> mExtraArtists;

		@XmlAttribute(name = "tracklist")
		List<Track> mTracklist;

		@XmlAttribute(name = "identifiers")
		List<Identifier> mIdentifiers;

		@XmlAttribute(name = "formats")
		List<Format> mFormats;
		
		@XmlAttribute(name = "companies")
		List<Company> mCompanies;
		
		@XmlAttribute(name = "videos")
		List<Video> mVideos;
	}

	public static class Series
	{
		@XmlAttribute(name = "id")
		public int mId;

		@XmlAttribute(name = "resource_url")
		public String mResourceUrl;

		@XmlAttribute(name = "catno")
		public String mCatNo;

		@XmlAttribute(name = "name")
		public String mName;

		@XmlAttribute(name = "entity_type")
		public String mEntityType;
	}

	public static class Label
	{
		@XmlAttribute(name = "id")
		public int mId;

		@XmlAttribute(name = "resource_url")
		public String mResourceUrl;

		@XmlAttribute(name = "catno")
		public String mCatNo;

		@XmlAttribute(name = "name")
		public String mName;

		@XmlAttribute(name = "entity_type")
		public String mEntityType;

		@XmlAttribute(name = "entity_type_name")
		public String mEntityTypeName;
	}

	public static class Artist
	{
		@XmlAttribute(name = "join")
		public String mJoin;

		@XmlAttribute(name = "name")
		public String mName;

		@XmlAttribute(name = "anv")
		public String mAnv;

		@XmlAttribute(name = "tracks")
		public String mTracks;

		@XmlAttribute(name = "role")
		public String mRole;

		@XmlAttribute(name = "resource_url")
		public String mResourceUrl;

		@XmlAttribute(name = "id")
		public int mId;
	}

	public static class Image
	{
		@XmlAttribute(name = "uri")
		public String mUri;

		@XmlAttribute(name = "height")
		public int mHeight;

		@XmlAttribute(name = "width")
		public int mWidth;

		@XmlAttribute(name = "resource_url")
		public String mResource;

		@XmlAttribute(name = "type")
		public String mType;

		@XmlAttribute(name = "uri150")
		public String mUri150;
	}

	public static class Track
	{
		@XmlAttribute(name = "duration")
		public String mDuration;

		@XmlAttribute(name = "position")
		public String mPosition;

		@XmlAttribute(name = "title")
		public String mTitle;
		
		@XmlAttribute(name = "artists")
		List<Artist> mArtists;
		
		@XmlAttribute(name = "extraartists")
		List<Artist> mExtraArtists;
	}

	public static class Identifier
	{
		@XmlAttribute(name = "type")
		public String mType;

		@XmlAttribute(name = "value")
		public String mValue;
		
		@XmlAttribute(name = "description")
		public String mDescription;
	}

	public static class Format
	{
		@XmlAttribute(name = "descriptions")
		List<String> mDescriptions;

		@XmlAttribute(name = "name")
		public String mName;

		@XmlAttribute(name = "qty")
		public String mQuantity;
		
		@XmlAttribute(name = "text")
		public String mText;
	}
	
	public static class Company
	{
		@XmlAttribute(name = "name")
		public String mName;
		
		@XmlAttribute(name = "entity_type")
		public String mEntityType;
		
		@XmlAttribute(name = "catno")
		public String mCatNo;
		
		@XmlAttribute(name = "resource_url")
		public String mResource;
		
		@XmlAttribute(name = "id")
		public int mId;
		
		@XmlAttribute(name = "entity_type_name")
		public String mEntityTypeName;
	}
	
	public static class Video
	{
		@XmlAttribute(name = "duration")
		public int mDuration;
		
		@XmlAttribute(name = "description")
		public String mDescription;
		
		@XmlAttribute(name = "embed")
		public boolean mEmbed;
		
		@XmlAttribute(name = "uri")
		public String mUri;
		
		@XmlAttribute(name = "title")
		public String mTitle;
	}

}
