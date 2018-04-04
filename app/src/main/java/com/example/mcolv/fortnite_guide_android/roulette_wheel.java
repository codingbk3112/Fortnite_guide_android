package com.example.mcolv.fortnite_guide_android;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Random;

public class roulette_wheel extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //final ImageView marker= new ImageView(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette_wheel);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // code for roulette button
        final Button jump_button = findViewById(R.id.Roulette_button);
        jump_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes button press
                Random rand_x=new Random();
                Random rand_y=new Random();

                int random_x=rand_x.nextInt(1000);
                int random_y=rand_y.nextInt(1000);

                //create randomeness for x and y here

                ImageView marker= findViewById(R.id.map_marker); //created image view in code and linked to xml

                ConstraintLayout map_layout=findViewById(R.id.roulette_Layout); // created layout and linked to xml
                ConstraintSet set = new ConstraintSet();

                map_layout.removeView(marker);
                map_layout.addView(marker);   //add image view
                set.clone(map_layout);                     //clone image view
                set.connect(marker.getId(),ConstraintSet.TOP,map_layout.getId(),ConstraintSet.TOP,random_x);
                set.connect(marker.getId(),ConstraintSet.END,map_layout.getId(),ConstraintSet.END,random_y);
                set.applyTo(map_layout);

            }
        });
    }


}
