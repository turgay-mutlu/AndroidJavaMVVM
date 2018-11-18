package com.example.turgay.mvvmdaggerjavexample.injection.component;

import com.example.turgay.mvvmdaggerjavexample.injection.module.NetworkModule;
import com.example.turgay.mvvmdaggerjavexample.view.PostListViewModel;
import com.example.turgay.mvvmdaggerjavexample.view.PostViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        NetworkModule.class
})
public interface ViewModelInjector {
    void inject(PostListViewModel postListViewModel);

    void inject(PostViewModel postViewModel);

    interface Builder{
        ViewModelInjector build();
        Builder networkModule(NetworkModule networkModule);
    }
}
