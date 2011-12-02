
// a simple sketch, which draws a line
// depending on a jqueryUI slider embedded into
// the html template

float xPos = 0;

void setup()
{
  size( 960, 200 );
  background( 100 );
  stroke( 255 );
}

void draw()
{
  background( 100 );
  line( xPos, 0, xPos, height );
}

// this method will be called from the jqueryUI 
// slider 'outside' of this application
void slideEvent( float value )
{
  xPos = width * value;
}
