package com.deepmodi.youtubemultirecyclerview.ViewHolder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.deepmodi.youtubemultirecyclerview.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    public TextView category_title;
    public RecyclerView recyclerView;
    RecyclerView.LayoutManager manager;
    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

        manager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL,false);
        category_title = itemView.findViewById(R.id.category_title);
        recyclerView = itemView.findViewById(R.id.recyclerView_two);
        recyclerView.setLayoutManager(manager);

    }
}
