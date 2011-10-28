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
  
  // SUBTRACTION:
  // this will subtract our vector from our mouse position and return a new one!
  // the result is a vector pointing from our vector towards our mouse position 
  // if you want to subtract something from an existing vector
  // see subSelf() of Vec2D
  Vec2D difference = mousePosition.sub( aVector );
  stroke( 255, 0, 255, 100 );
  line( 0, 0, difference.x, difference.y );
  text( "Difference\n" + difference, difference.x, difference.y - 30 );

  // to put this into perspective we translate the difference vector again
  difference.addSelf( aVector );
  stroke( 255, 0, 255 );
  line( aVector.x, aVector.y, difference.x, difference.y );
}

