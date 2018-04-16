package com.example.mcolv.fortnite_guide_android;


import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static android.content.Context.VIBRATOR_SERVICE;


public class Shotgun extends ListFragment  {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.shotgun_fragment,container, false);  // replace with your layout xml
        //look at equiptment_fragment.xml yours will be a copy

        String[] titles = {
                  //your menu titles
                "Shotgun"

        };
        Integer[] imagesids = {
                R.drawable.shotgun // your links to drawables jish is working on

        };

        ArrayAdapter<String> adapter = new EquiptmentListsAdapter(getContext(),titles,imagesids); //same call here
        setListAdapter(adapter);

        return rootview;
    }

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
                //launch shotgun fragment
                Toast.makeText(getContext(),"item3",Toast.LENGTH_LONG).show();
        }





        super.onListItemClick(l, v, position, id);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }




}
