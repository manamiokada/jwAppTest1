package com.jwtest.mokada.jwapptest1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements HomeFragment.OnFragmentInteractionListener,
        ScheduleFragment.OnFragmentInteractionListener, SpeakerFragment.OnFragmentInteractionListener, MediaFragment.OnFragmentInteractionListener {

    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
        final ImageView actionLogo = (ImageView)findViewById(R.id.head);
        actionLogo.setColorFilter(Color.WHITE);


         **/



        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics ();
        display.getMetrics(outMetrics);

        ScreenDensity screenDensity = new ScreenDensity();

        float density  = getResources().getDisplayMetrics().density;
        float dpHeight = outMetrics.heightPixels / density;
        float dpWidth = outMetrics.widthPixels / density;

        Bundle bundle = new Bundle();
        bundle.putFloat("density", density);
        bundle.putFloat("height", dpHeight);
        bundle.putFloat("width", dpWidth);



        /**
        // Setting button
        final ImageView gear = (ImageView)findViewById(R.id.gear);
        //gear.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
        gear.setColorFilter(Color.WHITE);
        gear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SettingActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
        **/

        // Menu buttons
        final ImageView homeButton = (ImageView)findViewById(R.id.home_button);
        final TextView homeTitle = (TextView)findViewById(R.id.home_title);
        final ImageView scheduleButton = (ImageView)findViewById(R.id.schedule_button);
        final TextView scheduleTitle = (TextView)findViewById(R.id.schedule_title);
        final ImageView speakerButton = (ImageView)findViewById(R.id.speaker_button);
        final TextView speakerTitle = (TextView)findViewById(R.id.speaker_title);
        final ImageView mediaButton = (ImageView)findViewById(R.id.media_button);
        final TextView mediaTitle = (TextView)findViewById(R.id.media_title);

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager(), bundle);
        viewPager.setAdapter(swipeAdapter);
        viewPager.setCurrentItem(0);

        // Set default colors
        homeButton.setColorFilter(Color.WHITE);
        homeTitle.setTextColor(Color.WHITE);
        scheduleButton.setColorFilter(R.color.buttonPressed);
        scheduleTitle.setTextColor(Color.GRAY);
        speakerButton.setColorFilter(R.color.buttonPressed);
        speakerTitle.setTextColor(Color.GRAY);
        mediaButton.setColorFilter(R.color.buttonPressed);
        mediaTitle.setTextColor(Color.GRAY);


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
                        //homeButton.setColorFilter(Color.parseColor("#80cbc4"));
                        //homeTitle.setTextColor(Color.parseColor("#80cbc4"));
                        homeButton.setColorFilter(Color.WHITE);
                        homeTitle.setTextColor(Color.WHITE);
                        scheduleButton.setColorFilter(R.color.buttonPressed);
                        scheduleTitle.setTextColor(Color.GRAY);
                        speakerButton.setColorFilter(R.color.buttonPressed);
                        speakerTitle.setTextColor(Color.GRAY);
                        mediaButton.setColorFilter(R.color.buttonPressed);
                        mediaTitle.setTextColor(Color.GRAY);
                        break;
                    case 1:
                        homeButton.setColorFilter(R.color.buttonPressed);
                        homeTitle.setTextColor(Color.GRAY);
                        scheduleButton.setColorFilter(Color.WHITE);
                        scheduleTitle.setTextColor(Color.WHITE);
                        speakerButton.setColorFilter(R.color.buttonPressed);
                        speakerTitle.setTextColor(Color.GRAY);
                        mediaButton.setColorFilter(R.color.buttonPressed);
                        mediaTitle.setTextColor(Color.GRAY);
                        break;
                    case 2:
                        homeButton.setColorFilter(R.color.buttonPressed);
                        homeTitle.setTextColor(Color.GRAY);
                        scheduleButton.setColorFilter(R.color.buttonPressed);
                        scheduleTitle.setTextColor(Color.GRAY);
                        speakerButton.setColorFilter(Color.WHITE);
                        speakerTitle.setTextColor(Color.WHITE);
                        mediaButton.setColorFilter(R.color.buttonPressed);
                        mediaTitle.setTextColor(Color.GRAY);
                        break;
                    case 3:
                        homeButton.setColorFilter(R.color.buttonPressed);
                        homeTitle.setTextColor(Color.GRAY);
                        scheduleButton.setColorFilter(R.color.buttonPressed);
                        scheduleTitle.setTextColor(Color.GRAY);
                        speakerButton.setColorFilter(R.color.buttonPressed);
                        speakerTitle.setTextColor(Color.GRAY);
                        mediaButton.setColorFilter(Color.WHITE);
                        mediaTitle.setTextColor(Color.WHITE);
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
