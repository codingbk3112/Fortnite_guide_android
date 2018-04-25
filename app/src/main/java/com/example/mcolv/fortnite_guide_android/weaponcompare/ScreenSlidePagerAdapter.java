package com.example.mcolv.fortnite_guide_android.weaponcompare;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> frags = new ArrayList<>();


    public void add(Fragment fragment){
        frags.add(fragment);
        notifyDataSetChanged();
    }

    public void popback(){
        frags.remove(frags.size()-1);
        notifyDataSetChanged();
    }
    public void empty(){
        frags.clear();
    }

    @Override
    public int getCount() {
        return frags.size();
    }

    @Override
    public Fragment getItem(int position) {
        return frags.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //dont destroy item
    }

    public ScreenSlidePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }


}
