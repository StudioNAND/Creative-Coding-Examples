
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
	/**
	 * Load label archive file.
	 * 
	 * @param parent The Processing sketch
	 * @param fileName Name and path of the archive file
	 * @return Initialised LabelArchive instance
	 */
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
	
	/**
	 * Label profile text.
	 */
	@XmlAttribute(name = "profile")
	public String mProfile;

	/**
	 * Release list URL
	 */
	@XmlAttribute(name = "releases_url")
	public String mReleasesUrl;

	/**
	 * Label name.
	 */
	@XmlAttribute(name = "name")
	public String mName;

	/**
	 * Discogs label profile page URL.
	 */
	@XmlAttribute(name = "uri")
	public String mUri;

	@XmlAttribute(name = "resource_url")
	public String mResourceUrl;

	/**
	 * Label contact information.
	 */
	@XmlAttribute(name = "contactinfo")
	public String mContactInfo;

	/**
	 * Discogs label ID.
	 */
	@XmlAttribute(name = "id")
	public String mId;

	@XmlAttribute(name = "data_quality")
	public String mDataQuality;

	/**
	 * List of sublabels.
	 */
	@XmlAttribute(name = "sublabels")
	public List<String> mSublabels;

	/**
	 * List of label relevant URLs.
	 */
	@XmlAttribute(name = "urls")
	public List<String> mUrls;

	/**
	 * List of URLs to label relevant images.
	 */
	@XmlAttribute(name = "images")
	public List<Image> mImages;
	
	/**
	 * Label release list.
	 */
	@XmlAttribute(name = "releases")
	public List<Release> mReleases;

	public static class Release
	{
		/**
		 * Publishing year
		 */
		@XmlAttribute(name = "year")
		public int mYear;

		/**
		 * Discogs release ID (unique).
		 */
		@XmlAttribute(name = "id")
		public int mId;
		
		@XmlAttribute(name = "master_id")
		public int mMasterId;

		@XmlAttribute(name = "thumb")
		public String mThumb;
		
		/**
		 * Release title.
		 */
		@XmlAttribute(name = "title")
		public String mTitle;

		@XmlAttribute(name = "status")
		public String mStatus;

		@XmlAttribute(name = "released_formatted")
		public String mReleasedFormatted;

		@XmlAttribute(name = "released")
		public String mReleased;
		
		/**
		 * Release country information.
		 */
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

		/**
		 * List of related styles.
		 */
		@XmlAttribute(name = "styles")
		public List<String> mStyles;

		@XmlAttribute(name = "series")
		public List<Series> mSeries;

		@XmlAttribute(name = "labels")
		public List<Label> mLabels;

		/**
		 * List of involved artists.
		 */
		@XmlAttribute(name = "artists")
		public List<Artist> mArtists;

		@XmlAttribute(name = "images")
		public List<Image> mImages;

		/**
		 * List of related genres.
		 */
		@XmlAttribute(name = "genres")
		public List<String> mGenres;

		@XmlAttribute(name = "extraartists")
		public List<Artist> mExtraArtists;

		@XmlAttribute(name = "tracklist")
		public List<Track> mTracklist;

		@XmlAttribute(name = "identifiers")
		public List<Identifier> mIdentifiers;

		@XmlAttribute(name = "formats")
		public List<Format> mFormats;
		
		@XmlAttribute(name = "companies")
		public List<Company> mCompanies;
		
		@XmlAttribute(name = "videos")
		public List<Video> mVideos;
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
	
	/**
	 * Label information.
	 */
	public static class Label
	{
		/**
		 * Discogs label ID.
		 */
		@XmlAttribute(name = "id")
		public int mId;
		
		@XmlAttribute(name = "resource_url")
		public String mResourceUrl;

		/**
		 * Official label catalog number.
		 */
		@XmlAttribute(name = "catno")
		public String mCatNo;

		/**
		 * Name of the label.
		 */
		@XmlAttribute(name = "name")
		public String mName;

		@XmlAttribute(name = "entity_type")
		public String mEntityType;

		@XmlAttribute(name = "entity_type_name")
		public String mEntityTypeName;
	}

	/**
	 * Artist information.
	 */
	public static class Artist
	{
		@XmlAttribute(name = "join")
		public String mJoin;

		/**
		 * Name of the artist.
		 */
		@XmlAttribute(name = "name")
		public String mName;

		@XmlAttribute(name = "anv")
		public String mAnv;

		@XmlAttribute(name = "tracks")
		public String mTracks;

		/**
		 * Role of the artist.
		 */
		@XmlAttribute(name = "role")
		public String mRole;

		@XmlAttribute(name = "resource_url")
		public String mResourceUrl;

		/**
		 * Discogs artist ID.
		 */
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

	/**
	 * Track information.
	 */
	public static class Track
	{
		/**
		 * Duration (4:48)
		 */
		@XmlAttribute(name = "duration")
		public String mDuration;

		/**
		 * Track position in release track listing.
		 */
		@XmlAttribute(name = "position")
		public String mPosition;

		/**
		 * Name of the track.
		 */
		@XmlAttribute(name = "title")
		public String mTitle;
		
		/**
		 * Performers.
		 */
		@XmlAttribute(name = "artists")
		public List<Artist> mArtists;
		
		/**
		 * Extra performers.
		 */
		@XmlAttribute(name = "extraartists")
		public List<Artist> mExtraArtists;
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
		public List<String> mDescriptions;

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
