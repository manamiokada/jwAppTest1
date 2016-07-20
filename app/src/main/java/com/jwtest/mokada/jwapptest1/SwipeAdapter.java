package com.jwtest.mokada.jwapptest1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by mokada on 6/25/16.
 */
public class SwipeAdapter extends FragmentPagerAdapter {

    Bundle bundle;

    public SwipeAdapter(FragmentManager fm, Bundle bundle) {
        super(fm);
        this.bundle = bundle;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment dayOne = new DayOneFragment();
        Fragment dayTwo = new DayTwoFragment();
        Fragment dayThree = new DayThreeFragment();
        Fragment dayFour = new DayFourFragment();

        dayOne.setArguments(bundle);
        dayTwo.setArguments(bundle);
        dayThree.setArguments(bundle);

        switch(position) {
            case 0: return dayOne;
            case 1: return dayTwo;
            case 2: return dayThree;
            case 3: return dayFour;
            default: return dayOne;
        }

    }

    @Override
    public int getCount() {
        return 4;
    }
}
