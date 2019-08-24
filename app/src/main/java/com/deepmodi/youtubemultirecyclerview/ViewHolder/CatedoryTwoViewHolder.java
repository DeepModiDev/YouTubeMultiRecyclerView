package com.deepmodi.youtubemultirecyclerview.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deepmodi.youtubemultirecyclerview.R;

public class CatedoryTwoViewHolder extends RecyclerView.ViewHolder {

    public TextView product_id;
    public TextView product_title;

    public CatedoryTwoViewHolder(@NonNull View itemView) {
        super(itemView);
        product_id = itemView.findViewById(R.id.product_id);
        product_title = itemView.findViewById(R.id.product_title);
    }
}
