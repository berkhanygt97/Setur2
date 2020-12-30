package com.example.setur2.util;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.setur2.R;


public class ActivitiesEklemeFragment extends Fragment {
    private RecyclerView activiteListe;
    private   String[] names,texts;
    int imgages[]={R.drawable.sultanahmet,R.drawable.grandbazaar,R.drawable.galata_bridge,R.drawable.gulhaneparki,R.drawable.theodosius,R.drawable.privatocafe,R.drawable.galata,R.drawable.rainbowstairs,R.drawable.sevenhills};

    double v[]={41.005579585412484,41.01103291412176,41.02092470607674,41.01387071606666,41.00748322729857, 41.02702422494224,41.02577702749282,41.029849721937325,41.007247343539696  };
    double v1[]={28.97679234753513,28.96802521613779,28.974815297102417,28.981223436786507,28.972369184982753 ,28.973947903387028,28.97413943205218, 28.986296184186568 , 28.979682284101486  };

    public ActivitiesEklemeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final Activity activity = getActivity();
        View view = inflater.inflate(R.layout.fragment_activities_ekleme, container, false);

        activiteListe = view.findViewById(R.id.recyclerView2);
        names = getResources().getStringArray(R.array.saved_activities);
        texts= getResources().getStringArray(R.array.saved_descr);

        MyAllAdapter myAdapter = new MyAllAdapter(activity,names,texts,imgages,v,v1);
        activiteListe.setAdapter(myAdapter);
        activiteListe.setLayoutManager(new LinearLayoutManager(activity));


        return view;
    }
}