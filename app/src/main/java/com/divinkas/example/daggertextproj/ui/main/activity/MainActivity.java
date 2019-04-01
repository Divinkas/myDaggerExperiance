package com.divinkas.example.daggertextproj.ui.main.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.divinkas.example.daggertextproj.R;
import com.divinkas.example.daggertextproj.base.ProjectApplication;
import com.divinkas.example.daggertextproj.dagger.component.DaggerMainActivityComponent;
import com.divinkas.example.daggertextproj.dagger.component.DaggerPresenterComponents;
import com.divinkas.example.daggertextproj.dagger.component.MainActivityComponent;
import com.divinkas.example.daggertextproj.dagger.component.PresenterComponents;
import com.divinkas.example.daggertextproj.databinding.ActivityMainBinding;
import com.divinkas.example.daggertextproj.ui.main.adapter.MenuProductsAdapter;
import com.divinkas.example.daggertextproj.ui.main.callback.OnClickItemCallback;
import com.divinkas.example.daggertextproj.ui.main.presenter.UserPresenter;
import com.divinkas.example.daggertextproj.ui.main.view.IMainView;
import com.divinkas.example.daggertextproj.viewModel.MenuViewModel;
import com.divinkas.example.daggertextproj.viewModel.RecyclerItemHelper;
import com.divinkas.example.daggertextproj.viewModel.RecyclerItemHelperListener;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements IMainView, OnClickItemCallback, RecyclerItemHelperListener {
    private ActivityMainBinding binding;

    private UserPresenter<IMainView> presenter;
    private MenuProductsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initToolbar();

        installComponents();
        initRecycler();

        presenter.getMenuList();
    }

    private void initToolbar() {
        binding.toolbar.setTitle(getString(R.string.app_name));
        binding.toolbar.setTitleTextColor(getResources().getColor(R.color.col_white));
    }

    private void installComponents() {
        PresenterComponents components = DaggerPresenterComponents
                .builder()
                .iMainComponent(((ProjectApplication)getApplication()).getComponent())
                .build();

        MainActivityComponent mainActivityComponent = DaggerMainActivityComponent
                .builder()
                .build();

        presenter =  components.getUserPresenter();
        presenter.setView(this);

        adapter = mainActivityComponent.getMenuAdapter();
        adapter.setCallback(this);

    }

    private void initRecycler() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        binding.recyclerView.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback item = new RecyclerItemHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(item).attachToRecyclerView(binding.recyclerView);
    }

    @Override
    public void onClick(MenuViewModel item) {
        Toast.makeText(this, "Click id: " + item.getId(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemsList(List<MenuViewModel> list) {
        adapter.setList(list);
    }

    @Override
    public void onSwipe(RecyclerView.ViewHolder holder, int direction, int position) {
        if(holder instanceof MenuProductsAdapter.MenuViewHolder){
            String name = adapter.getList().get(holder.getAdapterPosition()).getName();
            MenuViewModel item = adapter.getList().get(holder.getAdapterPosition());
            int deleteIndex = holder.getAdapterPosition();

            adapter.removeItem(deleteIndex);

            Snackbar snackbar = Snackbar
                    .make(binding.rootLayout, name + "remove from list!", Snackbar.LENGTH_SHORT);
            snackbar.setAction("UNDO", v -> adapter.restoreItem(deleteIndex, item));
            snackbar.setActionTextColor(Color.YELLOW);

        }
    }
}
