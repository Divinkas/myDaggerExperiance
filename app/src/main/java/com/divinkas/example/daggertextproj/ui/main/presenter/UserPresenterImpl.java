package com.divinkas.example.daggertextproj.ui.main.presenter;

import com.divinkas.example.daggertextproj.base.BasePresenter;
import com.divinkas.example.daggertextproj.ui.main.view.IMainView;
import com.divinkas.example.daggertextproj.viewModel.Utils;

import javax.inject.Inject;

import dagger.Module;
import retrofit2.Retrofit;

@Module
public class UserPresenterImpl extends BasePresenter<IMainView> implements UserPresenter<IMainView> {

    @Inject Retrofit retrofit;

    @Inject
    UserPresenterImpl(){

    }

    @Override
    public void getMenuList() {
        view.onItemsList(Utils.getList());
    }

}
