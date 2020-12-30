package com.example.setur2.util;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.setur2.R;

import java.util.Vector;


public class SeturGuides extends Fragment {



    RecyclerView recyclerView;
    Vector<YoutubeVideos> youtubeVideos = new Vector<YoutubeVideos>();


    private RecyclerView activiteListe;
    private   String[] names,texts;
    int imgages[]={R.drawable.sultanahmet,R.drawable.privatocafe,R.drawable.galata,R.drawable.rainbowstairs,R.drawable.grandbazaar,R.drawable.sevenhills};

    double v[]={41.00564435658308, 41.027380394160836, 41.02579321570727, 41.029914470559184,41.01098433905244, 41.006891103398885 };
    double v1[]={28.976835265272236 ,28.973722590124815,28.97412870372017, 28.986296184120594,28.968003758431784, 28.979510621829437};


    public SeturGuides() {
        // Required empty public constructor
    }


    public static SeturGuides newInstance(String param1, String param2) {
        SeturGuides fragment = new SeturGuides();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final Activity activity = getActivity();
        View view = inflater.inflate(R.layout.setru_guides_layout, container, false);
        names = getResources().getStringArray(R.array.youtuber_activities);
        texts= getResources().getStringArray(R.array.youtube_descr);


        MyAllAdapter myAdapter = new MyAllAdapter(activity,names,texts,imgages,v,v1);
        activiteListe = view.findViewById(R.id.recyclerViewYoutube);
        activiteListe.setAdapter(myAdapter);
        activiteListe.setLayoutManager(new LinearLayoutManager(activity));



        recyclerView = (RecyclerView) view.findViewById(R.id.youtubeRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        youtubeVideos.add( new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/_vDZTHM4eBc\" frameborder=\"0\" allowfullscreen></iframe>") );

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);
        recyclerView.setAdapter(videoAdapter);
        // Inflate the layout for this fragment
        return view;
    }
}