/**
 * This example introduces the use of vectors using toxiclibs’ Vec2D class
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

  // a simple vector
  // it will hold the x & y coordinates for us
  Vec2D aVector = new Vec2D( 50, 70 );
  // we can simply use the vector’s coordinates for drawing and
  // calculation using the 'dot'-Syntax
  stroke( 255 );
  line( 0, 0, aVector.x, aVector.y );
  
  // we also can print or display its values to
  // understand what is going on
  text( "A Vector\n" + aVector, aVector.x, aVector.y - 30 );
  
  // additionally, let’s get the mouse position as a Vec2D
  // we subtract width/2 and height/2 here because (0, 0) is at the center
  // of the screen, remember?
  Vec2D mousePosition = new Vec2D( mouseX - width/2, mouseY - height/2 );
  
  // and draw this with a little text as well
  stroke( 255, 255, 0 );
  line( 0, 0, mousePosition.x, mousePosition.y );
  text( "Mouse Position\n" + mousePosition, mousePosition.x, mousePosition.y - 30 );
}

