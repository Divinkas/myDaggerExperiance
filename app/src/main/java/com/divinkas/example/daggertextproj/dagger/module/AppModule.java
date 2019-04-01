package com.divinkas.example.daggertextproj.dagger.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application getApplication(){
        return this.application;
    }

    @Provides
    @Singleton
    public Context getApplicationContext(){
        return this.application.getApplicationContext();
    }
}
