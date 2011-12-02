/*
 *
 * This example shows how to load static JSON data in the most
 * simple way possible. The JSON data is added to the HTML
 * using a <scrip>-tag. Have a look at the template for more
 * information. For converting .csv, .xls check out Mr. Data Converter
 * http://shancarter.com/data_converter/
 *
 * created by Stephan Thiel for the Creative Coding visualization workshop at
 * HfG Schwäbisch Gmünd – Dec 2011
 *
 * thanks to Shan Carter for Mr. Data Converter and Moritz Stefaner
 * for the inspiration to the general workflow!
 *
 * http://www.creativecoding.org
 */

// a dynamically growing list
// available in Processing.js also
ArrayList<TweetCircle> tweets;

void setup()
{
  size( 960, 600 );
  background( 240 );
  
  // create the empty list
  tweets = new ArrayList<TweetCircle>();
  
  // 'data' is just 'magically' available, since it is
  // included outside of this application in the HTML
  // template. we can just use it
  for ( Object tweet : data.results )
  {
    // add a new TweetCircle at a random position within the canvas
    tweets.add( new TweetCircle( random( 50, width - 50 ), random( 50, height - 50 ), tweet.text ) );
  }
}

void draw()
{
  background( 240 );
  // draw each tweet circle we have in the list
  // this for loop uses Java 5 syntax and is a
  // convenient short form for:
  // for ( int i = 0; i < tweets.size(); i++ ) { … }
  for ( TweetCircle tweetCircle : tweets )
  {
    // draw the circle
    tweetCircle.draw();
  }
}

// this method will be called from jqueryUI 
// 'outside' of this application
void dataLoaded( Object data )
{
    for ( Object tweet : data.results )
    {
      println( tweet.text );
    }
}
// a little generic class
// it draws an ellipse for the tweet it represents
// the size of the ellipse is determined by the
// length of the tweet text
class TweetCircle
{
  // x + y position
  float mX;
  float mY;
  // the size
  float mSize;
  // the color
  color c;
  
  TweetCircle( float x, float y, String msg )
  {
    mX = x;
    mY = y;
    // use Processing’s map function to easily calculate
    // a size between 5 - 50 pixels according to the message
    // length from 0 - 140 characters
    mSize = map( msg.length(), 0, 140, 5, 50 );
    // interpolates between two shades of blue
    // also uses the map function to determine the normalized
    // message length
    c = lerpColor( color( #1C94C4 ), color( #0A3444 ), map( msg.length(), 0, 140, 0, 1 ) );
  }
  
  // simply draws an ellipse at the individual position
  void draw()
  {
    noStroke();
    fill( c );
    ellipse( mX, mY, mSize, mSize );
  }
}

