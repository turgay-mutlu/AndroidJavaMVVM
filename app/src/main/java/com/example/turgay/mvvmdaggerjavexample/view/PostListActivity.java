package com.example.turgay.mvvmdaggerjavexample.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.turgay.mvvmdaggerjavexample.R;
import com.example.turgay.mvvmdaggerjavexample.databinding.ActivityPostListBinding;

public class PostListActivity extends AppCompatActivity {

    private PostListViewModel viewModel;
    private ActivityPostListBinding postListBinding;

    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(PostListViewModel.class);
        postListBinding = DataBindingUtil.setContentView(this,R.layout.activity_post_list);

        viewModel.getErrorMessage().observe(this, errorMessage -> {
            if(errorMessage != null)
                showError(errorMessage);
            else
                hideError();
        });

        postListBinding.setViewModel(viewModel);
    }


    private void showError(Integer errorMessage) {
        snackbar = Snackbar.make(postListBinding.getRoot(),errorMessage,Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(R.string.retry,viewModel.getOnClickListener());
        snackbar.show();
    }

    private void hideError() {
        if(snackbar!=null)
            snackbar.dismiss();
    }

}
