/**
 * This example is based on Toxi's Attraction 2D example
 * it introduces the basic usage of VerletParticles and Behaviors specifically attraction and deflection. 
 * 
 * USAGE
 * 'n' key adds a particle
 * left mouse click adds attractor
 * right mouse click adds deflector
 */

//import the ArrayList class
import java.util.ArrayList;
//import toxi's geom package for the use of the Vec2D class
import toxi.geom.*;
//import toxi's physics package
import toxi.physics2d.*;
//import toxi's physics behaviors package
import toxi.physics2d.behaviors.*;

//forces can be positive or negative
AttractionBehavior force;
//physics engine
VerletPhysics2D physics;
//stores the forces engine
ArrayList<Vec2D> forceList;
//vec for the position
Vec2D forcePos;
//single particle
VerletParticle2D particle;

void setup() {
  size( 400, 400 );
  smooth( );
  noFill();
  
  // create empty ArrayList to store the forces
  forceList	= new ArrayList<Vec2D>();
  
  //initialise the physics engine 
  physics 	= new VerletPhysics2D();	
  
  //set set global drag behavior
  physics.setDrag( 0.05f );
  
  //create bounds to prevend elements to leave the canvas
  physics.setWorldBounds( new Rect( 0, 0, width, height ));
  
  //add global gravity
  physics.addBehavior( new GravityBehavior(new Vec2D( 0, .05f ) ) );
}


void draw() {
  background( 33 );	
  
  //for each force draw an ellipse
  stroke( 255, 255, 0, 230 );				
  for( Vec2D attractor : forceList ){
    ellipse( attractor.x, attractor.y, 10, 10 );	
  }
  
  //for each particle draw a rectangle
  stroke( 255, 230 );		
  for( VerletParticle2D particle : physics.particles ){
    rect( particle.x, particle.y, 5, 5 );
  }		
  
  //update the simulation
  physics.update();
}

//function that adds a particle
void addParticle() {
  
  particle = new VerletParticle2D( Vec2D.randomVector( ).scale(5).addSelf( random( width ), 0 ) );
  physics.addParticle( particle );
  //add a negative attraction force field around the new particle 
  //AttractionBehavior( theParticle, Radius, Strength, Jitter )
  physics.addBehavior( new AttractionBehavior( particle, 20, -1.2f, 0.01f ) );		  
}

//function that removes a particle
void removeParticle() {	
  //get the last element in the ArrayList to remove it	
  int lastElement = physics.particles.size() -1;
  physics.removeParticle( physics.particles.get( lastElement ) );
}
	
void mousePressed(){		
		
  forcePos = new Vec2D( mouseX, mouseY );
		
  if ( mouseButton == LEFT ){
    //attraction
    force = new AttractionBehavior( forcePos, 50, 0.05f );
  }

  if ( mouseButton == RIGHT ){
    //deflection
    force = new AttractionBehavior( forcePos, 50, - 0.05f );			
  }		
  
  //stor the position and the behavior in their lists
  forceList.add( forcePos );
  physics.addBehavior( force );	
}

void keyPressed(){
  
  if ( key == 'n' ){
    addParticle();
  }
  if ( key == 'r' ){
    removeParticle();
  }
}

