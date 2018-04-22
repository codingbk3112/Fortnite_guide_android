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
public class Eq_SG_tac extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.eq_last_screen_template, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ImageView gunpic = view.findViewById(R.id.pic_above_table);
        gunpic.setImageResource(R.drawable.sg_tatical);                //sets the sg_pump as the picture

        TableLayout statTable = view.findViewById(R.id.stat_table);


        TableEditor editor = new TableEditor(statTable,getContext());  // made this object to make data easy to edit
        //Grey: Common, Green: Uncommon, Blue: Rare, Purple: Epic, Orange: Legendary
        String[] textInColumn = {
                "C",      // title for column
                "67",      //Damage
                "167.5",      //Headshot damage
                "1.5",      //Fire Rate
                "6.3",      //Reload Time
                "100.5",      //DPS
                "8",      //Mag Size

        };
        editor.add_column(textInColumn,R.color.weapon_grey);

        textInColumn[0]="UC";      // title for column
        textInColumn[1]="70";     //Damage
        textInColumn[2]="175";     //Headshot damage
        textInColumn[3]="1.5";     //Fire Rate
        textInColumn[4]="6";      //Reload Time
        textInColumn[5]="105";     //DPS
        textInColumn[6]="8";      //Mag Size
        editor.add_column(textInColumn,R.color.weapon_green);



        textInColumn[0]="R";      // title for column
        textInColumn[1]="74";     //Damage
        textInColumn[2]="185";     //Headshot damage
        textInColumn[3]="1.5";     //Fire Rate
        textInColumn[4]="5.7";      //Reload Time
        textInColumn[5]="111";     //DPS
        textInColumn[6]="8";      //Mag Size
        editor.add_column(textInColumn,R.color.weapon_blue);


        super.onViewCreated(view, savedInstanceState);
    }
}
