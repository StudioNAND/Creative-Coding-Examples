//
//  HCMViewController.h
//  HelloCloudMade

#import <UIKit/UIKit.h>
#import "RMMapView.h"

@interface HCMViewController : UIViewController {
    IBOutlet RMMapView* mMapView;
}

@property (weak, nonatomic) IBOutlet UIView *mView;
@property (weak, nonatomic) IBOutlet RMMapView *mMapView;

-(void) addMarkerAt:(CLLocationCoordinate2D) location;

@end
