/*
  to create an Area that spans across multiple cells
  we simply extend from the MatrixArea class which provides
  all information necessary to draw inside its space
  
  this class can be extended in whatever way you like
  and as you would with a normal class for drawing complex forms
*/

class BigArea extends MatrixArea
{
  // this is needed for now, you can ignore it
  BigArea( int column, int row, int columns, int rows )
  {
    super( column, row, columns, rows );
  }

  // this is where you draw everything inside the cell(s)
  // the cell measures positions from its local origin,
  // so drawing a rectangle at (10, 10) will place its
  // upper left corner to (10, 10) in the upper left corner
  // on the screen relative to the absolute position of the cell
  
  // sizeX & sizeY are convenience variables that store the 
  // x & y dimension of the cell(s)
  void draw( PGraphics p5 )
  {
    p5.fill( 107, 0, 216 );
    p5.rect( 10, 10, sizeX - 20, sizeY - 20 );

    p5.stroke( 255, 255, 0 );
    p5.line( 0, 0, sizeX, sizeY );
  }
}

