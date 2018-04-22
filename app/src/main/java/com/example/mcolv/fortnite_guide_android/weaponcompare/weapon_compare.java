package com.example.mcolv.fortnite_guide_android.weaponcompare;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.mcolv.fortnite_guide_android.Equiptment.Eq;
import com.example.mcolv.fortnite_guide_android.R;

public class weapon_compare extends AppCompatActivity {

    int pages_added = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon_compare);

        final ViewPager pager;
        pager = findViewById(R.id.fragpager);
        final ScreenSlidePagerAdapter adapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                                          @Override
                                          public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                                          }

                                          @Override
                                          public void onPageSelected(int position) {
                                              TextView title = findViewById(R.id.gun_number);
                                              String page = Integer.toString(position+1);
                                              title.setText("Weapon #"+page);
                                          }

                                          @Override
                                          public void onPageScrollStateChanged(int state) {

                                          }
                                      });




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.add(new Eq_holder());
                pager.setCurrentItem(pages_added);
                pages_added++;

            }
        });





    }


    @Override
    public void onBackPressed() {
        finish();
    }
}
