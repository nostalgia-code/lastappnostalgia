package com.example.nostalgia.Adapter;



import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nostalgia.Interface.itemClickListener;
import com.example.nostalgia.R;

public class reportViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView txtSubject, txtDescription;
    public itemClickListener listner;


    public reportViewHolder(View itemView)
    {
        super(itemView);



        txtSubject = (TextView) itemView.findViewById(R.id.subject);

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