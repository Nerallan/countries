package com.nerallan.countries;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.nerallan.countries.adapters.RecyclerviewAdapter;

import com.nerallan.countries.model.DataModel;

import java.util.List;


public class MainActivity extends AppCompatActivity{

    RecyclerView recyclerView;
    Button button;
    ImageView flagView;
    Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);

        button = (Button) findViewById(R.id.result);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        // search menu to appear in toolbar
        setSupportActionBar(mToolbar);


//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new Urltask().execute(getString(R.string.zomato_api));
//            }
//        });
        new Urltask().execute(getString(R.string.zomato_api));
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);


        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
//        getSupportActionBar().setDisplayShowHomeEnabled(true);



//        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//
//        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
//        final PagerAdapter adapter = new com.nerallan.countries.adapters.PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
//        viewPager.setAdapter(adapter);
//        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//
//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//
//        });


    }
//    @Override
//    public void onFragmentInteraction(Uri uri) {
//
//    }

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
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                RecyclerviewAdapter recyclerviewAdapter = new RecyclerviewAdapter(dataModels, getApplicationContext(), R.layout.view);
                //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                //recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(recyclerviewAdapter);

                Log.i("Hitesh Chauhan","" + dataModels);

            }
    }
}