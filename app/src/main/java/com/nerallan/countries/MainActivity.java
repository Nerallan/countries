package com.nerallan.countries;

import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.nerallan.countries.adapters.ViewPagerAdapter;
import com.nerallan.countries.fragment.FragmentAbout;
import com.nerallan.countries.fragment.FragmentCountries;
import com.nerallan.countries.fragment.FragmentMap;


public class MainActivity extends AppCompatActivity{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add Fragment here
        adapter.AddFragment(new FragmentMap(), "Map");
        adapter.AddFragment(new FragmentCountries(), "Countries");
        adapter.AddFragment(new FragmentAbout(), "About");

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_map);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_view_list);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_info);


//        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
//
//        button = (Button) findViewById(R.id.result);
//        mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        // search menu to appear in toolbar
//        setSupportActionBar(mToolbar);


//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new Urltask().execute(getString(R.string.zomato_api));
//            }
//        });
//        new Urltask().execute(getString(R.string.zomato_api));
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);


//        mDrawerLayout.addDrawerListener(mToggle);
//        mToggle.syncState();
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


}