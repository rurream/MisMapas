package cl.creative_it_spa.mismapas;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        double latitud;
        double longitud;
        String lugarx;
        Bundle extras = getIntent().getExtras();
        latitud= extras.getDouble("latitud");
        longitud= extras.getDouble("longitud");
        lugarx= extras.getString("lugar");

        // Add a marker in Sydney and move the camera
        LatLng lugar= new LatLng(latitud, longitud);
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icons8_flag_filled__48))
                .position(lugar)
                .title("Marcador en " + lugarx)
                .snippet(lugarx));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(lugar));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                lugar, 2));
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

    }
}
