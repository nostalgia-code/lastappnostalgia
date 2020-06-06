package com.example.nostalgia.Adapter;



import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nostalgia.Interface.itemClickListener;
import com.example.nostalgia.R;

public class suggestedCategoriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView name;
    public itemClickListener listner;


    public suggestedCategoriesViewHolder(View itemView)
    {
        super(itemView);



       name = (TextView) itemView.findViewById(R.id.sc);

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