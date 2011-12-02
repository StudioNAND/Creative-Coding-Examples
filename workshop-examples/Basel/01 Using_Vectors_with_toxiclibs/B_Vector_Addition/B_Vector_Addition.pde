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

  // again, our vector from the previous example
  Vec2D aVector = new Vec2D( 50, 70 );
  stroke( 255 );
  line( 0, 0, aVector.x, aVector.y );

  // our mouse position from the previous example
  Vec2D mousePosition = new Vec2D( mouseX - width/2, mouseY - height/2 );
  stroke( 255, 255, 0 );
  line( 0, 0, mousePosition.x, mousePosition.y );
  
  // ADDITION:
  // this will add both vectors and return a new one!
  // if you want to add something to an existing vector
  // see addSelf() of Vec2D
  Vec2D addition = aVector.add( mousePosition );
  stroke( 255, 0, 255 );
  line( 0, 0, addition.x, addition.y );
  text( "Sum\n" + addition, addition.x, addition.y - 30 );

  // the stuff drawn here is for further explanation:
  // with vector addition, we can translate a given vector
  Vec2D translatedVector = mousePosition.add( aVector );
  Vec2D translatedMousePosition = aVector.add( mousePosition );
  // then we can draw the vector from its new origin
  stroke( 255, 255, 0, 100 );
  line( aVector.x, aVector.y, translatedVector.x, translatedVector.y );
  stroke( 255, 100 );
  line( mousePosition.x, mousePosition.y, translatedMousePosition.x, translatedMousePosition.y );
}
