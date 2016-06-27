package com.jwtest.mokada.jwapptest1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends FragmentActivity implements HomeFragment.OnFragmentInteractionListener,
        ScheduleFragment.OnFragmentInteractionListener, SpeakerFragment.OnFragmentInteractionListener, MediaFragment.OnFragmentInteractionListener {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Setting button
        final ImageView gear = (ImageView)findViewById(R.id.gear);
        gear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SettingActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });

        // Menu buttons
        final ImageView homeButton = (ImageView)findViewById(R.id.home_button);
        final ImageView scheduleButton = (ImageView)findViewById(R.id.schedule_button);
        final ImageView speakerButton = (ImageView)findViewById(R.id.speaker_button);
        final ImageView mediaButton = (ImageView)findViewById(R.id.media_button);

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdapter);
        viewPager.setCurrentItem(0);

        homeButton.setColorFilter(null);
        scheduleButton.setColorFilter(Color.parseColor("#bdbdbd"));
        speakerButton.setColorFilter(Color.parseColor("#bdbdbd"));
        mediaButton.setColorFilter(Color.parseColor("#bdbdbd"));


        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);

            }
        });

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        speakerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });

        mediaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3);
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        homeButton.setColorFilter(null);
                        scheduleButton.setColorFilter(Color.parseColor("#bdbdbd"));
                        speakerButton.setColorFilter(Color.parseColor("#bdbdbd"));
                        mediaButton.setColorFilter(Color.parseColor("#bdbdbd"));
                        break;
                    case 1:
                        homeButton.setColorFilter(Color.parseColor("#bdbdbd"));
                        scheduleButton.setColorFilter(null);
                        speakerButton.setColorFilter(Color.parseColor("#bdbdbd"));
                        mediaButton.setColorFilter(Color.parseColor("#bdbdbd"));
                        break;
                    case 2:
                        homeButton.setColorFilter(Color.parseColor("#bdbdbd"));
                        scheduleButton.setColorFilter(Color.parseColor("#bdbdbd"));
                        speakerButton.setColorFilter(null);
                        mediaButton.setColorFilter(Color.parseColor("#bdbdbd"));
                        break;
                    case 3:
                        homeButton.setColorFilter(Color.parseColor("#bdbdbd"));
                        scheduleButton.setColorFilter(Color.parseColor("#bdbdbd"));
                        speakerButton.setColorFilter(Color.parseColor("#bdbdbd"));
                        mediaButton.setColorFilter(null);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
