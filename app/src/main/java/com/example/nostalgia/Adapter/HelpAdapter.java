package com.example.nostalgia.Adapter;



import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.nostalgia.Interface.itemClickListener;
import com.example.nostalgia.R;

public class HelpAdapter extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView question, answer ;

    public itemClickListener listner;



    public HelpAdapter(View itemView)
    {
        super(itemView);

        question = (TextView) itemView.findViewById(R.id.question);
        answer = (TextView) itemView.findViewById(R.id.answer);

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