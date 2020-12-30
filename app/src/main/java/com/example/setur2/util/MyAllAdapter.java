package com.example.setur2.util;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.setur2.Activity;
import com.example.setur2.Plan;
import com.example.setur2.R;
import com.example.setur2.SavePlan;


public class MyAllAdapter extends RecyclerView.Adapter<MyAllAdapter.MyViewHolder> {

    String data1[],data2[];
    int imageSources[];
    Context context;
    double vs[];
    double v1[];

    public MyAllAdapter(Context ct , String s1[], String texts[], int imgSources[],double vss[],double v1s[]){

        context=ct;
        data1=s1;
        data2=texts;
        imageSources=imgSources;
        vs=vss;
        v1=v1s;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_all,parent,false);
        return new MyAllAdapter.MyViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.t1.setText(data1[position]);
        holder.t2.setText(data2[position]);
        holder.img.setImageResource(imageSources[position]);
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Activity addAct = new Activity(data1[position],vs[position],v1[position],data2[position],imageSources[position]);
                SavePlan.addToPlan(addAct);

            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView t1 , t2 ;
        ImageView img ;
        Button add;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.name);
            t2 = itemView.findViewById(R.id.text);
            img =itemView.findViewById(R.id.imageViewRow);
            add = itemView.findViewById(R.id.addButton);
        }
    }
}
