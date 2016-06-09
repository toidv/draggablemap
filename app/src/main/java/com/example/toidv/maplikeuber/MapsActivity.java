package com.example.toidv.maplikeuber;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements
        OnMapReadyCallback,
        MapWrapperLayout.OnDragListener,
        GoogleMap.OnCameraChangeListener {

    private GoogleMap mMap;
    private boolean isCompletedMove;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        CustomMapFragment mapFragment = (CustomMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.setOnDragListener(this);
        mapFragment.getMapAsync(this);
        handler = new Handler();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnCameraChangeListener(this);
        LatLng home = new LatLng(21.001319, 105.835782);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(home, 15f));
    }

    @Override
    public void onDrag(MotionEvent e) {
        if (e.getAction() == MotionEvent.ACTION_UP) {
            isCompletedMove = true;
        } else {
            isCompletedMove = false;
        }
    }

    @Override
    public void onCameraChange(CameraPosition cameraPosition) {
        if (isCompletedMove) {

            mMap.clear();
            addMarker();

        }
    }

    private void addMarker() {
        // Simulate as load from backend
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                LatLng marker1 = new LatLng(21.002113, 105.836361);
                LatLng marker2 = new LatLng(21.002298, 105.835343);
                mMap.addMarker(new MarkerOptions().position(marker1).title("Marker1"));
                mMap.addMarker(new MarkerOptions().position(marker2).title("Marker2"));
            }
        }, 500);


    }
}
