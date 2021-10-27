package com.mimapitachico2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mimapitachico2021.databinding.ActivityMapsBinding;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    Button BTN;


    EditText CajonLatitud,CajonLongitud,CajonTitulo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BTN = (Button)findViewById(R.id.button);

         CajonLatitud = (EditText)findViewById(R.id.Cajon_Latitud);
         CajonLongitud = (EditText)findViewById(R.id.Cajon_Longitud);
         CajonTitulo = (EditText)findViewById(R.id.Titulo_Marcador);

        /*binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot())*/

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String miTITULO=CajonTitulo.getText().toString();
                double LAT  = Double.parseDouble(CajonLatitud.getText().toString());
                double LON  =  Double.parseDouble(CajonLongitud.getText().toString());
                LatLng posicion = new LatLng(LAT,LON);
                mMap.addMarker(new MarkerOptions().position(posicion).title("miTTITULO"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(posicion));
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                CajonLatitud.setText(latLng.longitude+"");
                CajonLongitud.setText(latLng.longitude+"");
            }
        });
        // Add a marker in Sydney and move the camera
        /*LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
    }
}