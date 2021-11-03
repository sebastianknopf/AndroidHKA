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

    private TextView textView;
    private Button btnToggleLocationService;

    private boolean isLocationServiceRunning;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        this.textView = root.findViewById(R.id.text_home);
        this.btnToggleLocationService = root.findViewById(R.id.btnToggleLocationService);

        this.isLocationServiceRunning = false;

        this.btnToggleLocationService.setOnClickListener(view -> {
            if (!this.isLocationServiceRunning) {
                this.startForegroundService();

                this.btnToggleLocationService.setText("Aufzeichnung Stoppen");
            } else {
                this.stopForegroundService();

                this.btnToggleLocationService.setText("Aufzeichnung Starten");
            }
        });

        /*homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        String infoText = "...";

        textView.setText(infoText);*/

        return root;
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
    }

    private void startForegroundService() {


        this.isLocationServiceRunning = true;
    }

    private void stopForegroundService() {

        this.isLocationServiceRunning = false;
    }

    @SuppressLint("MissingPermission")
    private void startLocationListener() {
        LocationManager locationManager = (LocationManager) this.requireContext().getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                textView.setText(String.format("Lat: %f, Lon: %f", location.getLatitude(), location.getLongitude()));
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }
        };

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, locationListener);
    }
}