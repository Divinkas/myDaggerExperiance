package com.divinkas.example.daggertextproj.ui.main.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.divinkas.example.daggertextproj.R;
import com.divinkas.example.daggertextproj.databinding.ItemMenuBinding;
import com.divinkas.example.daggertextproj.ui.main.callback.OnClickItemCallback;
import com.divinkas.example.daggertextproj.viewModel.MenuViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import dagger.Module;

@Module
public class MenuProductsAdapter extends RecyclerView.Adapter<MenuProductsAdapter.MenuViewHolder> {
    private OnClickItemCallback callback;
    private List<MenuViewModel> list;

    @Inject
    MenuProductsAdapter(){
        list = new ArrayList<>();
    }

    public void setList(List<MenuViewModel> newList){
        list = newList;
        notifyDataSetChanged();
    }

    public void setCallback(OnClickItemCallback callback) {
        this.callback = callback;
    }

    public void removeItem(int position){
        list.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(int position, MenuViewModel item){
        list.add(item);
        notifyItemInserted(position);
    }

    public List<MenuViewModel> getList() {
        return list;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new MenuViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.binding.setItem(list.get(position));
        if (callback != null)
            holder.binding.itemContainer.setOnClickListener(v -> callback.onClick(list.get(holder.getAdapterPosition())));
    }


    @Override
    public int getItemCount() {
        if(list != null)
            return list.size();
        return 0;
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder{
        ItemMenuBinding binding;
        public ConstraintLayout foregroundContainer;
        MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            foregroundContainer = itemView.findViewById(R.id.itemContainer);
        }
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        Picasso.with(imageView.getContext()).load(url).placeholder(R.drawable.ic_launcher_background).into(imageView);
    }

}
