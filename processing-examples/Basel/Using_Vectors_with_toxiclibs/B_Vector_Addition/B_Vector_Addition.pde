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

  // again, the center of our canvas from the previous example
  Vec2D centerOfScreen = new Vec2D( width/2, height/2 );
  // draw this vector
  stroke( 255 );
  line( 0, 0, centerOfScreen.x, centerOfScreen.y );
  text( "Screen Center\n" + centerOfScreen, centerOfScreen.x, centerOfScreen.y - 30 );
  
  // additionally, let’s get the mouse position as a Vec2D
  Vec2D mousePosition = new Vec2D( mouseX, mouseY );
  // and draw it with a little text
  stroke( 255, 255, 0 );
  line( 0, 0, mousePosition.x, mousePosition.y );
  text( "Mouse Position\n" + mousePosition, mousePosition.x, mousePosition.y - 30 );
  
}

