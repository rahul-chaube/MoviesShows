package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.activity.DetailActivity;
import com.example.myapplication.model.MovieResponse;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Android7 on 3/6/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    Context context;
    List<MovieResponse> data;
    PassData passData;

    public RecyclerViewAdapter(Context context, List<MovieResponse> data,PassData passData) {
        this.context = context;
        this.data = data;
        this.passData=passData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            final MovieResponse movieResponse=data.get(position);
            holder.movieName.setText(movieResponse.getTitle());
            holder.moviesYear.setText(String.valueOf( movieResponse.getReleaseYear()));
             Glide.with(context)
                .load(movieResponse.getImage())
                .into(holder.imageView);

             holder.detailButton.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
//                     Toast.makeText(context, movieResponse.getTitle()+" "+movieResponse.getRating(), Toast.LENGTH_SHORT).show();
//                     Intent intent=new Intent(context,DetailActivity.class);
//                     Bundle bundle=new Bundle();
//                     bundle.putSerializable("movie",movieResponse);
//                     intent.putExtras(bundle);
//                    context.startActivity(intent);
                     passData.sendData(movieResponse);
                 }
             });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView movieName,moviesYear;
        Button detailButton;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            movieName=itemView.findViewById(R.id.moveName);
            moviesYear=itemView.findViewById(R.id.year);
            detailButton=itemView.findViewById(R.id.detail);
        }
    }
    public interface PassData{
        void sendData(MovieResponse movieResponse);
    }
}
