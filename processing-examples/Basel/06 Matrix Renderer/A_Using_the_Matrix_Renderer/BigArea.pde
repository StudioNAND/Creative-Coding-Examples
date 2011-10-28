import fhnw.matrixrenderer.MatrixArea;

class BigArea extends MatrixArea {

  BigArea( int column, int row, int columns, int rows )
  {
    super( column, row, columns, rows );
  }

  void draw( PGraphics p5 )
  {
    p5.fill( 107, 0, 216 );
    p5.rect( 10, 10, sizeX - 20, sizeY - 20 );

    p5.stroke( 255, 255, 0 );
    p5.line( 0, 0, sizeX, sizeY );
  }
}

