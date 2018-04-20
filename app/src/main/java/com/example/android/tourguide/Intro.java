package com.example.android.tourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        /*
         * setting the logo into var
         */
        ImageView logo = (ImageView) findViewById(R.id.logo);
        /*
         *calling intro transition time
         */
        Animation intro = AnimationUtils.loadAnimation(this, R.anim.intro_transition);
        /*
         * start logo animation
         */
        logo.startAnimation(intro);
        /*
         * transiting between intro activity(layout) to login activity
         */
        final Intent loginIntent = new Intent(this, Login.class);
        /*
         * setting a timer for the transition between the two layouts
         */
        Thread timer = new Thread() {
            public void run() {

                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(loginIntent);
                    finish();
                }
            }
        };
        timer.start();
    }
}
