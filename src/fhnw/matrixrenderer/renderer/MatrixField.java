package fhnw.matrixrenderer.renderer;


public abstract class MatrixField extends MatrixSpace {
	
	public MatrixField (int theColumn, int theRow) {
		super (theColumn, theRow, 1, 1);
	}
}
