package com.divinkas.example.daggertextproj.base;

public abstract class BaseMenuPresenter<T extends IBaseView> implements CorePresenter<T>{
    protected T view;

    public void setView(T view) {
        this.view = view;
    }
}
