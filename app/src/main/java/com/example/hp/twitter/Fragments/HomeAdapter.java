package com.example.hp.twitter.Fragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.twitter.R;
import com.example.hp.twitter.Tweets;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {
    public List<Tweets> tweetmessage;

    public HomeAdapter(List<Tweets> messages) {
        this.tweetmessage = messages;
    }


    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_items,parent,false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        holder.message.setText(tweetmessage.get(position).getMessage());
        holder.authorName.setText(tweetmessage.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return tweetmessage.size();
    }

    public class HomeHolder extends RecyclerView.ViewHolder {
         TextView authorName;
         TextView message;
        public HomeHolder(View itemView) {
            super(itemView);
            authorName = itemView.findViewById(R.id.username);
            message = itemView.findViewById(R.id.tweet);

        }
    }
}
