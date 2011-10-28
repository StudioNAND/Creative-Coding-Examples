package fhnw.matrixrenderer.test;

import fhnw.matrixrenderer.renderer.MatrixArea;
import processing.core.PGraphics;


public class BigArea extends MatrixArea {
	
	public BigArea (int theColumn, int theRow, int theColumns, int theRows) {
		super (theColumn, theRow, theColumns, theRows);
	}
	
	public void draw (PGraphics theG) {
		theG.fill (0, 0, 205);
		theG.rect (10, 10, sizeX - 20, sizeY - 20);
		
		theG.stroke (255, 255, 0);
		theG.line (0, 0, sizeX, sizeY);
	}
}
