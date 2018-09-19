package com.nerallan.countries;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by User on 1/2/2018.
 */

public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

//        if(getIntent().hasExtra("name") && getIntent().hasExtra("flag_image") && getIntent().hasExtra("area") && getIntent().hasExtra("capital")
//                && getIntent().hasExtra("population") && getIntent().hasExtra("region") && getIntent().hasExtra("numericCode") && getIntent().hasExtra("alpha3Code")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String flagUrl = getIntent().getStringExtra("flag_image");
            String name = getIntent().getStringExtra("country_name");

            String area = getIntent().getStringExtra("area");
            String capital = getIntent().getStringExtra("capital");
            String population = getIntent().getStringExtra("population");
            String region = getIntent().getStringExtra("region");
            String numericCode = getIntent().getStringExtra("numericCode");
            String alpha3Code = getIntent().getStringExtra("alpha3Code");



            setGalleryInfo(flagUrl, name, area, capital, population, region, numericCode, alpha3Code);
        //}
    }


    private void setGalleryInfo(String flagUrl, String countryName, String countryArea, String countryCapital, String countryPopulation, String countryRegion, String countryNumericCode, String countryAlpha3Code){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = findViewById(R.id.name);
        TextView capital = findViewById(R.id.capital);
        TextView area = findViewById(R.id.area);
        TextView population = findViewById(R.id.population);
        TextView region = findViewById(R.id.region);
        TextView numericCode = findViewById(R.id.numericCode);
        TextView alpha3Code = findViewById(R.id.alpha3Code);

        name.setText(countryName);
        capital.setText(countryCapital);
        area.setText(countryArea);
        population.setText(countryPopulation);
        region.setText(countryRegion);
        numericCode.setText(countryNumericCode);
        alpha3Code.setText(countryAlpha3Code);

        ImageView image = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(flagUrl)
                .into(image);
    }

}


















