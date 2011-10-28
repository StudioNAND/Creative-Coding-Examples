// we’re using a custom library to organize the renderer for the Manor facade
// the library code is located inside the code folder, its source is available from the
// GitHub repository: https://github.com/studioNAND/Creative-Coding

import fhnw.matrixrenderer.*;

// this is our Matrix Render:
// it provides a convenient mechanism to build little sketches which run
// at a dedicated part on the screen (a window of the Manor building!)
// these dedicated parts (cells) can either fill on screen entirely or
// span across multiple screens via an Area
MatrixRenderer render;

void setup()
{
  // the matrix automatically uses the size of the canvas
  // to make developing sketches easier, we’ll use a lower resolution
  // Standard HD
  size ( 1280, 720 );
  
  // initiallize the renderer with 8 coiumns and 6 rows
  render = new MatrixRenderer ( this, 8, 6 );

  // finally add our custom sketches to individual cells
  // see the tabs called »BigArea« and »RedField« to learn how 
  // to create own custom sketches
  render.addSpace( new RedField( 0, 0 ) );
  render.addSpace( new RedField( 1, 2 ) );
  // add an Area which spans across muliple cells
  render.addSpace( new BigArea( 3, 1, 3, 4 ) );
  
  // lastly: cells also can overlap each other!
  // they are drawn in which ever order they are added to the renderer above
}

void draw()
{
  background( 0 );
  // drawing the renderer will also draw all custom sketches
  // created in setup()
  render.draw();
}

void keyPressed()
{
  // some small controls for drawing debug information
  // of the renderer
  switch ( key )
 {
  case 'i':
  case 'I':
    // press 'i'/'I' to toggle display of cell IDs
    render.showIds ( !render.showIds () ); 
    break;
  case 'g':
  case 'G':
    // press 'g'/'G' to toggle display of the grid
    render.showGrid ( !render.showGrid () ); 
    break;
  }
}

