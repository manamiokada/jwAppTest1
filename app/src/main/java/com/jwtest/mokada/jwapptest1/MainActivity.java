package com.jwtest.mokada.jwapptest1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.ToolbarWidgetWrapper;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");


        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container, new HomeFragment());
        fragmentTransaction.commit();


        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.home_id :
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new HomeFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Home");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.about_id :
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new AboutFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("About");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.schedule_id :
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new ScheduleFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Schedule");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.speakers_id :
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new SpeakerFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Speakers");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.media_id :
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new MediaFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Media");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.settings_id :
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new SettingsFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Settings");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                }
                return true;
            }
        });



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
         **/
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }



}
