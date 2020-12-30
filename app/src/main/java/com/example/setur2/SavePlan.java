package com.example.setur2;

import android.media.Image;
import android.net.Uri;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.text.DecimalFormat;
import java.util.Date;

public class SavePlan {







    public static Activity[] plan ;

    public static void addToPlan(Activity newAct){


        if (plan==null){
            Activity[] tmp1 = new  Activity[1];
                tmp1[0]=newAct;
                plan=tmp1;

        }
        else {
            Activity[] tmp = new Activity[plan.length + 1];


            for (int i = 0; i < plan.length; i++) {

                tmp[i] = plan[i];


            }
            tmp[plan.length] = newAct;
            plan=tmp;
        }



    }

    public static double CalculationByDistance(LatLng StartP, LatLng EndP) {
        int Radius = 6371;// radius of earth in Km
        double lat1 = StartP.latitude;
        double lat2 = EndP.latitude;
        double lon1 = StartP.longitude;
        double lon2 = EndP.longitude;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult = Radius * c;
        double km = valueResult / 1;
        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec = Integer.valueOf(newFormat.format(km));
        double meter = valueResult % 1000;
        int meterInDec = Integer.valueOf(newFormat.format(meter));
        Log.i("Radius Value", "" + valueResult + "   KM  " + kmInDec
                + " Meter   " + meterInDec);

        return Radius * c;
    }

    public static void sortPlan(){

        Activity temp;
        if(plan.length>3){

            for (int i = 1; i <plan.length-1; i++) {
                for (int j = i+1; j <plan.length-1; j++) {
                    LatLng base = new LatLng(plan[0].v,plan[0].v1);
                    LatLng first = new LatLng(plan[i].v,plan[i].v1);
                    LatLng second = new LatLng(plan[j].v,plan[j].v1);
                    if( CalculationByDistance(base,first)>CalculationByDistance(base,second)) {      //swap elements if not in order
                        temp = plan[i];
                        plan[i] = plan[j];
                        plan[j] = temp;
                    }
                }
            }
        }



    }






}
