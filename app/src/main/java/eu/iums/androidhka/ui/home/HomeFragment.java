package eu.iums.androidhka.ui.home;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textview.MaterialTextView;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.maps.SupportMapFragment;
import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import eu.iums.androidhka.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private MapView mapView;
    private MapboxMap map;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Mapbox.getInstance(this.requireContext(), getString(R.string.mapbox_access_token));

        this.homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        this.mapView = root.findViewById(R.id.mapView);
        //this.mapView.onCreate(savedInstanceState);

        this.mapView.getMapAsync(map -> {
            this.map = map;
            this.map.setStyle(Style.OUTDOORS, new Style.OnStyleLoaded() {
                @Override public void onStyleLoaded(@NonNull Style style) {
                }
            });
        });

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();

        this.mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();

        Permissions.check(this.requireContext(), Manifest.permission.ACCESS_FINE_LOCATION, null, new PermissionHandler() {
            @Override
            public void onGranted() {
                startLocationListener();
            }
        });

        this.mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();

        this.mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();

        this.mapView.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        this.mapView.onDestroy();
    }

    @SuppressLint("MissingPermission")
    private void startLocationListener() {
        LocationManager locationManager = (LocationManager) this.requireContext().getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                setMapPosition(location.getLatitude(), location.getLongitude());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }
        };

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, locationListener);
    }

    private void setMapPosition(double lat, double lon) {
        if (this.map != null) {
            this.map.setCameraPosition(new CameraPosition.Builder()
                    .zoom(12)
                    .target(new LatLng(lat, lon))
                    .tilt(9)
                    .build());

            this.map.addMarker(new MarkerOptions()
                    .position(new LatLng(lat, lon))
                    .title("Koordinaten: " + lat + " ; " + lon));
        }
    }
}