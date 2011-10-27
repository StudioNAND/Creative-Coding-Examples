/**
 * This example introduces the basic principles of using Arraylists with toxiclibs’ Vec2D class
 *
 * INCLUDES: adding, replacing and removing elements in the ArrayList
 * comparing two Vec2D's
 *
 * Please download toxiclibs core before using this example:
 * http://hg.postspectacular.com/toxiclibs/downloads/toxiclibs-complete-0020.zip
 * 
 */

// we need to import the package Vec2D belongs to, in order to use it
import toxi.geom.*;

// we need to import the class ArrayList to use it
import java.util.ArrayList;

//declaration of a ArrayList with the type Vec2D
private ArrayList<Vec2D> vecList; 

void setup() {		
  size( 400, 400 );
  smooth( );

  //create a new empty ArrayList
  vecList = new ArrayList<Vec2D>();
}

void draw() {
  background( 33 );

  //for each element in the ArrayList
  for ( int i=1; i < vecList.size(); i++ ) {	

    //draw an ellipse at every Vec2D position in the ArrayList
    fill( 255, 175 );
    noStroke();
    ellipse( vecList.get( i ).x, vecList.get( i ).y,  5, 5 );

    //draw a line from the last to the second last Vec2D in the ArrayList
    stroke( 255, 175 );
    line ( vecList.get( i ).x, vecList.get( i ).y, vecList.get( i - 1 ).x, vecList.get( i - 1 ).y );
  }
}

public void mouseReleased() {

  //get the mouse position as a Vec2D
  Vec2D mousePosition = new Vec2D( mouseX, mouseY );
  
  //for each element in the ArrayList
  for (int i = 0; i < vecList.size(); i++) {
    //compare the mouse position Vec2D with the elements in the list with a certain tolerance
    if( mousePosition.equalsWithTolerance( vecList.get( i ), 20 ) == true ) {
      
      /* If they equal each other:
       * OPTION A: set reposition the Vec2D to the current mouse position with the given tolerance
       */ 
      vecList.set( i, mousePosition );
      
       /* 
       * OPTION B: remove the Vec2D which equals the mouse position with the given tolerance
       */ 
      //vecList.remove( i );
      //exit method
      return;
    }
  }
  //If both Vec2D are not similar, add a new Vec2D at the current mouse position to the ArrayList
  vecList.add( mousePosition );
  
  //print the size og the ArrayList
  println( vecList.size() );
}
/**
 * This example introduces the basic principles of using Arraylists with toxiclibs’ Vec2D class
 *
 * INCLUDES: adding, replacing and removing elements in the ArrayList
 * comparing two Vec2D's
 *
 * Please download toxiclibs core before using this example:
 * http://hg.postspectacular.com/toxiclibs/downloads/toxiclibs-complete-0020.zip
 * 
 */

// we need to import the package Vec2D belongs to, in order to use it
import toxi.geom.*;

// we need to import the class ArrayList to use it
import java.util.ArrayList;

//declaration of a ArrayList with the type Vec2D
private ArrayList<Vec2D> vecList; 

void setup() {		
  size( 400, 400 );
  smooth( );

  //create a new empty ArrayList
  vecList = new ArrayList<Vec2D>();
}

void draw() {
  background( 33 );

  //for each element in the ArrayList
  for ( int i=1; i < vecList.size(); i++ ) {	

    //draw an ellipse at every Vec2D position in the ArrayList
    fill( 255, 175 );
    noStroke();
    ellipse( vecList.get( i ).x, vecList.get( i ).y,  5, 5 );

    //draw a line from the last to the second last Vec2D in the ArrayList
    stroke( 255, 175 );
    line ( vecList.get( i ).x, vecList.get( i ).y, vecList.get( i - 1 ).x, vecList.get( i - 1 ).y );
  }
}

public void mouseReleased() {

  //get the mouse position as a Vec2D
  Vec2D mousePosition = new Vec2D( mouseX, mouseY );
  
  //for each element in the ArrayList
  for (int i = 0; i < vecList.size(); i++) {
    //compare the mouse position Vec2D with the elements in the list with a certain tolerance
    if( mousePosition.equalsWithTolerance( vecList.get( i ), 20 ) == true ) {
      
      /* If they equal each other:
       * OPTION A: set reposition the Vec2D to the current mouse position with the given tolerance
       */ 
      vecList.set( i, mousePosition );
      
       /* 
       * OPTION B: remove the Vec2D which equals the mouse position with the given tolerance
       */ 
      //vecList.remove( i );
      //exit method
      return;
    }
  }
  //If both Vec2D are not similar, add a new Vec2D at the current mouse position to the ArrayList
  vecList.add( mousePosition );
  
  //print the size og the ArrayList
  println( vecList.size() );
}

