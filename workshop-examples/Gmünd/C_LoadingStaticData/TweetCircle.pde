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
