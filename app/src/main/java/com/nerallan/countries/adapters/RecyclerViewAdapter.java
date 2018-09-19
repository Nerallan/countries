package com.nerallan.countries.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nerallan.countries.GalleryActivity;
import com.nerallan.countries.R;
import com.nerallan.countries.ViewHolder;
import com.nerallan.countries.model.DataModel;
import java.util.List;

import static android.content.ContentValues.TAG;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private static final String TAB = "RecyclerViewAdapter";

    private int resource;
    private List<DataModel> recyclerdata;
    private Context context;

    public RecyclerViewAdapter(List<DataModel> recyclerdata, Context context, int resource) {
        //super(recyclerdata, context, resource);
        this.recyclerdata = recyclerdata;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view,  parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");

        final DataModel dataModel = recyclerdata.get(position);
        holder.name.setText(dataModel.getName());
//        holder.capital.setText(dataModel.getCapital());
//        holder.area.setText(dataModel.getArea());

        Glide.with(context)
                .asBitmap()
                .load("https://restcountries.eu/data/afg.svg")
                .into(holder.flagView);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + dataModel.getName());
                Toast.makeText(context, dataModel.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, GalleryActivity.class);
                intent.putExtra("country_name", dataModel.getName());
                intent.putExtra("flag_image", dataModel.getFlagUrl());
                intent.putExtra("area", dataModel.getArea());
                intent.putExtra("capital", dataModel.getCapital());
                intent.putExtra("population", dataModel.getPopulation());
                intent.putExtra("region", dataModel.getRegion());
                intent.putExtra("numericCode", dataModel.getNumericCode());
                intent.putExtra("alpha3Code", dataModel.getAlpha3Code());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return recyclerdata.size();
    }


}