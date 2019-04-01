package com.divinkas.example.daggertextproj.ui.main.view;

import com.divinkas.example.daggertextproj.base.IBaseView;
import com.divinkas.example.daggertextproj.viewModel.MenuViewModel;

import java.util.List;

public interface IMainView extends IBaseView {
    void onItemsList(List<MenuViewModel> list);
}
