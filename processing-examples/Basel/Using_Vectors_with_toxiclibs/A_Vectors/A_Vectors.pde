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

  // we create a new vector that points towards the center of the screen
  // using our app’s width and height properties
  // it will hold the x & y coordinates for us
  Vec2D centerOfScreen = new Vec2D( width/2, height/2 );
  
  stroke( 255 );
  // we can simply use its coordinates then for drawing and calculation
  // using the 'dot'-Syntax
  line( 0, 0, centerOfScreen.x, centerOfScreen.y );
  
  noStroke();
  fill( 255 );
  ellipse( centerOfScreen.x, centerOfScreen.y, 4, 4 );
  
  // we also can print or display their values as text to understand
  // what is going on
  text( "Screen Center\n" + centerOfScreen, centerOfScreen.x, centerOfScreen.y - 30 );
}

