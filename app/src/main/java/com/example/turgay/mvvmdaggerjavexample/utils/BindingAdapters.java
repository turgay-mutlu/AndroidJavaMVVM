package com.example.turgay.mvvmdaggerjavexample.utils;


import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

public class BindingAdapters {

    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter){
        recyclerView.setAdapter(adapter);
    }
}
