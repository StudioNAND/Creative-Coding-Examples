package fhnw.matrixrenderer.renderer;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PFont;

public class MatrixRenderer {
	
	private PFont fontIds					= null;
	
	private boolean showGrid				= true;
	private boolean showIds					= true;
	
	private PApplet applet					= null;
	private ArrayList<IMatrixSpace> spaces	= null;
	
	private int numColumns					= 0;
	private int numRows						= 0;
	
	private int cellWidth					= 0;
	private int cellHeight					= 0;
	
	public MatrixRenderer (PApplet theApplet, int theColumnNum, int theRowNum) {
		applet = theApplet;
		numColumns = theColumnNum;
		numRows = theRowNum;
		
		cellWidth = applet.width / numColumns;
		cellHeight = applet.height / numRows;
		
		spaces = new ArrayList<IMatrixSpace> ();
	}
	
	public void draw () {
		
		// For every MatrixSpace...
		for (int i=0; i < spaces.size (); i++) {
				
			// If MatrixSpace shall be rendered
			if (spaces.get (i).isVisible ()) {
				
				// Update space position
				spaces.get (i).position (
					spaces.get (i).column () * cellWidth, 
					spaces.get (i).row () * cellHeight
				);
				// Update space size
				spaces.get (i).size (
					spaces.get (i).numColumns () * cellWidth,
					spaces.get (i).numRows () * cellHeight
				);
				
				if (!spaces.get (i).isAbsolute ()) {
					applet.g.pushMatrix ();
					applet.g.translate (spaces.get (i).positionX (), spaces.get (i).positionY ());
				}
				
				// Execute space filters and draw
				spaces.get (i).beforeDraw ();
				spaces.get (i).draw (applet.g);
				spaces.get (i).afterDraw ();
				
				if (!spaces.get (i).isAbsolute ())
					applet.g.popMatrix ();
			}
		}
		
		if (showGrid) {
			applet.g.stroke (84, 242, 184);
			// Draw vertical lines for each cell; left-right
			for (int x=0; x < numColumns; x++)
				applet.g.line (x * cellWidth, 0, x * cellWidth, applet.height);
			// Draw last line at the right side of the sketch
			applet.g.line (applet.width-1, 0, applet.width-1, applet.height);
			
			// Draw horizontal lines for each cell; top-bottom
			for (int y=0; y < numRows; y++)
				applet.g.line (0, y * cellHeight, applet.width, y * cellHeight);
			// Draw last line at the bottom of the sketch
			applet.g.line (0, applet.height-1, applet.width, applet.height-1);
		}
		
		if (showIds) {
			if (fontIds == null) {
				fontIds = applet.createFont ("Courier-Bold", 18, true, new char[]{'0','1','2','3','4','5','6','7','8','9'});
			}
			applet.fill (255, 160);
			applet.textFont (fontIds);
			
			int id=0;
			
			for (int y=0; y < numRows; y++) {
				for (int x=0; x < numColumns; x++) {
					applet.text (id, x * cellWidth + (cellWidth / 2) - (applet.textWidth (id + "") / 2), y * cellHeight +  (cellHeight / 2) + 9);
					id++;
				}
			}
		}
	}
	
	public boolean addSpace (IMatrixSpace theSpace) {
		if (!spaces.contains (theSpace)) {
			return spaces.add (theSpace);
		}
		return false;
	}
	
	public boolean removeSpace (IMatrixSpace theSpace) {
		return spaces.remove (theSpace);
	}
	
	public int cellHeight () {
		return cellHeight;
	}
	
	public int cellWidth () {
		return cellWidth;
	}
	
	public int columns () {
		return numColumns;
	}
	
	public int rows () {
		return numRows;
	}
	
	public boolean showIds () {
		return showIds;
	}
	
	public void showIds (boolean theIdsFlag) {
		showIds = theIdsFlag;
	}
	
	public boolean showGrid () {
		return showGrid;
	}
	
	public void showGrid (boolean theGridFlag) {
		showGrid = theGridFlag;
	}
}
