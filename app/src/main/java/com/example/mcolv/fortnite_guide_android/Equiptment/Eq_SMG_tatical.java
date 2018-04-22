package com.example.mcolv.fortnite_guide_android.Equiptment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.example.mcolv.fortnite_guide_android.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Eq_SMG_tatical extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.eq_last_screen_template, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ImageView gunpic = view.findViewById(R.id.pic_above_table);
        gunpic.setImageResource(R.drawable.smg_tatical);                //sets the sg_pump as the picture

        TableLayout statTable = view.findViewById(R.id.stat_table);


        TableEditor editor = new TableEditor(statTable,getContext());  // made this object to make data easy to edit
        //Grey: Common, Green: Uncommon, Blue: Rare, Purple: Epic, Orange: Legendary
        String[] textInColumn = {
                "UC",      // title for column
                "16",      //Damage
                "40",      //Headshot damage
                "13",      //Fire Rate
                "2.4",      //Reload Time
                "160",      //DPS
                "35",      //Mag Size

        };
        editor.add_column(textInColumn,R.color.weapon_green);

        textInColumn[0]="R";      // title for column
        textInColumn[1]="17";     //Damage
        textInColumn[2]="42.5";     //Headshot damage
        textInColumn[3]="13";     //Fire Rate
        textInColumn[4]="2.3";      //Reload Time
        textInColumn[5]="170";     //DPS
        textInColumn[6]="35";      //Mag Size
        editor.add_column(textInColumn,R.color.weapon_blue);



        textInColumn[0]="E";      // title for column
        textInColumn[1]="18";     //Damage
        textInColumn[2]="45";     //Headshot damage
        textInColumn[3]="13";     //Fire Rate
        textInColumn[4]="2.2";      //Reload Time
        textInColumn[5]="180";     //DPS
        textInColumn[6]="35";      //Mag Size
        editor.add_column(textInColumn,R.color.weapon_purple);


        super.onViewCreated(view, savedInstanceState);
    }
}
