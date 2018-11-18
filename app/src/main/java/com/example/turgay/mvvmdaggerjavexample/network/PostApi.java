package com.example.turgay.mvvmdaggerjavexample.network;

import com.example.turgay.mvvmdaggerjavexample.model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PostApi {
    @GET("/posts")
    Observable<List<Post>> getPosts();
}
