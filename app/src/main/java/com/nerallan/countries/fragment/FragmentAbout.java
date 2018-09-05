package com.nerallan.countries.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nerallan.countries.R;

/**
 * Created by Nerallan on 9/5/2018.
 */

public class FragmentAbout extends Fragment{
    View v;

    public FragmentAbout(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.map_fragment, container, false);
        return v;
    }
}
