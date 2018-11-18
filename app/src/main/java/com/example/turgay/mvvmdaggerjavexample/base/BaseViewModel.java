package com.example.turgay.mvvmdaggerjavexample.base;

import android.arch.lifecycle.ViewModel;

import com.example.turgay.mvvmdaggerjavexample.injection.component.DaggerViewModelInjector;
import com.example.turgay.mvvmdaggerjavexample.injection.component.ViewModelInjector;
import com.example.turgay.mvvmdaggerjavexample.injection.module.NetworkModule;
import com.example.turgay.mvvmdaggerjavexample.network.PostApi;
import com.example.turgay.mvvmdaggerjavexample.view.PostListViewModel;
import com.example.turgay.mvvmdaggerjavexample.view.PostViewModel;

import javax.inject.Inject;

public abstract class BaseViewModel extends ViewModel {
    private ViewModelInjector injector = DaggerViewModelInjector
            .builder()
            .networkModule(new NetworkModule())
            .build();

    public BaseViewModel() {
        inject();
    }

    private void inject(){
        if(this instanceof PostListViewModel){
            injector.inject(((PostListViewModel) this));
        }
        if(this instanceof PostViewModel){
            injector.inject(((PostViewModel) this));
        }
    }
}
