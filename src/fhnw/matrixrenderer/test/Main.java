package fhnw.matrixrenderer.test;

import java.util.Vector;

import fhnw.matrixrenderer.renderer.MatrixRenderer;
import fhnw.matrixrenderer.renderer.MatrixSpace;

import processing.core.PApplet;


public class Main extends PApplet {

	private MatrixRenderer render;
	private Vector<MatrixSpace> spaces;
	
	public void setup () {
		size (800, 600);
		render = new MatrixRenderer (this, 8, 6);
		
		render.addSpace (new RedField (0, 0));
		render.addSpace (new RedField (1, 2));
		render.addSpace (new BigArea (3, 1, 3, 4));
	}
	
	public void draw () {
		background (0);
		render.draw ();
	}
	
	public void keyPressed () {
		switch (keyCode) {
			case 73: render.showIds (!render.showIds ()); break;
			case 71: render.showGrid (!render.showGrid ()); break;
		}
	}
}