package com.example.mcolv.fortnite_guide_android.JumpRoulette;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mcolv.fortnite_guide_android.R;

import static android.content.Context.VIBRATOR_SERVICE;

public class RandomJump extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.random_jump_fragment,null);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

            final Context context = RandomJump.super.getContext();
            final landzone_container land_spots = new landzone_container();
            final Vibrator buttonvibe = (Vibrator) context.getSystemService(VIBRATOR_SERVICE);
            final ImageView mapMarker= new ImageView(context);
            final RelativeLayout map_layout=view.findViewById(R.id.roulette_Layout); // created layout and linked to xml
            final ImageView fortnite_map_imgview=view.findViewById(R.id.fortnite_imageview);

            map_layout.addView(mapMarker,(int)dptopx(context,11),(int)dptopx(context,23));
            mapMarker.setBackground(getResources().getDrawable(R.drawable.marker));



            fortnite_map_imgview.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {


                    buttonvibe.vibrate(50);

                    land_zone dropspot = land_spots.get_random_zone();



                    dropspot = land_spots.get_random_zone();

                    //Toast.makeText(context,dropspot.get_title(),Toast.LENGTH_LONG).show();
                    animate_marker(mapMarker, dropspot.get_x(), dropspot.get_y(),context); // x and y given in dp





                }
            });
        }


    public float dptopx(android.content.Context context, float dp) {
        int conversion_factor = context.getResources().getDimensionPixelSize(R.dimen.dp_1);
        return(dp*conversion_factor);
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

                if(android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                    buttonsound.start();
                }


            }

        });

    }




}

