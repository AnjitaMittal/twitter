package com.example.hp.twitter.Fragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.twitter.R;

class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder> {
    @NonNull
    @Override
    public SearchAdapter.SearchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item,parent,false);
        return new SearchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.SearchHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class SearchHolder extends RecyclerView.ViewHolder {
        public SearchHolder(View itemView) {
            super(itemView);
        }
    }
}
