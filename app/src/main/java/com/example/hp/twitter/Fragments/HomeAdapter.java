package com.example.hp.twitter.Fragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {
    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HomeHolder extends RecyclerView.ViewHolder {
        public HomeHolder(View itemView) {
            super(itemView);
        }
    }
}
