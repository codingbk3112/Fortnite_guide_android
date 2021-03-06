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


public class Eq extends ListFragment  {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.eq_fragment,container, false);  // replace with your layout xml
        //look at equipment_fragment.xml yours will be a copy

        String[] titles = {
                "Assault Rifle",   //your menu titles
                "Sniper",
                "Shotgun",
                "SMG",
                "Machine Gun",
                "Pistol",
                "Explosives",
                "Healing",
                "Utilities"
        };
        Integer[] image_ids = {
                R.drawable.ar_scar, // your links to drawables josh is working on
                R.drawable.snipe_bolt,
                R.drawable.sg_pump,
                R.drawable.smg_tatical,
                R.drawable.machienegun_light,
                R.drawable.pistol_basic,
                R.drawable.exp_rpg,
                R.drawable.heal_bandage,
                R.drawable.util_launchpad
        };

        ArrayAdapter<String> adapter = new Eq_Adapter(getContext(),titles,image_ids); //same call here
        setListAdapter(adapter);

        return rootview;
    }
    Fragment gunmenu= null;
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) { // this is what happens on clock of each item
        super.onListItemClick(l,v,position,id);
        Vibrator listpress = (Vibrator) getActivity().getApplicationContext().getSystemService(VIBRATOR_SERVICE); // button vibration
        listpress.vibrate(50); // button vibration


        switch (position){

            case 0:
                gunmenu = new Eq_AR();
                break;
            case 1:
                gunmenu = new Eq_Snipe();
                break;
            case 2:
                gunmenu= new Eq_SG();
                break;
            case 3:
                gunmenu = new Eq_SMG();
                break;
            case 4 :
                gunmenu = new Eq_Machinegun();
                break;
            case 5:
                gunmenu = new Eq_Pistol();
                break;
            case 6:
                gunmenu = new Eq_Explosives();
                break;
            case 7:
                gunmenu = new Eq_Heal();
                break;
            case 8:
                gunmenu= new Eq_util();
                break;
            default:
                gunmenu=null;
        }

        if(gunmenu!=null){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left,R.anim.enter_from_left,R.anim.exit_to_right);
            fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(),gunmenu);
            fragmentTransaction.addToBackStack("gun_fragment");
            fragmentTransaction.commit();
        }




        super.onListItemClick(l, v, position, id);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
     super.onViewCreated(view, savedInstanceState);




    }
    




}
