package com.example.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapter.RecyclerViewAdapter;
import com.example.myapplication.model.MovieResponse;
import com.example.myapplication.util.API_CALL;
import com.example.myapplication.util.RetrofitConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rvmovie);
        try {
            API_CALL apiCall = RetrofitConfig.getRetrofitObj();
            apiCall.groupList().enqueue(new Callback<List<MovieResponse>>() {
                @Override
                public void onResponse(Call<List<MovieResponse>> call, Response<List<MovieResponse>> response) {
                    Toast.makeText(MainActivity.this, "Successs", Toast.LENGTH_SHORT).show();          
                    List<MovieResponse> movieResponses=response.body();
                    setRecyclerView(movieResponses);
                }

                @Override
                public void onFailure(Call<List<MovieResponse>> call, Throwable t) {
                    Log.e("Response Failure ", t.getMessage());
                    Toast.makeText(MainActivity.this, "Filure "+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });


        }catch (Exception e)
        {
            Log.e("Error is lile ",e.getMessage());
            e.printStackTrace();
            Toast.makeText(this, " Faileure "+e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    public void setRecyclerView(List<MovieResponse> data)
    {
//        layoutManager=new LinearLayoutManager(this);
//        recyclerViewAdapter=new RecyclerViewAdapter(this,data);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
