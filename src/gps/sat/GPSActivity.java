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
    private final static String M_FORMAT = "%.1f";
    private final static String LATLON_FORMAT = "%.4f";
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
    	double alt = location.getAltitude();
        String salt = String.format(M_FORMAT, alt);
    	TextView atv = (TextView) findViewById(R.id.altitude);
    	atv.setText(salt);
    	
    	double lat = location.getLatitude();
        String slat = String.format(LATLON_FORMAT, lat);
    	TextView ltv = (TextView) findViewById(R.id.latitude);
    	ltv.setText(slat);
    	
    	double lng = location.getLongitude();
        String slng = String.format(LATLON_FORMAT, lng);
    	TextView lgv = (TextView) findViewById(R.id.longitude);
    	lgv.setText(slng);
    	
    	float ac = location.getAccuracy();
        String acc = String.format(M_FORMAT, ac);
    	TextView accv = (TextView) findViewById(R.id.accuracy);
    	accv.setText(acc);
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
