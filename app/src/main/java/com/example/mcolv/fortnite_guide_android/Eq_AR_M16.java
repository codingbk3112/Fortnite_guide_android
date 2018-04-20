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
public class Eq_AR_M16 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.eq_last_screen_template, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ImageView gunpic = view.findViewById(R.id.pic_above_table);
        gunpic.setImageResource(R.drawable.ar_m16);                //sets the sg_pump as the picture

        TableLayout statTable = view.findViewById(R.id.stat_table);
        TableEditor editor = new TableEditor(statTable,getContext());  // made this object to make data easy to edit
        //Grey: Common, Green: Uncommon, Blue: Rare, Purple: Epic, Orange: Legendary
        String[] textInColumn = {
                "C",      // title for column
                "30",      //Damage
                "60",      //Headshot damage
                "5.5",      //Fire Rate
                "2.9",      //Reload Time
                "165",      //DPS
                "30",      //Mag Size

        };
        editor.add_column(textInColumn,R.color.weapon_grey);

        textInColumn[0]="UC";      // title for column
        textInColumn[1]="31";     //Damage
        textInColumn[2]="62";     //Headshot damage
        textInColumn[3]="4.06";     //Fire Rate
        textInColumn[4]="5.5";      //Reload Time
        textInColumn[5]="170.5";     //DPS
        textInColumn[6]="30";      //Mag Size
        editor.add_column(textInColumn,R.color.weapon_green);



        textInColumn[0]="R";      // title for column
        textInColumn[1]="33";     //Damage
        textInColumn[2]="66";     //Headshot damage
        textInColumn[3]="4.06";     //Fire Rate
        textInColumn[4]="5.5";      //Reload Time
        textInColumn[5]="181.5";     //DPS
        textInColumn[6]="30";      //Mag Size
        editor.add_column(textInColumn,R.color.weapon_blue);


        super.onViewCreated(view, savedInstanceState);
    }

}
