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


public class Eq extends ListFragment  {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.Eq_Fragment,container, false);  // replace with your layout xml
        //look at equiptment_fragment.xml yours will be a copy

        String[] titles = {
                "Assault Rifle",   //your menu titles
                "Sniper",
                "Shotgun",
                "SMG",
                "Pistol",
                "Explosives",
                "Healing",
                "Utilities"
        };
        Integer[] imagesids = {
                R.drawable.assaultrifle, // your links to drawables jish is working on
                R.drawable.sniper,
                R.drawable.shotgun,
                R.drawable.smg,
                R.drawable.pistol,
                R.drawable.explosives,
                R.drawable.bandages,
                R.drawable.utilities
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


        switch (position){

            case 0:
                Toast.makeText(getContext(),"item1",Toast.LENGTH_LONG).show();
                //first item in list link to press this will eventually launch your fragment
                break;
            case 1:
                //launch sniper fragment
                Toast.makeText(getContext(),"item2",Toast.LENGTH_LONG).show();
                break;
            case 2:
                gunmenu= new Eq_SG();
                //launch shotgun fragment
                Toast.makeText(getContext(),"item3",Toast.LENGTH_LONG).show();
        }

        if(gunmenu!=null){
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.screen_area,gunmenu);
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
