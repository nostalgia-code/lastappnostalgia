package com.example.nostalgia.Adapter;



import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nostalgia.Interface.itemClickListener;
import com.example.nostalgia.R;

public class categoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView txtCategoryName;
    public itemClickListener listner;

    public ImageView imageView;
    public categoryViewHolder(View itemView)
    {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.mainIcon);
        txtCategoryName = (TextView) itemView.findViewById(R.id.mainTitle);

    }

    public void setItemClickListner(itemClickListener listner)
    {
        this.listner = listner;
    }

    @Override
    public void onClick(View view)
    {
        listner.onClick(view, getAdapterPosition(), false);
    }
}