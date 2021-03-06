package com.example.mcolv.fortnite_guide_android.Equipment;


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


public class Eq_SG extends ListFragment  {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.eq_fragment,container, false);  // replace with your layout xml
        //look at equipment_fragment.xml yours will be a copy

        String[] titles = {
                  //your menu titles
                "Pump Shotgun",
                "Heavy Shotgun",
                "Tactical Shotgun"

        };
        Integer[] image_ids = {
                R.drawable.sg_pump, // your links to drawables josh is working on
                R.drawable.sg_heavy,
                R.drawable.sg_tatical
        };

        ArrayAdapter<String> adapter = new Eq_Adapter(getContext(),titles,image_ids); //same call here
        setListAdapter(adapter);

        return rootview;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) { // this is what happens on clock of each item
        super.onListItemClick(l,v,position,id);
        Vibrator listpress = (Vibrator) getActivity().getApplicationContext().getSystemService(VIBRATOR_SERVICE); // button vibration
        listpress.vibrate(50); // button vibration

        Fragment shotgun_menu=null;

        switch (position){

            case 0:
                shotgun_menu = new Eq_SG_Pump();
                break;
            case 1:
                shotgun_menu = new Eq_SG_heavy();
                break;
            case 2:
                shotgun_menu = new Eq_SG_tac();


        }
        if(shotgun_menu!=null){
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left,R.anim.enter_from_left,R.anim.exit_to_right);
            fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(),shotgun_menu);
            fragmentTransaction.addToBackStack("eq_sg");
            fragmentTransaction.commit();
        }





        super.onListItemClick(l, v, position, id);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }




}
