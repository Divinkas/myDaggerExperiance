package com.divinkas.example.daggertextproj.base;

import android.app.Application;

import com.divinkas.example.daggertextproj.dagger.component.DaggerIMainComponent;
import com.divinkas.example.daggertextproj.dagger.component.IMainComponent;
import com.divinkas.example.daggertextproj.dagger.module.AppModule;
import com.divinkas.example.daggertextproj.dagger.module.ConnectionModule;

public class ProjectApplication extends Application {

    public static IMainComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerIMainComponent
                .builder()
                .appModule(new AppModule(this))
                .connectionModule(new ConnectionModule())
                .build();
    }

    public IMainComponent getComponent(){
        return component;
    }
}
