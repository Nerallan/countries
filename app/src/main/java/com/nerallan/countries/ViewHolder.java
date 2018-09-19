package com.nerallan.countries;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Nerallan on 7/2/2018.
 */

public class ViewHolder extends RecyclerView.ViewHolder{

    public TextView name,capital,area;
    public ImageView flagView;
    public RelativeLayout parentLayout;

    public ViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
//        capital = itemView.findViewById(R.id.capital);
//        area = itemView.findViewById(R.id.id);
        flagView = itemView.findViewById(R.id.flag_image);
        parentLayout = itemView.findViewById(R.id.parent_layout);
    }
}
