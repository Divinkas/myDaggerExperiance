package com.divinkas.example.daggertextproj.dagger.component;

import android.app.Application;

import com.divinkas.example.daggertextproj.dagger.module.AppModule;
import com.divinkas.example.daggertextproj.dagger.module.ConnectionModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class, ConnectionModule.class})
public interface IMainComponent {

    Application getApp();

    Retrofit getRetrofitConnection();

}
