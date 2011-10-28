/**
 * This example introduces the basic principles of vector addition using toxiclibs’ Vec2D class
 * 
 * Please download toxiclibs core before using this example:
 * http://hg.postspectacular.com/toxiclibs/downloads/toxiclibs-complete-0020.zip
 * 
 */

// we need to import the package Vec2D belongs to in order to use it
import toxi.geom.*;

void setup()
{
  size( 400, 400 );
  background( 33 );

  // create a font to use for drawing texts
  PFont f = createFont( "Helvetica", 10 );
  textFont( f );
}

void draw()
{
  // clear the background with a dark grey
  background( 33 );
  // we want the center of our canvas to be at (0, 0). this makes things easier to explain
  translate( width/2, height/2 );

  // we’ll draw a circle at the center of our screen
  noStroke();
  fill( 255 );
  ellipse( 0, 0, 4, 4 );

  // again, our vector from the previous examples
  Vec2D aVector = new Vec2D( 50, 70 );
  stroke( 255 );
  line( 0, 0, aVector.x, aVector.y );

  // our mouse position from the previous examples
  Vec2D mousePosition = new Vec2D( mouseX - width/2, mouseY - height/2 );
  stroke( 255, 255, 0 );
  line( 0, 0, mousePosition.x, mousePosition.y );

  // SCALE:
  // we first need the difference to get a vector pointing 
  // from our vector to our mouse posiiton
  Vec2D difference = mousePosition.sub( aVector );
  // we then need the distance between the two
  // which is simply the magnitude (length) of this vector
  float distVectorMousePos = difference.magnitude();
  // alternatively you could always use the distanceTo method
  // float distVectorMousePos = mousePosition.distanceTo( aVector );
  // if you don’t need the difference vector
  
  // our goal is to have a position at the exact center
  // between both vectors, thus we need to properly scale the
  // difference vector to be at half its previous magnitude
  // again, if you want a new, scaled vector back: use scale( float s ) from Vec2D
  difference.scaleSelf( ( distVectorMousePos / 2 ) / distVectorMousePos );
  // the scaling factor looks a bit cryptic but it is simply 0.5 …
  // the above form simply allows you to insert any desired length instead
  // of ( distVectorMousePos / 2 ), i.e. 50 or 2.34, … 
  // another, more comprehensible (but computationally intensive) approach would
  // be to first 'normalize' the vector (make its length 1) and then simply 
  // scale it to the desired length like so:
  // difference.normalize();
  // difference.scaleSelf( distVectorMousePos / 2 ); 
  
  // we finally need to add aVector to translate the vector back
  // to its desired location
  difference.addSelf( aVector );
  
  // finally draw it relatively to aVector
  stroke( 255, 0, 255 );
  fill( 255, 0, 255 );
  line( aVector.x, aVector.y, difference.x, difference.y );
  ellipse( difference.x, difference.y, 4, 4 );
  fill( 255 );
  text( "Center\n" + difference, difference.x, difference.y - 30 );
}

