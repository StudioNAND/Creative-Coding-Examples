/**
 * This example introduces the basic usage of a custom integrator Vec2D class
 * This integrator interpolates between one position and another based on a 
 * simple physical principle.
 * 
 * While this method isn’t suited for exactly timed animations
 * and transitions it is really easy to use :)
 * 
 * For details look at the Intergrator tab
 * 
 * Please download toxiclibs core before using this example:
 * http://hg.postspectacular.com/toxiclibs/downloads/toxiclibs-complete-0020.zip
 * 
 */

// we want to have one visual element following the mouse
// when we press a mouse button, so this is the posiiton of 
// this element:
IntegratorVec2D integratorPos;

void setup()
{
  size( 400, 400 );
  background( 33 );
  smooth();
  
  // we’ll start in the center of our canvas
  integratorPos = new IntegratorVec2D( width/2, height/2 );
}

void draw()
{
  background( 33 );
  
  // in order to animate the position
  // we need to update its internal position
  // this is where the physics-based movement is calculated
  integratorPos.update();

  // lets draw our visual element
  noStroke();
  fill( 255 );
  // simply access the integrators current, animated position 
  // as you would with a normal Vec2D
  ellipse( integratorPos.x, integratorPos.y, 10, 10 );
  
  // additionally you can access the target position
  // drawing the integrators target
  fill( 255, 255, 0 );
  ellipse( integratorPos.target().x, integratorPos.target().y, 4, 4 );
  stroke( 255, 255, 0, 100 );
  line( integratorPos.x, integratorPos.y, integratorPos.target().x, integratorPos.target().y );
}

void mousePressed()
{
  integratorPos.target( mouseX, mouseY );
}

