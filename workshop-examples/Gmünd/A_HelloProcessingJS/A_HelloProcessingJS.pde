
// a simple sketch, which draws a line
// at the horizontal position of the mouse

void setup()
{
  size( 960, 200 );
  background( 100 );
  stroke( 255 );
}

void draw()
{
  background( 100 );
  line( mouseX, 0, mouseX, height );
}
