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


public class Eq_Pistol extends ListFragment  {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.eq_fragment,container, false);  // replace with your layout xml
        //look at equipment_fragment.xml yours will be a copy

        String[] titles = {
                //your menu titles
                "Pistol",
                "Hand Cannon",
                "Revolver",
                "Silenced"

        };
        Integer[] image_ids = {
                R.drawable.pistol_basic, // your links to drawables josh is working on
                R.drawable.pistol_handcannon,
                R.drawable.pistol_revolver,
                R.drawable.pistol_scilenced
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

        Fragment pistol_menu=null;

        switch (position){

            case 0:
                pistol_menu = new Eq_Pistol_basic();
                break;
            case 1:
                pistol_menu = new Eq_Pistol_handcannon();
                break;
            case 2:
                pistol_menu = new Eq_Pistol_revolver();
                break;
            case 3 :
                pistol_menu = new Eq_Pistol_silenced();


        }
        if(pistol_menu!=null){
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left,R.anim.enter_from_left,R.anim.exit_to_right);
            fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(),pistol_menu);
            fragmentTransaction.addToBackStack("eq_pistol");
            fragmentTransaction.commit();
        }





        super.onListItemClick(l, v, position, id);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }




}
