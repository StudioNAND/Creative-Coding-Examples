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

  // we create a new vector that points towards the center of the screen
  // using our app’s width and height properties
  // it will hold the x & y coordinates for us
  Vec2D aVector = new Vec2D( 50, 70 );
  
  // we’ll draw a circle at the center of our screen
  noStroke();
  fill( 255 );
  ellipse( 0, 0, 4, 4 );
  
  stroke( 255 );
  // we can simply use its coordinates then for drawing and calculation
  // using the 'dot'-Syntax
  line( 0, 0, aVector.x, aVector.y );
  
  // we also can print or display their values as text to understand
  // what is going on
  textAlign( CENTER );
  text( "A Vector\n" + aVector, 0, -30 );
}

