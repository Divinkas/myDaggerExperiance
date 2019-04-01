package com.divinkas.example.daggertextproj.dagger.component;

import com.divinkas.example.daggertextproj.dagger.scope.UserScope;
import com.divinkas.example.daggertextproj.ui.main.presenter.UserPresenterImpl;

import dagger.Component;


@UserScope
@Component(dependencies = {IMainComponent.class})
public interface PresenterComponents {
    UserPresenterImpl getUserPresenter();
}
