
ArrayList<Transport> transports;

void setup()
{ 
  size( 400, 400 );
  background( 255, 255, 0 );
  
  transports = new ArrayList<Transport>();
  
  for ( int i = 0; i < 100; i++ )
  {
    int numCustomers = int( random( 5000, 1000000 ) );
    Transport myFakeTransport = new Transport( "Faaake!!!", numCustomers );
    transports.add( myFakeTransport );
  }
}

void draw()
{
  background( 255, 255, 0 );
  translate( width/2, height/2 );
  
  stroke( 0 );
  
  float diagramWidth = width;
  float elementWidth = diagramWidth / float( transports.size() );
  float x = -diagramWidth / 2 + elementWidth / 2;
  for ( Transport myFakeTransport : transports )
  {
    float mappedNumCustomers = map( myFakeTransport.mNumCustomers, 5000, 1000000, 0, 150 ); 
    line( x, -mappedNumCustomers, x, 0 );
    x += elementWidth;
  }
}


