package com.divinkas.example.daggertextproj.ui.main.presenter;

import com.divinkas.example.daggertextproj.base.CorePresenter;

public interface UserPresenter<T> extends CorePresenter<T> {
    void getMenuList();
}
