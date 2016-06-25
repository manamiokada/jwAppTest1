package com.jwtest.mokada.jwapptest1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jwtest.mokada.jwapptest1.Home;

/**
 * Created by mokada on 6/25/16.
 */
public class SwipeAdapter extends FragmentPagerAdapter {
    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new Home();
        Bundle bundle = new Bundle();
        bundle.putInt("count", position + 1);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
