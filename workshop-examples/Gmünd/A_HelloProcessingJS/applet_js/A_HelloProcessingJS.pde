/*
 *
 * A simple sketch drawing a line at the mouse position
 *
 * created by Stephan Thiel for the Creative Coding visualization workshop at
 * HfG Schwäbisch Gmünd – Dec 2011
 *
 * http://www.creativecoding.org
 */

void setup()
{
  size( 960, 200 );
  background( 240 );
  stroke( 0 );
}

void draw()
{
  background( 240 );
  line( mouseX, 0, mouseX, height );
}

