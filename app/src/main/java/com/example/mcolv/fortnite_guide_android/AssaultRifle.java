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


public class AssaultRifle extends ListFragment  {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_assaultrifle,container, false);  // replace with your layout xml
        //look at equipment_fragment.xml yours will be a copy

        String[] titles = {
                "Assault Rifle",   //your menu titles
                "Burst Rife",
                "Scoped Rife",
                "Scar"
        };
        Integer[] imagesids = {
                R.drawable.assaultrifle, // your links to drawables jish is working on
                R.drawable.m16,
                R.drawable.assaultrifle,
                R.drawable.assaultrifle,
        };

        ArrayAdapter<String> adapter = new EquiptmentListsAdapter(getContext(),titles,imagesids); //same call here
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
                Toast.makeText(getContext(),"item1",Toast.LENGTH_LONG).show();
                //assault rifle launch
                assaultRifle_menu = new assaultrifle_m16();
                break;

            case 1:
                Toast.makeText(getContext(),"item2",Toast.LENGTH_LONG).show();
                //burst rifle launch
                assaultRifle_menu = new burst_rifle();
                break;

            case 2:
                Toast.makeText(getContext(),"item3",Toast.LENGTH_LONG).show();
                //scoped rifle launch
                assaultRifle_menu = new scoped_rifle();
                break;

            case 3:
                Toast.makeText(getContext(),"item3",Toast.LENGTH_LONG).show();
                //scar rifle launch
                assaultRifle_menu = new Scar();
                break;
        }

        if(assaultRifle_menu!=null){
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
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
