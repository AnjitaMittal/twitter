package com.example.hp.twitter.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.twitter.R;

public class home_fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       getActivity().setTitle("Home");
       View view=inflater.inflate(R.layout.home_items,container,false);
        RecyclerView recyclerView=view.findViewById(R.id.recyclerView);
       HomeAdapter homeAdapter=new HomeAdapter();
       recyclerView.setAdapter(homeAdapter);
        return view;
    }
}
