package fhnw.matrixrenderer;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;

public class MatrixRenderer {
	
	public static final int RENDER_MODE_TILES	= 1;
	public static final int RENDER_MODE_ALLEY	= 2;
	public static final int RENDER_MODE_MUXED	= 3;
	
	public static final int RENDER_NO_IDS		= 11;
	public static final int RENDER_IDS			= 12;
	
	public static final int RENDER_NO_GRID		= 21;
	public static final int RENDER_GRID			= 22;
	
	
	private PFont fontIds						= null;
	
	private int renderMode						= RENDER_MODE_TILES;
	
	private boolean showGrid					= false;
	private boolean showIds						= false;
	
	private PApplet applet						= null;
	private ArrayList<IMatrixSpace> spaces		= null;
	
	private int numColumns						= 19;
	private int numRows							= 3;
	
	private int cellWidth						= 224;
	private int cellHeight						= 144;
	
	private int gutterX							= 54;
	private int gutterY							= 136;
	
	private PGraphics gTiles					= null;
	private PGraphics gMuxed					= null;
	
	
	public MatrixRenderer (PApplet theApplet) {
		init (theApplet, 19, 3, 224, 144, 54, 136);
	}
	
	public MatrixRenderer (PApplet theApplet, int theColumnNum, int theRowNum, int theCellWidth, int theCellHeight, int theGutterX, int theGutterY) {
		init (theApplet, theColumnNum, theRowNum, theCellWidth, theCellHeight, theGutterX, theGutterY);
	}
	
	/**
	 * 
	 * @param theApplet Main PApplet sketch instance (should be this parent)
	 * @param theColumnNum Total number of columns
	 * @param theRowNum Total number of rows
	 * @param theCellWidth Single cell width
	 * @param theCellHeight Single cell height
	 */
	private void init (PApplet theApplet, int theColumnNum, int theRowNum, int theCellWidth, int theCellHeight, int theGutterX, int theGutterY) {
		applet = theApplet;
		
		// Set custom number of rows and colls
		numColumns = theColumnNum;
		numRows = theRowNum;
		
		// Set custom cell size
		cellWidth = theCellWidth;
		cellHeight = theCellHeight;
		
		gutterX = theGutterX;
		gutterY = theGutterY;
		
		// Initialise array list for all
		// spaces that will be registerd 
		// within the PApplet setup.
		spaces = new ArrayList<IMatrixSpace> ();
		
		int tiledWidth = (cellWidth + gutterX) * numColumns;
		int tiledHeight = (cellHeight + gutterY) * numRows - gutterY;
		
		gTiles = applet.createGraphics (tiledWidth, tiledHeight, PGraphics.P2D);
	}
	
	public void draw () {
		
		// Start drawing in tiled canvas
		gTiles.beginDraw ();
		gTiles.background (80);
		gTiles.noFill ();
		gTiles.noStroke ();
		
		// For every MatrixSpace...
		for (int i=0; i < spaces.size (); i++) {
			
			// If MatrixSpace shall be rendered
			if (spaces.get (i).isVisible ()) {
				
				// Update space position
				spaces.get (i).position (
					cellPositionX (spaces.get (i).column ()), 
					cellPositionY (spaces.get (i).row ())
				);
				// Update space size
				spaces.get (i).size (
					spaces.get (i).numColumns () * cellWidth,
					spaces.get (i).numRows () * cellHeight
				);
				
				if (!spaces.get (i).isAbsolute ()) {
					gTiles.pushMatrix ();
					gTiles.translate (spaces.get (i).positionX (), spaces.get (i).positionY ());
				}
				
				// Execute space filters and draw
				spaces.get (i).beforeDraw ();
				spaces.get (i).draw (gTiles);
				spaces.get (i).afterDraw ();
				
				if (!spaces.get (i).isAbsolute ())
					gTiles.popMatrix ();
			}
		}
		
		// Stop drawing in tiled canves
		gTiles.endDraw ();
		
		if (showGrid) {
			
			// If render mode TILES is turned on - draw special
			// square grid framing each tile; leaving the gutter
			// visible...
			if (renderMode == RENDER_MODE_TILES) {
				
				gTiles.beginDraw ();
				gTiles.noFill ();
				gTiles.strokeWeight (3);
				gTiles.stroke (255, 0, 0);
				
				for (int x=0; x < numColumns; x++)
					for (int y=0; y < numRows; y++)
						gTiles.rect (cellPositionX (x), cellPositionY (y), cellWidth, cellHeight);
					
				gTiles.endDraw ();
				
			// If render mode != TILES, draw simple line 
			// grid since the image has been muxed anyway.
			}else{
				gMuxed.stroke (84, 242, 184);
				// Draw vertical lines for each cell; left-right
				for (int x=0; x < numColumns; x++)
					gMuxed.line (x * cellWidth, 0, x * cellWidth, gMuxed.height);
				
				// Draw last line at the right side of the sketch
				gMuxed.line (gMuxed.width-1, 0, gMuxed.width-1, gMuxed.height);
				
				// Draw horizontal lines for each cell; top-bottom
				for (int y=0; y < numRows; y++)
					gMuxed.line (0, y * cellHeight, gMuxed.width, y * cellHeight);
				
				// Draw last line at the bottom of the sketch
				gMuxed.line (0, gMuxed.height-1, gMuxed.width, gMuxed.height-1);
			}
		}
		
		switch (renderMode) {
			case RENDER_MODE_TILES:
				transformGraphicsToScreen (gTiles);
				break;
			case RENDER_MODE_MUXED:
				transformGraphicsToScreen (gMuxed);
				break;
		}
		
		
		/*
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
		*/
	}
	
