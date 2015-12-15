package com.nunc.Homewised.activity.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.HttpConnection;
import com.nunc.Homewised.activity.PathJSONParser;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nunc on 26-11-2015.
 */
public class RouteMap extends Fragment implements GoogleMap.OnMyLocationChangeListener {
   // static final LatLng STARTING = new LatLng(17.450504, 78.380961);
    static final LatLng ENDING = new LatLng(17.4482335, 78.3830587);

    MapView mMapView;
    private GoogleMap googleMap;
    private TextView textView;
    private Marker myLocationMarker;
    private static BitmapDescriptor markerIconBitmapDescriptor;
    Activity activity;
    MarkerOptions mymarker;
    public RouteMap() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_routemap,
                container, false);
        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        activity=getActivity();

        mMapView.onResume();// needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }


        setUpMapIfNeeded();



        // create marker
  /*      MarkerOptions marker = new MarkerOptions().position(HAMBURG).title("Start Map ").snippet("Hitec City");

        Marker kiel = googleMap.addMarker(new MarkerOptions().position(KIEL).title("End Map").snippet("Ameerpet")
                .icon(BitmapDescriptorFactory
                        .fromResource(R.drawable.mapmarker)));

        // Changing marker icon
        marker.icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));*/



       /* // adding marker
        googleMap.addMarker(marker);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(HAMBURG).zoom(12).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
*/
        // Perform any camera updates here
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    private String getDirectionsUrl(LatLng origin,LatLng dest){

        // Origin of route
        String str_origin = "origin="+origin.latitude+","+origin.longitude;

        // Destination of route
        String str_dest = "destination="+dest.latitude+","+dest.longitude;

        // Sensor enabled
        String sensor = "sensor=false";

        // Building the parameters to the web service
        String parameters = str_origin+"&"+str_dest+"&"+sensor;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;

        return url;
    }





    private void addMarkers(LatLng myLocation,LatLng destination) {
        if (googleMap != null) {
            googleMap.clear();
            mymarker=new MarkerOptions().position(myLocation).snippet("Hitec City")
                    .title("Starting Point").icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.startmapicon));
            googleMap.addMarker(mymarker);
            // ENDING marker
            googleMap.addMarker(new MarkerOptions().position(destination).snippet("Secunderabad")
                    .title("Ending Point").icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.mapmarker)));




            // STARTING marker


        }
    }

    private class ReadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... url) {
            String data = "";
            try {
                HttpConnection http = new HttpConnection();
                data = http.readUrl(url[0]);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            new ParserTask().execute(result);
        }
    }

    private class ParserTask extends
            AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        @Override
        protected List<List<HashMap<String, String>>> doInBackground(
                String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                PathJSONParser parser = new PathJSONParser();
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> routes) {
            ArrayList<LatLng> points = null;
            PolylineOptions polyLineOptions = null;

            // traversing through routes
            for (int i = 0; i < routes.size(); i++) {
                points = new ArrayList<LatLng>();
                polyLineOptions = new PolylineOptions();
                List<HashMap<String, String>> path = routes.get(i);

                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                polyLineOptions.addAll(points);
                polyLineOptions.width(4);
                polyLineOptions.color(Color.BLUE);
            }

            googleMap.addPolyline(polyLineOptions);
        }
    }


    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (googleMap == null) {
            googleMap = mMapView.getMap();
            this.googleMap.getUiSettings().setMyLocationButtonEnabled(false);
            this.googleMap.setMyLocationEnabled(true);

            googleMap.setOnMyLocationChangeListener(this);
           // googleMap.setOnMyLocationChangeListener(getActivity().this);
            // Check if we were successful in obtaining the map.

        }
    }
    @Override
    public void onMyLocationChange(Location location) {
        // Remove the old marker object
   //     myLocationMarker.remove();

        // Add a new marker object at the new (My Location dot) location


        if (googleMap != null) {

            markerIconBitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.mapmarker);

            LatLng myLocation=new LatLng(location.getLatitude(),location.getLongitude());



            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(myLocation).zoom(16).build();
            googleMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));
            String url = getDirectionsUrl(myLocation,ENDING);
            ReadTask downloadTask = new ReadTask();
            downloadTask.execute(url);

            addMarkers(myLocation,ENDING);



        }
    }


}


