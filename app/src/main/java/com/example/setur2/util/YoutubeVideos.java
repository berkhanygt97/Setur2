package com.example.setur2.util;

public class YoutubeVideos {
    String videoUrl ;
    public  YoutubeVideos(){


    }

    public  YoutubeVideos(String videoUrl){
        this.videoUrl=videoUrl;


    }

    public  String getVideoUrl(){return  videoUrl;}

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}