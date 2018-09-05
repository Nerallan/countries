package com.nerallan.countries.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.nerallan.countries.JSONhelper;
import com.nerallan.countries.R;
import com.nerallan.countries.adapters.RecyclerviewAdapter;
import com.nerallan.countries.model.DataModel;

import java.util.List;

/**
 * Created by Nerallan on 9/5/2018.
 */

public class FragmentCountries extends Fragment{

    RecyclerView recyclerView;
    Button button;
    ImageView flagView;
    View v;

    public FragmentCountries(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.countries_fragment, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycleview);
        new Urltask().execute(getString(R.string.zomato_api));
        return v;
    }

    class Urltask extends AsyncTask<String,String,List<DataModel>> {

        @Override
        protected List<DataModel> doInBackground(String... params) {

            JSONhelper jsonhelper = new JSONhelper();
            List<DataModel>  data = jsonhelper.getdatafromurl(params[0]);
            System.out.println(data);
            return data;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<DataModel> dataModels) {
            super.onPostExecute(dataModels);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            RecyclerviewAdapter recyclerviewAdapter = new RecyclerviewAdapter(dataModels, getActivity().getApplicationContext(), R.layout.view);
            //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
            //recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(recyclerviewAdapter);

            Log.i("Hitesh Chauhan","" + dataModels);

        }
    }
}
