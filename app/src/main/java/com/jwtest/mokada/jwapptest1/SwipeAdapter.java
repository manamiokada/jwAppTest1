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
        Fragment home = new HomeFragment();
        Fragment schedule = new ScheduleFragment();
        Fragment speaker = new SpeakerFragment();
        Fragment media = new MediaFragment();



        home.setArguments(bundle);
        schedule.setArguments(bundle);
        speaker.setArguments(bundle);
        media.setArguments(bundle);

        switch(position) {
            case 0: return home;
            case 1: return schedule;
            case 2: return speaker;
            case 3: return media;
            default: return home;
        }

    }

    @Override
    public int getCount() {
        return 4;
    }
}
