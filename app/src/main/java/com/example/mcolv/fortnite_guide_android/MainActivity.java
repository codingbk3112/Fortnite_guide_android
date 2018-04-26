package com.example.mcolv.fortnite_guide_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.mcolv.fortnite_guide_android.Equipment.Eq;
import com.example.mcolv.fortnite_guide_android.JumpRoulette.RandomJump;
import com.example.mcolv.fortnite_guide_android.weaponcompare.weapon_compare;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setVisibility(View.INVISIBLE);

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button equiptment = findViewById(R.id.main_screen_eq_button);
        Button weaponcompare = findViewById(R.id.main_screen_weapon_compare);
        Button jumproulette = findViewById(R.id.main_screen_jump_roulette);


        equiptment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragment = new Eq();

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left,R.anim.enter_from_left,R.anim.exit_to_right);
                fragmentTransaction.replace(R.id.screen_area,fragment);
                fragmentTransaction.addToBackStack("fragment");
                fragmentTransaction.commit();
            }

        });



        jumproulette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new RandomJump();

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left,R.anim.enter_from_left,R.anim.exit_to_right);
                fragmentTransaction.replace(R.id.screen_area,fragment);
                fragmentTransaction.addToBackStack("fragment");
                fragmentTransaction.commit();
            }
        });


        weaponcompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),weapon_compare.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {


        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();

        }
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private Fragment fragment=null;

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        while(getSupportFragmentManager().getBackStackEntryCount()> 0){ //clears back stack so dont have to go through every fragment sublevel
            getSupportFragmentManager().popBackStackImmediate();
        }
        switch (item.getItemId()){

            case R.id.Equipment_menu :
                fragment= new Eq();
                break;
            case R.id.random_wheel :
                fragment = new RandomJump();
                break;
            case R.id.weapon_compare :
                Intent intent=new Intent(this,weapon_compare.class);
                startActivity(intent);
                break;
            case R.id.guides :
                fragment = null; // for now...
                break;
            case R.id.share :

                break;
            default:
                fragment=null;

        }

        if(fragment!=null){

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left,R.anim.enter_from_left,R.anim.exit_to_right);
            fragmentTransaction.replace(R.id.screen_area,fragment);
            fragmentTransaction.addToBackStack("fragment");
            fragmentTransaction.commit();
        }

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

