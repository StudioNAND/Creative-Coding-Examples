package fhnw.matrixrenderer.renderer;

import processing.core.PGraphics;

public abstract class MatrixSpace implements IMatrixSpace {
	
	/** Space position state (relative or absolute in renderer) */
	private boolean absolute = false;
	/** Space display state */
	private boolean visible = true;
	
	/** Space position as column index from left to right */
	private int column = 0;
	/** Space position as row index, from top to bottom */
	private int row	= 0;
	
	/** Space size in columns */
	private int numColumns = 0;
	/** Space size in rows */
	private int numRows = 0;
	
	/** Space width in pixel */
	public int sizeX = 0;
	/** Space height in pixel */
	public int sizeY = 0;
	
	/** Space x-position in pixel */
	public int positionX = 0;
	/** Space y-position in pixel */
	public int positionY = 0;
	
	/**
	 * Creates a new Matrix Space at a certain position within the
	 * MatrixRenderer grid. The size is defined by number of columns 
	 * and rows.
	 * @param theColumn x position in renderer grid
	 * @param theRow y position in renderer grid
	 * @param theColumnsNum width in columns
	 * @param theRowsNum height in rows
	 */
	public MatrixSpace (int theColumn, int theRow, int theColumnsNum, int theRowsNum) {
		column = theColumn;
		row = theRow;
		numColumns = theColumnsNum;
		numRows = theRowsNum;
	}
	
	/**
	 * Filter method called after each draw() call.
	 */
	public void afterDraw () {
	}

	/**
	 * Filter method called before each draw() call.
	 */
	public void beforeDraw () {
	}
	
	public abstract void draw (PGraphics theG);
	
	/**
	 * Method returns boolean status if coordinates 
	 * within the draw() block will be absolute to the 
	 * whole grid or relative to the space.
	 */
	public boolean isAbsolute () {
		return absolute;
	}
	
	/**
	 * Method sets status if coordinates within the draw() 
	 * block will be absolute to the whole grid or relative 
	 * to the matrix space (area or field).
	 * @param theAbsoluteFlag Set <i>true</i> for absolute; or
	 * <i>false</i> for relative positioning.
	 */
	public void isAbsolute (boolean theAbsoluteFlag) {
		absolute = theAbsoluteFlag;
	}
	
	/**
	 * Method returns boolean status if space (area or field)
	 * shall/will be drawn by the renderer.
	 */
	public boolean isVisible () {
		return visible;
	}

	/**
	 * Method allows to set status if space (area or field)
	 * shall/will be drawn by the renderer.
	 * @param theVisibleFlag Set <i>true</i> for visible; or 
	 * <i>false</i> for hidden.
	 */
	public void isVisible (boolean theVisibleFlag) {
		visible = theVisibleFlag;
	}
	
	/**
	 * Space position on the x-axis in columns.
	 */
	public int column () {
		return column;
	}
	
	/**
	 * Space position on the y-axis in rows.
	 */
	public int row () {
		return row;
	}
	
	/**
	 * Space with in columns.
	 */
	public int numColumns () {
		return numColumns;
	}
	
	/**
	 * Space height in columns.
	 */
	public int numRows () {
		return numRows;
	}
	
	/**
	 * Method sets the space position within the 
	 * matrix grid in columns and rows.
	 * @param theX Position on the x-axis in pixel
	 * @param theY Position on the y-axis in pixel
	 */
	public void position (int theX, int theY) {
		positionX = theX;
		positionY = theY;
	}
	
	/**
	 * Method sets the space size.
	 * @param theX Width in pixel
	 * @param theY Height in pixel
	 */
	public void size (int theX, int theY) {
		sizeX = theX;
		sizeY = theY;
	}
	
	/**
	 * Space position on x-axis in pixel.
	 */
	public int positionX () {
		return positionX;
	}
	
	/**
	 * Space position on y-axis in pixel.
	 */
	public int positionY () {
		return positionY;
	}
	
	/**
	 * Space width in pixel.
	 */
	public int sizeX () {
		return sizeX;
	}
	
	/**
	 * Space height in pixel.
	 */
	public int sizeY () {
		return sizeY;
	}
}