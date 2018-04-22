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
public class Eq_Pistol_revolver extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.eq_last_screen_template, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ImageView gunpic = view.findViewById(R.id.pic_above_table);
        gunpic.setImageResource(R.drawable.pistol_revolver);                //sets the sg_pump as the picture

        TableLayout statTable = view.findViewById(R.id.stat_table);


        TableEditor editor = new TableEditor(statTable,getContext());  // made this object to make data easy to edit
        //Grey: Common, Green: Uncommon, Blue: Rare, Purple: Epic, Orange: Legendary
        String[] textInColumn = {
                "C",      // title for column
                "54",      //Damage
                "135",      //Headshot damage
                "0.9",      //Fire Rate
                "2.4",      //Reload Time
                "48.6",      //DPS
                "6",      //Mag Size

        };
        editor.add_column(textInColumn,R.color.weapon_grey);

        textInColumn[0]="UC";      // title for column
        textInColumn[1]="57";     //Damage
        textInColumn[2]="142.7";     //Headshot damage
        textInColumn[3]="0.9";     //Fire Rate
        textInColumn[4]="2.3";      //Reload Time
        textInColumn[5]="51.3";     //DPS
        textInColumn[6]="6";      //Mag Size
        editor.add_column(textInColumn,R.color.weapon_green);



        textInColumn[0]="R";      // title for column
        textInColumn[1]="60";     //Damage
        textInColumn[2]="150";     //Headshot damage
        textInColumn[3]="0.9";     //Fire Rate
        textInColumn[4]="2.2";      //Reload Time
        textInColumn[5]="54";     //DPS
        textInColumn[6]="6";      //Mag Size
        editor.add_column(textInColumn,R.color.weapon_blue);


        super.onViewCreated(view, savedInstanceState);
    }
}
