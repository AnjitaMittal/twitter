package com.example.hp.twitter.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.twitter.R;
import com.example.hp.twitter.Tweets;

import java.util.ArrayList;
import java.util.List;

public class home_fragment extends Fragment {
    public List<Tweets> messages;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

       View view=inflater.inflate(R.layout.universal_recyclerview,container,false);
       RecyclerView recyclerView= view.findViewById(R.id.recyclerView);
       HomeAdapter homeAdapter=new HomeAdapter(messages);
       recyclerView.setAdapter(homeAdapter);
       recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        getActivity().setTitle("Home");
        return view;
    }

    public void update(List<Tweets> messages) {
        this.messages=messages;
    }
}
