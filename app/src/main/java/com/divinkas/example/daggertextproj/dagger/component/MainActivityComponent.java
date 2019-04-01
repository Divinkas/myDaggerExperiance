package com.divinkas.example.daggertextproj.dagger.component;

import com.divinkas.example.daggertextproj.dagger.scope.MainActivityScope;
import com.divinkas.example.daggertextproj.ui.main.adapter.MenuProductsAdapter;

import dagger.Component;

@MainActivityScope
@Component(modules = {MenuProductsAdapter.class})
public interface MainActivityComponent {

    MenuProductsAdapter getMenuAdapter();

}
