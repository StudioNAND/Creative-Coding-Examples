/**
 * This example introduces the basic principles of using Arraylists with toxiclibs’ Vec2D class
 *
 * INCLUDES: adding and replacing elements in the ArrayList, clearing an ArrayList
 * circle subdivision
 *
 * Please download toxiclibs core before using this example:
 * http://hg.postspectacular.com/toxiclibs/downloads/toxiclibs-complete-0020.zip
 * 
 */

// we need to import the package Vec2D belongs to, in order to use it
import toxi.geom.*;

// we need to import the class ArrayList to use it
import java.util.ArrayList;

//the radius of the circle
private static float RADIUS = 150;

//the ArrayList holding the Vec2D on the circle
private ArrayList<Vec2D> points;

//counter
private int cnt;

public void setup() {		
  size( 400, 400 );
  smooth( );	

  //create an empty ArrayList	  
  pointsOnCircle = new ArrayList<Vec2D>();
}

void draw() {
  background( 33 );
  noFill();
  stroke( 255 );

  //for every point on the circle
  for( int i=0; i < pointsOnCircle.size() -1; i++ ) {	
    fill( 255, 175 );
    ellipse( pointsOnCircle.get(i).x, pointsOnCircle.get(i).y, 5,  5 );

    noFill();
    stroke( 255, 175 );
    line( pointsOnCircle.get(i).x, pointsOnCircle.get(i).y, pointsOnCircle.get( i+1 ).x, pointsOnCircle.get( i+1 ).y );
  }

  //draw the first point and connect the first and the last point with a line
  if( pointsOnCircle.size() > 0 ) {
    line( pointsOnCircle.get( 0 ).x, pointsOnCircle.get( 0 ).y, pointsOnCircle.get( pointsOnCircle.size()-1 ).x, pointsOnCircle.get( pointsOnCircle.size()-1 ).y );
    fill( 255, 175 );
    ellipse( pointsOnCircle.get( pointsOnCircle.size()-1 ).x, pointsOnCircle.get( pointsOnCircle.size()-1 ).y, 5,  5 );
  }
}

void mousePressed() {
  //increase counter
  if (mouseButton == LEFT) {
    cnt ++;
  }
  //decrease counter
  if (mouseButton == RIGHT) {
    cnt --;
  }
  //clear the ArrayList
  pointsOnCircle.clear();
  
  //calculate the position on the circle
  for( int i=0; i < cnt; i++ ) { 
    float angle = TWO_PI/cnt;
    float x = RADIUS*sin(angle * i)+width/2;
    float y = RADIUS*cos(angle * i)+height/2;
    Vec2D v = new Vec2D( x, y );
    pointsOnCircle.add(v);
  }
}

