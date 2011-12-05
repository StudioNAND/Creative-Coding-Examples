/*
 *
 * This example shows how to load a map created in CloudMade
 * using the Unfolding map library http://unfoldingmaps.org/
 *
 * It additionally depends on GLGraphics http://glgraphics.sourceforge.net/
 *
 * created by Stephan Thiel for the Creative Coding visualization workshop at
 * HfG Schwäbisch Gmünd – Dec 2011
 *
 * http://www.creativecoding.org
 */

import processing.opengl.*;
import codeanticode.glgraphics.*;
import de.fhpotsdam.unfolding.*;
import de.fhpotsdam.unfolding.utils.*;
import de.fhpotsdam.unfolding.providers.*;
import de.fhpotsdam.unfolding.mapdisplay.MapDisplayFactory;

de.fhpotsdam.unfolding.Map map1;

public void setup() {
  size(800, 600, GLConstants.GLGRAPHICS);

  map1 = new de.fhpotsdam.unfolding.Map(this, "map1", 0, 0, width, height, true, false, 
  	new OpenStreetMap.CloudmadeProvider(MapDisplayFactory.OSM_API_KEY, 30635));
  map1.setTweening(false);
  MapUtils.createDefaultEventDispatcher(this, map1);
}

public void draw() {
  background(0);

  map1.draw();
}
