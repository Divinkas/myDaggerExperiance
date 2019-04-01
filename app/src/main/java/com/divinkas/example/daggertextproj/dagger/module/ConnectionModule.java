package com.divinkas.example.daggertextproj.dagger.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class ConnectionModule {

    @Provides
    @Singleton
    public Retrofit getRetrofitInstance(){
         return new Retrofit.Builder()
                 .baseUrl("https://gooogle.com/")
                 .addConverterFactory(GsonConverterFactory.create())
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .build();
    }
}
