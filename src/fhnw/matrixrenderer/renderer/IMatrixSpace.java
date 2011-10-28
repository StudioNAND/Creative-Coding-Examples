package fhnw.matrixrenderer.renderer;

import processing.core.PGraphics;

public interface IMatrixSpace {
	
	public void afterDraw ();
	public void beforeDraw ();
	public void draw (PGraphics theG);
	
	public boolean isVisible ();
	public void isVisible (boolean theVisibleFlag);
	
	public boolean isAbsolute ();
	public void isAbsolute (boolean theAbsoluteFlag);
	
	public int numColumns ();
	public int numRows ();
	
	public void position (int theX, int theY);
	public void size (int theX, int theY);
	
	public int column ();
	public int row ();
	
	public int positionX ();
	public int positionY ();
	
	public int sizeX ();
	public int sizeY ();
}