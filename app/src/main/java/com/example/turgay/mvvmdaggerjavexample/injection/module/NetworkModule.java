package com.example.turgay.mvvmdaggerjavexample.injection.module;

import com.example.turgay.mvvmdaggerjavexample.network.PostApi;
import com.example.turgay.mvvmdaggerjavexample.utils.Constants;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class NetworkModule {
    @Provides
    @Reusable
    public PostApi providePostApi(Retrofit retrofit){
        return retrofit.create(PostApi.class);
    }

    @Provides
    @Reusable
    public Retrofit provideRetrofitInterface(){
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
    }
}
