package com.example.mcolv.fortnite_guide_android;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Eq_AR_Burst extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.eq_lists_element, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ImageView gunpic = view.findViewById(R.id.pic_above_table);
        gunpic.setImageResource(R.drawable.ar_scar);                //sets the shotgun as the picture

        TableLayout statTable = view.findViewById(R.id.stat_table);
        TableEditor editor = new TableEditor(statTable,getContext());  // made this object to make data easy to edit
        //Grey: Common, Green: Uncommon, Blue: Rare, Purple: Epic, Orange: Legendary
        String[] textInColumnGy = {
                "C",      // title for column
                "27",      //Damage
                "67.5",      //Headshot damage
                "4.06",      //Fire Rate
                "2.9",      //Reload Time
                "109.7",      //DPS
                "30",      //Mag Size

        };

        editor.add_column(textInColumnGy,R.color.weapon_grey);


        String[] textInColumnGr = {
                "UC",      // title for column
                "29",      //Damage
                "72.5",      //Headshot damage
                "4.06",      //Fire Rate
                "2.7",      //Reload Time
                "117.9",      //DPS
                "30",      //Mag Size

        };

        editor.add_column(textInColumnGr,R.color.weapon_green);



        String[] textInColumnBl = {
                "R",      // title for column
                "30",      //Damage
                "75",      //Headshot damage
                "4.06",      //Fire Rate
                "2.6",      //Reload Time
                "121.9",      //DPS
                "30",      //Mag Size

        };

        editor.add_column(textInColumnBl,R.color.weapon_blue);


        super.onViewCreated(view, savedInstanceState);
    }
}
