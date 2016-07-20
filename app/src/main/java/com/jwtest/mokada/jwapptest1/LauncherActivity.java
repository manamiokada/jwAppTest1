package com.jwtest.mokada.jwapptest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;

public class LauncherActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "Z14XbX1RLMtNIGUXEgv0zAaDm";
    private static final String TWITTER_SECRET = "kmZY4fNZUhYWZviretwE6Mw5Os2ksK5J3OKfGeZ6xMy8yDQrTi";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));

        setContentView(R.layout.activity_launcher);

        final ImageView splash = (ImageView) findViewById(R.id.splash_logo);
        final Animation fade = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fade_out);

        splash.startAnimation(fade);
        fade.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                //i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                startActivity(i);
                splash.setVisibility(View.INVISIBLE);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

}
