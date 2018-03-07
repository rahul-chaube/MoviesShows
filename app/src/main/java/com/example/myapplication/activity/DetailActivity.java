package com.example.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.MovieResponse;

public class DetailActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textViewName,textViewYear,textViewRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageView=findViewById(R.id.imageView2);
        textViewName=findViewById(R.id.movieName1);
        textViewYear=findViewById(R.id.movieYear);
        textViewRating=findViewById(R.id.movieNameRating);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            MovieResponse movieResponse= (MovieResponse) getIntent().getSerializableExtra("movie");
            textViewRating.setText("Rating is "+movieResponse.getRating());
            textViewYear.setText("Releasing year is "+ String.valueOf(movieResponse.getReleaseYear()));
            textViewName.setText("Movie Name  :- "+movieResponse.getTitle());
            Glide.with(this)
                    .load(movieResponse.getImage())
                    .into(imageView);
        }

    }
}
