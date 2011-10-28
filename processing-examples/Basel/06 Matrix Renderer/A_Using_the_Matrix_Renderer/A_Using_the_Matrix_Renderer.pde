import java.util.ArrayList;

MatrixRenderer render;
ArrayList<MatrixSpace> spaces;

void setup()
{
  size (800, 600);
  render = new MatrixRenderer (this, 8, 6);

  render.addSpace( new RedField( 0, 0 ) );
  render.addSpace( new RedField( 1, 2 ) );
  render.addSpace( new BigArea( 3, 1, 3, 4 ) );
}

void draw()
{
  background( 0 );
  render.draw();
}

void keyPressed()
{
  switch ( keyCode ) {
  case 73: 
    render.showIds ( !render.showIds () ); 
    break;
  case 71: 
    render.showGrid ( !render.showGrid () ); 
    break;
  }
}

