//
//  HCMViewController.m
//  HelloCloudMade

#import "HCMViewController.h"
#import "RMCloudMadeMapSource.h"
#import "RMMarkerManager.h"

@implementation HCMViewController
@synthesize mView=_mView;
@synthesize mMapView=_mMapView;

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - View lifecycle

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    id cmTilesource = [[RMCloudMadeMapSource alloc] initWithAccessKey:@"YOUR_CLOUDMADE_API_KEY_HERE" styleNumber:46441];
    [[RMMapContents alloc] initWithView:_mMapView tilesource: cmTilesource];
    
    CLLocationCoordinate2D initLocation;
    initLocation.longitude = 11.3288;
    initLocation.latitude  = 50.9762;
    
    [_mMapView moveToLatLong: initLocation];
    [_mMapView.contents setZoom: 14];
    [self addMarkerAt:initLocation];
}

- (void)addMarkerAt:(CLLocationCoordinate2D) markerPosition
{
    UIImage *blueMarkerImage = [UIImage imageNamed:@"mymarker.png"];
    RMMarker *newMarker = [[RMMarker alloc] initWithUIImage:blueMarkerImage anchorPoint:CGPointMake(0.5, 1.0)];
    [_mMapView.contents.markerManager addMarker:newMarker AtLatLong:markerPosition];
}

- (void)viewDidUnload
{
    [self setMMapView:nil];
    [self setMView:nil];
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    // e.g. self.myOutlet = nil;
}

- (void)viewWillAppear:(BOOL)animated
{
    [super viewWillAppear:animated];
}

- (void)viewDidAppear:(BOOL)animated
{
    [super viewDidAppear:animated];
}

- (void)viewWillDisappear:(BOOL)animated
{
	[super viewWillDisappear:animated];
}

- (void)viewDidDisappear:(BOOL)animated
{
	[super viewDidDisappear:animated];
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    // Return YES for supported orientations
    if ([[UIDevice currentDevice] userInterfaceIdiom] == UIUserInterfaceIdiomPhone) {
        return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
    } else {
        return YES;
    }
}

@end
