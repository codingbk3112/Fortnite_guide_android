package com.example.mcolv.fortnite_guide_android.Equiptment;


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

import com.example.mcolv.fortnite_guide_android.R;

import static android.content.Context.VIBRATOR_SERVICE;


public class Eq_Heal extends ListFragment  {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.eq_fragment,container, false);

        String[] titles = {
                "Bandages",   //your menu titles
                "Med Kit",
                "Small Potion",
                "Chug Jug"
        };
        Integer[] imagesids = {
                R.drawable.heal_bandage, // your links to drawables jish is working on
                R.drawable.heal_medkit,
                R.drawable.heal_small_potion,
                R.drawable.heal_chugjug

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

        Fragment healing_menu = null;

        switch (position){

            case 0:
                //bandage launch
                break;

            case 1:
                //medkit launch
                break;

            case 2:
                //small potion launch
                break;

            case 3:
                //chug jug launch
                break;
        }

        if(healing_menu!=null){
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left,R.anim.enter_from_left,R.anim.exit_to_right);
            fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(),healing_menu);
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