	/**
	 * Adds an IMatrixSpace to the render stack.
	 * @param theSpace Space to add.
	 * @return Returns <i>true</i> if the space has been
	 * added to the stack; or <i>false</i> if the space
	 * is allready in the list or could not be added.
	 */
	public boolean addSpace (IMatrixSpace theSpace) {
		if (!spaces.contains (theSpace)) {
			return spaces.add (theSpace);
		}
		return false;
	}
	
	/**
	 * Removes an IMatrixSpace from the render stack.
	 * @param theSpace Space to remove.
	 * @return Remove <i>true</i> if the space has been
	 * removed sucessfully; otherwise <i>false</i>.
	 */
	public boolean removeSpace (IMatrixSpace theSpace) {
		return spaces.remove (theSpace);
	}
	
	/**
	 * Height of each cell.
	 * @return Cell height in pixel.
	 */
	public int cellHeight () {
		return cellHeight;
	}
	
	/**
	 * Width of each cell.
	 * @return Cell width in pixel.
	 */
	public int cellWidth () {
		return cellWidth;
	}
	
	/**
	 * Position of a cell in tile-mode (before mux) on 
	 * the x-axis in pixel for a specific cell id.
	 * @param theColumnId ID of the cell from left-right (0-18)
	 * @return Position on the x-axis in pixel
	 */
	public int cellPositionX (int theColumnId) {
		if (theColumnId < 14) {
			return (cellWidth + gutterX) * theColumnId;
		}
		return (cellWidth + gutterX) * theColumnId + gutterX;
	}
	
	public int cellPositionY (int theRowId) {
		return (cellHeight + gutterY) * theRowId;
	}
	
	/**
	 * Number of columns in total.
	 * @return Column number as integer.
	 */
	public int columns () {
		return numColumns;
	}
	
	/**
	 * Number of rows in total.
	 * @return Row number as integer.
	 */
	public int rows () {
		return numRows;
	}
	
	/**
	 * Method returns the with of a column
	 * gutter for a specific id. This goes from 
	 * 0-18 (#14 is the only exception so far).
	 * 
	 * @param theColumnId Gutter ID on the x-axis
	 * from 0-18
	 * @return Gutter with in pixel
	 */
	public int gutterAtColumn (int theColumnId) {
		// Corner (Greifengasse/Utengasse)
		// is the only exception; and has 
		// twice the with of a usual column
		if (theColumnId == 14) {
			return 108;
		}
		return gutterX;
	}
	
	public void transformGraphicsToScreen (PGraphics theG) {
		
		if (theG.width == applet.width && theG.height == applet.height) {
			applet.image (theG, 0, 0);
		}else{
			
			float ratio = theG.width / theG.height;
			
			if (theG.width > applet.width) {
				applet.image (theG, 0, 0, applet.width, applet.width / ratio);
				return;
			}
			
			if (theG.height > applet.height) {
				applet.image (theG, 0, 0, applet.width * ratio, applet.height);
				return;
			}
		}
	}
	
	/**
	 * Method returns the height of a row gutter
	 * for a specific id. So far both y-gutter have
	 * the same height.
	 * 
	 * @param theRowId Gutter ID on the y-axis from 0-1
	 * @return Gutter height in pixel
	 */
	public int gutterAtRow (int theRowId) {
		return gutterY;
	}
	
	/**
	 * Sets the a render property.
	 * @param theMode
	 */
	public void setMode (int theMode) {
		switch (theMode) {
			case RENDER_MODE_TILES: renderMode = RENDER_MODE_TILES; break;
			case RENDER_MODE_MUXED: renderMode = RENDER_MODE_MUXED; break;
			case RENDER_MODE_ALLEY: renderMode = RENDER_MODE_ALLEY; break;
			
			case RENDER_NO_GRID: showGrid = false; break;
			case RENDER_GRID: showGrid = true; break;
			
			case RENDER_NO_IDS: showIds = false; break;
			case RENDER_IDS: showIds = true; break;
		}
	}
	
	public boolean showsGrid () {
		return showGrid;
	}
	
	public boolean showsIds () {
		return showIds;
	}
}
