/*
  to create an Area that spans across multiple cells
  we simply extend from the MatrixArea class which provides
  all information necessary to draw inside its space
  
  this class can be extended in whatever way you like
  and as you would with a normal class for drawing complex forms
*/

class RedField extends MatrixField
{
  // this is needed for now, you can ignore it
  RedField( int column, int row )
  {
    super( column, row );
  }
  
  // this is where you draw everything inside the cell
  // the cell measures positions from its local origin,
  // so drawing a rectangle at (10, 10) will place its
  // upper left corner to (10, 10) in the upper left corner
  // on the screen relative to the absolute position of the cell
  
  // sizeX & sizeY are convenience variables that store the 
  // x & y dimension of the cell
  void draw( PGraphics p5 )
  {
    p5.fill( 227, 193, 21 );
    p5.rect( 0, 0, sizeX, sizeY );
  }
}
