package com.example.turgay.mvvmdaggerjavexample.view;

import android.arch.lifecycle.MutableLiveData;

import com.example.turgay.mvvmdaggerjavexample.base.BaseViewModel;
import com.example.turgay.mvvmdaggerjavexample.model.Post;

public class PostViewModel extends BaseViewModel {
    private MutableLiveData<String> postTitle = new MutableLiveData<>();
    private MutableLiveData<String> postBody = new MutableLiveData<>();

    public void bind(Post post){
        postTitle.setValue(post.getTitle());
        postBody.setValue(post.getBody());
    }

    public MutableLiveData<String> getPostTitle() {
        return postTitle;
    }

    public MutableLiveData<String> getPostBody() {
        return postBody;
    }
}
