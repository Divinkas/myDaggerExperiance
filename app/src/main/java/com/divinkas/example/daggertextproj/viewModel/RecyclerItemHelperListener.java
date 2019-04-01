package com.divinkas.example.daggertextproj.viewModel;

import androidx.recyclerview.widget.RecyclerView;

public interface RecyclerItemHelperListener {
    void onSwipe(RecyclerView.ViewHolder holder, int direction, int position);
}
