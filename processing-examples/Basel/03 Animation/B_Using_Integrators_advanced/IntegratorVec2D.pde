/**
 *  A simple integrator based on the toxiclibs Vec2D class
 *  It 'extends' this class, which means all functionality of Vec2D
 *  is already built into our Integrator – we can simply use it.
 *  
 *  On top of this functionality we simply add everything we need for 
 *  the integrator. This is a straight forward port from Ben Fry’s
 *  really good book »Visualizing Data«
 *  http://shop.oreilly.com/product/9780596514556.do
 *  
 *  The original examples from this book can be found here:
 *  http://benfry.com/writing/archives/3
 */

// we need to import the package Vec2D belongs to in order to use it
import toxi.geom.*;

class IntegratorVec2D extends Vec2D
{
  Integrator ix;
  Integrator iy;
  
  Vec2D target;

  IntegratorVec2D()
  {
    super();
    initIntegrators();
  }

  IntegratorVec2D( Vec2D pos )
  {
    super( pos );
    initIntegrators();
  }

  IntegratorVec2D( float x, float y )
  {
    super( x, y );
    initIntegrators();
  }

  void initIntegrators()
  {
    ix = new Integrator( x );
    iy = new Integrator( y );
    target = new Vec2D( x, y );
  }

  void target( float x, float y )
  {
	target.set( x, y );
    ix.target( x );
    iy.target( y );
  }

  void target( Vec2D pos )
  {
	target.set( pos );
    ix.target( pos.x );
    iy.target( pos.y );
  }

  Vec2D target()
  {
    return target;
  }

  void value( Vec2D pos )
  {
    ix.set( pos.x );
    iy.set( pos.y );
    set( pos );
  }

  void update()
  {
    ix.update();
    iy.update();

    x = ix.value();
    y = iy.value();
  }

  void attraction( float a )
  {
    ix.attraction( a );
    iy.attraction( a );
  }

  void damping( float d )
  {
    ix.damping( d );
    iy.damping( d );
  }
}

