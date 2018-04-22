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
public class Eq_Snipe_hunting extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.eq_last_screen_template, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ImageView gunpic = view.findViewById(R.id.pic_above_table);
        gunpic.setImageResource(R.drawable.snipe_hunting);                //sets the sg_pump as the picture

        TableLayout statTable = view.findViewById(R.id.stat_table);


        TableEditor editor = new TableEditor(statTable,getContext());  // made this object to make data easy to edit
        //Grey: Common, Green: Uncommon, Blue: Rare, Purple: Epic, Orange: Legendary
        String[] textInColumn = {
                "UC",      // title for column
                "86",      //Damage
                "215",      //Headshot damage
                "0.8",      //Fire Rate
                "1.9",      //Reload Time
                "68.8",      //DPS
                "1",      //Mag Size

        };
        editor.add_column(textInColumn,R.color.weapon_green);

        textInColumn[0]="R";      // title for column
        textInColumn[1]="90";     //Damage
        textInColumn[2]="225";     //Headshot damage
        textInColumn[3]="0.8";     //Fire Rate
        textInColumn[4]="1.8";      //Reload Time
        textInColumn[5]="72";     //DPS
        textInColumn[6]="1";      //Mag Size
        editor.add_column(textInColumn,R.color.weapon_blue);



        super.onViewCreated(view, savedInstanceState);
    }
}
