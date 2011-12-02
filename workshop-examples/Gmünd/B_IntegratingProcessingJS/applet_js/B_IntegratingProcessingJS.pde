/*
 *
 * This example shows how to integrate Processing.js with other elements
 * within the HTML page, such as jQuery & jQueryUI
 * it draws a line which position is controlled by a jQueryUI slider
 *
 * created by Stephan Thiel for the Creative Coding visualization workshop at
 * HfG Schwäbisch Gmünd – Dec 2011
 *
 * http://www.creativecoding.org
 */

float xPos = 0;

void setup()
{
  size( 960, 200 );
  background( 240 );
  stroke( 0 );
}

void draw()
{
  background( 240 );
  line( xPos, 0, xPos, height );
}

// this method will be called from the jqueryUI 
// slider 'outside' of this application
void slideEvent( float value )
{
  xPos = width * value;
}

