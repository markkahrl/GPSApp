package gps.sat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.TextView;

public class GPSActivity extends Activity implements LocationListener
{
	private LocationManager locManager;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0.0f, this);
    }
    
    ///////// LocationListener interface
    public void onLocationChanged(Location location)
    {
    	String alt = location.getAltitude()+"";
    ///	String alt = new Double(location.getAltitude()).toString();
    	TextView atv = (TextView) findViewById(R.id.altitude);
    	atv.setText(alt);
    	
    	String lat = location.getLatitude()+"";
    	TextView ltv = (TextView) findViewById(R.id.latitude);
    	ltv.setText(lat);
    }

	public void onProviderDisabled(String provider) 
	{
		
	}
	
	public void onProviderEnabled(String provider)
	{
		
	}
	
	public void onStatusChanged(String provider, int status, Bundle extras)
	{
		
	} 
    ////////// end LocationListner interface
}
