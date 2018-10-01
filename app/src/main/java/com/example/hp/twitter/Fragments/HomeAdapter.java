package com.example.hp.twitter.Fragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.twitter.R;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {
    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_items,parent,false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class HomeHolder extends RecyclerView.ViewHolder {
        public HomeHolder(View itemView) {
            super(itemView);
        }
    }
}
