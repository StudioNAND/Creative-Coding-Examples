package fhnw.matrixrenderer.test;

import fhnw.matrixrenderer.renderer.MatrixField;
import processing.core.PGraphics;


public class RedField extends MatrixField {
	
	public RedField (int theColumn, int theRow) {
		super (theColumn, theRow);
	}
	
	public void draw (PGraphics theG) {
		theG.fill (255, 0, 0);
		theG.rect (0, 0, sizeX, sizeY);
	}
}
