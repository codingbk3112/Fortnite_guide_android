package com.example.mcolv.fortnite_guide_android;


import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static android.content.Context.VIBRATOR_SERVICE;


public class Eq_AR extends ListFragment  {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.eq_fragment,container, false);  // replace with your layout xml
        //look at eq_fragment.xmlwill be a copy

        String[] titles = {
                "Assault Rifle",   //your menu titles
                "Burst Rife",
                "Scoped Rife",
                "Scar"
        };
        Integer[] imagesids = {
                R.drawable.ar_m16, // your links to drawables jish is working on
                R.drawable.ar_burst,
                R.drawable.ar_scoped,
                R.drawable.ar_scar,
        };

        ArrayAdapter<String> adapter = new Eq_Adapter(getContext(),titles,imagesids); //same call here
        setListAdapter(adapter);

        return rootview;
    }
    Fragment gunmenu= null;
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) { // this is what happens on clock of each item
        super.onListItemClick(l,v,position,id);
        Vibrator listpress = (Vibrator) getActivity().getApplicationContext().getSystemService(VIBRATOR_SERVICE); // button vibration
        listpress.vibrate(50); // button vibration

        Fragment assaultRifle_menu = null;

        switch (position){

            case 0:
                //assault rifle launch
                assaultRifle_menu = new Eq_AR_M16();
                break;

            case 1:
                //burst rifle launch
                assaultRifle_menu = new Eq_AR_Burst();
                break;

            case 2:
                //scoped rifle launch
                assaultRifle_menu = new Eq_AR_Scoped();
                break;

            case 3:
                //scar rifle launch
                assaultRifle_menu = new Eq_AR_Scar();
                break;
        }

        if(assaultRifle_menu!=null){
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left,R.anim.enter_from_left,R.anim.exit_to_right);
            fragmentTransaction.replace(R.id.screen_area,assaultRifle_menu);
            fragmentTransaction.addToBackStack("assaultRifle_fragment");
            fragmentTransaction.commit();
        }




        super.onListItemClick(l, v, position, id);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }





}
