/**
 * This example introduces the basic principles of vector addition using toxiclibs’ Vec2D class
 * 
 * Please download toxiclibs core before using this example:
 * http://hg.postspectacular.com/toxiclibs/downloads/toxiclibs-complete-0020.zip
 * 
 */

// we need to import the package Vec2D belongs to in order to use it
import toxi.geom.*;

// press any key to see the result of the
// vector addition
boolean showVectorAddition = false;

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

  // again, our vector from the previous example
  Vec2D aVector = new Vec2D( 50, 70 );

  // we’ll draw a circle at the center of our screen
  noStroke();
  fill( 255 );
  ellipse( 0, 0, 4, 4 );

  // draw this vector
  stroke( 255 );
  line( 0, 0, aVector.x, aVector.y );
  text( "A Vector\n" + aVector, aVector.x, aVector.y - 30 );

  // additionally, let’s get the mouse position as a Vec2D
  // we subtract width/2 and height/2 here because (0, 0) is at the center
  // of the screen, remember?
  Vec2D mousePosition = new Vec2D( mouseX - width/2, mouseY - height/2 );

  // and draw it with a little text
  stroke( 255, 255, 0 );
  line( 0, 0, mousePosition.x, mousePosition.y );
  text( "Mouse Position\n" + mousePosition, mousePosition.x, mousePosition.y - 30 );

  if ( showVectorAddition )
  {
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
  }
}

void keyPressed()
{
  // on/off showing vector addition
  showVectorAddition = !showVectorAddition;
}

