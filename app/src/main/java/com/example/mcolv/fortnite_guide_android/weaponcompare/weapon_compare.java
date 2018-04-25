package com.example.mcolv.fortnite_guide_android.weaponcompare;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mcolv.fortnite_guide_android.Equipment.Eq;
import com.example.mcolv.fortnite_guide_android.R;

public class weapon_compare extends AppCompatActivity {


    int gun1ContainerClicked = 0;
    int gun2ContainerClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon_compare);

        final TextView title = findViewById(R.id.weapon_compare_title);


        final FrameLayout gun1container = findViewById(R.id.Gun1_Frame);
        final FrameLayout gun2container = findViewById(R.id.Gun2_Frame);
        final ConstraintLayout mainlayout= findViewById(R.id.main_screen);

        final ConstraintSet constraintGun1 = new ConstraintSet();
        constraintGun1.connect(R.id.Gun1_Frame,ConstraintSet.BOTTOM,R.id.main_screen,ConstraintSet.BOTTOM,0);

        ConstraintSet constraintGun2 = new ConstraintSet();
        constraintGun2.connect(R.id.Gun2_Frame,ConstraintSet.BOTTOM,R.id.main_screen,ConstraintSet.BOTTOM,0);

        final ConstraintLayout.LayoutParams match_screen = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,ConstraintLayout.LayoutParams.MATCH_PARENT);


        final ViewGroup.LayoutParams Gun1OriginalParams = gun1container.getLayoutParams();
        final ViewGroup.LayoutParams Gun2OriginalParams = gun2container.getLayoutParams();

        gun1container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gun1ContainerClicked==0) {

                    Fragment stuff;
                    stuff = new Eq();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.Gun1_Frame, stuff);
                    transaction.commit();
                    gun1container.setLayoutParams(match_screen);
                    gun2container.setVisibility(View.INVISIBLE);
                    title.setVisibility(View.INVISIBLE);
                }
                if (gun1ContainerClicked==1){
                    gun1container.setLayoutParams(Gun1OriginalParams);
                    gun2container.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"tap again to add different gun",Toast.LENGTH_SHORT).show();
                    gun1ContainerClicked=-1;
                    title.setVisibility(View.VISIBLE);
                }
                gun1ContainerClicked++;
            }
        });

        gun2container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gun2ContainerClicked==0) {

                    Fragment stuff;
                    stuff = new Eq();
                    gun2container.setLayoutParams(match_screen);
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.Gun2_Frame, stuff);
                    transaction.commit();
                    gun1container.setVisibility(View.INVISIBLE);
                    title.setVisibility(View.INVISIBLE);
                }
                if (gun2ContainerClicked==1){
                    gun2container.setLayoutParams(Gun2OriginalParams);
                    gun1container.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"tap again to add different gun",Toast.LENGTH_SHORT).show();
                    gun2ContainerClicked=-1;
                    title.setVisibility(View.VISIBLE);
                }

                gun2ContainerClicked++;
            }
        });

    }

    @Override
    public void onBackPressed() {

        if(gun1ContainerClicked== 1 || gun2ContainerClicked==1 ){
            super.onBackPressed();
        }
        else{ finish();}

    }
}
