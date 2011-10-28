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

// we want to build a flexible rectangle changing its shape
// this could also be extended/modified to allow morphing between
// multiple different shapes
IntegratorVec2D topLeft;
IntegratorVec2D topRight;
IntegratorVec2D bottomLeft;
IntegratorVec2D bottomRight;

float width01 = 300;
float height01 = 50;
float width02 = 50;
float height02 = 300;

boolean shape01 = true;

void setup()
{
  size( 400, 400 );
  background( 33 );
  smooth();
  
  topLeft = new IntegratorVec2D( -width01/2, -height01/2 );
  topRight = new IntegratorVec2D( width01/2, -height01/2 );
  bottomLeft = new IntegratorVec2D( -width01/2, height01/2 );
  bottomRight = new IntegratorVec2D( width01/2, height01/2 );
}

void draw()
{
  background( 33 );
  translate( width/2, height/2 );
  
  // in order to animate the position
  // we need to update its internal position
  // this is where the physics-based movement is calculated
  topLeft.update();
  topRight.update();
  bottomLeft.update();
  bottomRight.update();

  noStroke();
  fill( 255 );
  beginShape();
  vertex( topLeft.x, topLeft.y );
  vertex( topRight.x, topRight.y );
  vertex( bottomRight.x, bottomRight.y );
  vertex( bottomLeft.x, bottomLeft.y );
  endShape();
  
}

void mousePressed()
{
  shape01 = !shape01;
  if ( shape01 )
  {
    topLeft.target( -width01/2, -height01/2 );
    topRight.target( width01/2, -height01/2 );
    bottomLeft.target( -width01/2, height01/2 );
    bottomRight.target( width01/2, height01/2 );
  }
  else
  {
    topLeft.target( -width02/2, -height02/2 );
    topRight.target( width02/2, -height02/2 );
    bottomLeft.target( -width02/2, height02/2 );
    bottomRight.target( width02/2, height02/2 );
  }
}

