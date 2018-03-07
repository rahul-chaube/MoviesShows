package com.example.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.activity.TabActivityDemo;
import com.example.myapplication.model.MovieResponse;


public class FragmentTwo extends Fragment {
   /* TextView txtData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_two, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtData = (TextView)view.findViewById(R.id.hii);
    }
    public void displayReceivedData(String message)
    {
        txtData.setText("Data received: "+message);
    }*/

    TextView txtData;
    ImageView imageView;
    TextView textViewName,textViewYear,textViewRating;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(
                R.layout.fragment_fragment_two, container, false);
        imageView=rootView.findViewById(R.id.imageView2);
        textViewName=rootView.findViewById(R.id.movieName1);
        textViewYear=rootView.findViewById(R.id.movieYear);
        textViewRating=rootView.findViewById(R.id.movieNameRating);
//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            MovieResponse movieResponse= (MovieResponse) getIntent().getSerializableExtra("movie");
//            textViewRating.setText("Rating is "+movieResponse.getRating());
//            textViewYear.setText("Releasing year is "+ String.valueOf(movieResponse.getReleaseYear()));
//            textViewName.setText("Movie Name  :- "+movieResponse.getTitle());
//            Glide.with(this)
//                    .load(movieResponse.getImage())
//                    .into(imageView);
//        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void displayReceivedData(MovieResponse message)
    {
        Glide.with(getContext())
                .load(message.getImage())
                .into(imageView);
        textViewName.setText("Movie Name : "+message.getTitle());
        textViewYear.setText("Release Yeas : "+String.valueOf( message.getReleaseYear()));
        textViewRating.setText("Rating : "+String.valueOf( message.getRating()));
        Toast.makeText(getContext(),"Second Fragment data Received", Toast.LENGTH_SHORT).show();
    }
}
