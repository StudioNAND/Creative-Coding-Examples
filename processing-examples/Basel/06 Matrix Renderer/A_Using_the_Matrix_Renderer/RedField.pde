import fhnw.matrixrenderer.MatrixField;

class RedField extends MatrixField
{
  RedField( int column, int row )
  {
    super( column, row );
  }
  
  void draw( PGraphics p5 )
  {
    p5.fill( 227, 193, 21 );
    p5.rect( 0, 0, sizeX, sizeY );
  }
}
