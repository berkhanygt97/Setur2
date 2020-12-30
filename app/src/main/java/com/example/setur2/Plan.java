package com.example.setur2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.setur2.util.MyAdapter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Plan extends Fragment implements OnMapReadyCallback ,
        GoogleApiClient.OnConnectionFailedListener{
    private boolean shouldRefreshOnResume = false;
   private Button button;
   private RecyclerView planListe;
    private   String[] names,texts;
    int[] imgSources;
    private MapView mMapView;
    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";


    private com.example.setur2.Activity tmp[]=new com.example.setur2.Activity[1];



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        int image = (int)R.drawable.sevenhillsgenel;
        com.example.setur2.Activity defaultAct = new com.example.setur2.Activity("Seven Hills Hotel",41.00656387607901, 28.979595690327507,"Your Hotel.",image);

        tmp[0]=defaultAct;
        SavePlan.addToPlan(defaultAct);
        SavePlan.sortPlan();

        final Activity activity = getActivity();
        View view = inflater.inflate(R.layout.fragment_plan_anasayfa, container, false);




        planListe=(RecyclerView)view.findViewById(R.id.activityList);


            int k = SavePlan.plan.length;
            String[] tmpnames =new String[k];
            String[] tmptexts =new String[k];
            int[] tmpimgSources =new int[k];

            for (int i=0 ;i<k;i++){
                tmpnames[i]=SavePlan.plan[i].aName;
                tmptexts[i]=SavePlan.plan[i].text;
                tmpimgSources[i]=SavePlan.plan[i].imageSrc;


            }

            names=tmpnames;
            texts=tmptexts;
            imgSources=tmpimgSources;





        MyAdapter myAdapter = new MyAdapter(activity,names,texts,imgSources);
        planListe.setAdapter(myAdapter);
        planListe.setLayoutManager(new LinearLayoutManager(activity));


        button=(Button)view.findViewById(R.id.planEkle);

        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                SavePlan.plan=tmp;


                Intent intent = new Intent(getActivity(), PlanEklemeMain.class);
                startActivity(intent);
            }
        });

        // map

        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }
        mMapView = (MapView) view.findViewById(R.id.mapView);
        mMapView.onCreate(mapViewBundle);

        mMapView.getMapAsync(this);


       return view;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle);
        }

        mMapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();


    }




    @Override
    public void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mMapView.onStop();


    }

    @Override
    public void onMapReady(GoogleMap map) {

        com.example.setur2.Activity start = SavePlan.plan[0];
        LatLng latLng = new LatLng(start.v,start.v1);
        for (int i = 0 ; i < SavePlan.plan.length;i++){
            com.example.setur2.Activity tmp = SavePlan.plan[i];
            map.addMarker(new MarkerOptions().position(new LatLng(tmp.v, tmp.v1)).title(tmp.aName));



        }



        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,16.0f));

    }




    @Override
    public void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}