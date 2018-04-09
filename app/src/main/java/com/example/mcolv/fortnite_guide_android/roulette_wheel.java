package com.example.mcolv.fortnite_guide_android;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.support.annotation.Dimension;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import static java.sql.DriverManager.println;


public class roulette_wheel extends AppCompatActivity {


        @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette_wheel);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ready to Jump?");
        setTheme(R.style.AppTheme);

        final landzone_container land_spots = new landzone_container();
        final Vibrator buttonvibe = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        final ImageView mapMarker= new ImageView(this);
        final RelativeLayout map_layout=findViewById(R.id.roulette_Layout); // created layout and linked to xml
        final ImageView fortnite_map_imgview=findViewById(R.id.fortnite_imageview);
        final Context context = this;
                map_layout.addView(mapMarker,(int)dptopx(context,11),(int)dptopx(context,23));
        mapMarker.setBackground(getDrawable(R.drawable.marker));




        // code for roulette button
        final Button jump_button = findViewById(R.id.Roulette_button);
        jump_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                jump_button.setEnabled(false);
                buttonvibe.vibrate(50);

                land_zone dropspot = land_spots.get_random_zone();



                dropspot = land_spots.get_random_zone();
                animate_marker(mapMarker, dropspot.get_x(), dropspot.get_y(),context); // x and y given in dp


                getSupportActionBar().setTitle(dropspot.get_title());//change toolbar to message about drop

                jump_button.setEnabled(true);

            }
        });
    }


    public void animate_marker(final ImageView marker,final float x_indp,final float y_indp,Context context){

        final MediaPlayer buttonsound =MediaPlayer.create(context,R.raw.mapbeep);
        final float old_x = marker.getX();
        final float old_y = marker.getY();

        final float x = dptopx(context,x_indp);
        final float y = dptopx(context,y_indp);


        Animation a;
        a = new TranslateAnimation(0,x-old_x,0,y-old_y);//from current location to new
        a.setFillAfter(false);
        a.setFillEnabled(false);
        a.setDuration(1000);
        marker.startAnimation(a);

        a.setAnimationListener(new TranslateAnimation.AnimationListener(){

            @Override
            public void onAnimationStart(Animation a) {};


            @Override
            public void onAnimationRepeat(Animation a){};


            @Override
            public void onAnimationEnd(Animation a) {

                marker.clearAnimation();

                marker.setX(x);
                marker.setY(y);

                buttonsound.start();



            }

        });

    }
    public float dptopx(Context context, float dp) {
        int conversion_factor = context.getResources().getDimensionPixelSize(R.dimen.dp_1);
        return(dp*conversion_factor);
    }
}




