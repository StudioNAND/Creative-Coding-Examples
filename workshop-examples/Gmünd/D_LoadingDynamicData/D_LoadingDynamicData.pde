/*
 *
 * This example shows how to load JSON data with the Twitter Search API
 * using jQuery and pass the results to Processing.js
 *
 *
 * created by Stephan Thiel for the Creative Coding visualization workshop at
 * HfG Schwäbisch Gmünd – Dec 2011
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

// this method will be called from jQueryUI 
// 'outside' of this application whenever we have
// loaded new JSON data from the Twitter API via
// the HTML page
//
// the data is a generic object
void dataLoaded( Object data )
{
  // first, clear all existing tweets
  tweets.clear();
  for ( Object tweet : data.results )
  {
    // add a new TweetCircle at a random position within the canvas
    tweets.add( new TweetCircle( random( 50, width - 50 ), random( 50, height - 50 ), tweet.text ) );
  }
}

