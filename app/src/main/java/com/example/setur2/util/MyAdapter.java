package com.example.setur2.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.setur2.R;
import com.example.setur2.SavePlan;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String data1[],data2[];
    int imageSources[];
    Context context;
    int length = SavePlan.plan.length;

    public MyAdapter(Context ct , String s1[], String texts[], int imgSources[]){

        context=ct;
        data1=s1;
        data2=texts;
        imageSources=imgSources;



    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {



        holder.t1.setText(data1[position]);
        holder.t2.setText(data2[position]);
        holder.img.setImageResource(imageSources[position]);

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    @Override
    public int getItemCount() {
        return length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView t1 , t2 ;
        ImageView img ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.name);
            t2 = itemView.findViewById(R.id.text);
            img =itemView.findViewById(R.id.imageViewRow);
        }
    }
}
