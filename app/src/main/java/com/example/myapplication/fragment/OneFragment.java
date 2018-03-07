package com.example.myapplication.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.activity.MainActivity;
import com.example.myapplication.activity.TabActivityDemo;
import com.example.myapplication.adapter.RecyclerViewAdapter;
import com.example.myapplication.model.MovieResponse;
import com.example.myapplication.util.API_CALL;
import com.example.myapplication.util.RetrofitConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OneFragment extends Fragment  implements RecyclerViewAdapter.PassData{
    ProgressDialog progressDialog;
    SendMessage SM;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView.LayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_one, container, false);
        recyclerView=rootView.findViewById(R.id.rvmovie);
        progressDialog=new ProgressDialog(getContext());
        progressDialog.setMessage("Please Wait .... ");
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               progressDialog.dismiss();
           }
       },5000);
        progressDialog.show();
        try {
            API_CALL apiCall = RetrofitConfig.getRetrofitObj();
            apiCall.groupList().enqueue(new Callback<List<MovieResponse>>() {
                @Override
                public void onResponse(Call<List<MovieResponse>> call, Response<List<MovieResponse>> response) {
//                    progressDialog.dismiss();
                    Toast.makeText(getContext(), "Successs", Toast.LENGTH_SHORT).show();
                    List<MovieResponse> movieResponses=response.body();
                    setRecyclerView(movieResponses);
                }

                @Override
                public void onFailure(Call<List<MovieResponse>> call, Throwable t) {
//                    progressDialog.dismiss();
                    Log.e("Response Failure ", t.getMessage());
                    Toast.makeText(getContext(), "Filure "+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });


        }catch (Exception e)
        {
            Log.e("Error is lile ",e.getMessage());
            e.printStackTrace();
            Toast.makeText(getContext(), " Faileure "+e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return rootView;
    }

    public void setRecyclerView(List<MovieResponse> data)
    {
        layoutManager=new LinearLayoutManager(getContext());
        recyclerViewAdapter=new RecyclerViewAdapter(getContext(),data,this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void sendData(MovieResponse movieResponse) {
        Toast.makeText(getContext(), "Listner is working", Toast.LENGTH_SHORT).show();
        SM.sendData(movieResponse);

    }

    public interface SendMessage {
        void sendData(MovieResponse movieResponse);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SM = (SendMessage) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }
}
