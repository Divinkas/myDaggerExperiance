package com.divinkas.example.daggertextproj.base;

public abstract class BasePresenter<T extends IBaseView> implements CorePresenter<T>{
    protected T view;

    public void setView(T view) {
        this.view = view;
    }
}
