class Integrator
{
  float value = 0;
  float vel = 0;
  float accel = 0;
  float force = 0;
  float mass = 1;

  float damping = 0.1;
  float attraction = 0.5;

  boolean targeting;
  float target;

  Integrator()
  {
  }

  Integrator(float v)
  {
    value = v;
  }

  Integrator(float v, float a, float d)
  {
    value = v;
    damping = d;
    attraction = a;
  }

  void set( float v )
  {
    value = v;
  }

  void value( float v )
  {
    value = v;
  }

  float value()
  {
    return value;
  }

  void attraction( float a )
  {
    attraction = a;
  }

  void damping( float d )
  {
    damping = d;
  }

  boolean update()
  {
    if ( targeting )
    {
      force += attraction * ( target - value );
      accel = force / mass;
      vel = ( vel + accel ) * damping;
      value += vel;
      force = 0;
      return ( vel > 0.0001f );
    }
    return false;
  }

  void target( float t )
  {
    targeting = true;
    target = t;
  }

  float target()
  {
    return target;
  }
}

