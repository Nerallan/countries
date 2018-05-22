package com.nerallan.countries.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nerallan.countries.R;
import com.nerallan.countries.model.DataModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyHolder> {

    private int resource;
    private List<DataModel> recyclerdata;
    private Context context;

    public RecyclerviewAdapter(List<DataModel> recyclerdata, Context context, int resource) {
        //super(recyclerdata, context, resource);
        this.recyclerdata = recyclerdata;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view,parent,false);
        MyHolder myHolder = new MyHolder(view);

        return myHolder;
    }


    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        DataModel dataModel = recyclerdata.get(position);
        holder.name.setText(dataModel.getName());
        holder.capital.setText(dataModel.getCapital());
        holder.area.setText(dataModel.getArea());
        Picasso.with(context).load(recyclerdata.get(position).getFlagUrl()).into(holder.flagView);
    }


    @Override
    public int getItemCount() {
        return recyclerdata.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        public TextView name,capital,area;
        public ImageView flagView;

        public MyHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            capital = (TextView) itemView.findViewById(R.id.capital);
            area = (TextView) itemView.findViewById(R.id.id);
            flagView = (ImageView) itemView.findViewById(R.id.flag_image);


        }
    }
}
