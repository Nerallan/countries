package com.nerallan.countries;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nerallan on 7/2/2018.
 */

public class ViewHolder extends RecyclerView.ViewHolder{

    public TextView name,capital,area;
    public ImageView flagView;

    public ViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.name);
        capital = (TextView) itemView.findViewById(R.id.capital);
        area = (TextView) itemView.findViewById(R.id.id);
        flagView = (ImageView) itemView.findViewById(R.id.flag_image);

    }
}
