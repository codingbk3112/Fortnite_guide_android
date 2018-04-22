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
public class Eq_Pistol_handcannon extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.eq_last_screen_template, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ImageView gunpic = view.findViewById(R.id.pic_above_table);
        gunpic.setImageResource(R.drawable.pistol_handcannon);                //sets the sg_pump as the picture

        TableLayout statTable = view.findViewById(R.id.stat_table);


        TableEditor editor = new TableEditor(statTable,getContext());  // made this object to make data easy to edit
        //Grey: Common, Green: Uncommon, Blue: Rare, Purple: Epic, Orange: Legendary
        String[] textInColumn = {
                "E",      // title for column
                "75",      //Damage
                "187.5",      //Headshot damage
                "0.8",      //Fire Rate
                "2.1",      //Reload Time
                "60",      //DPS
                "7",      //Mag Size

        };
        editor.add_column(textInColumn,R.color.weapon_purple);

        textInColumn[0]="L";      // title for column
        textInColumn[1]="78";     //Damage
        textInColumn[2]="195";     //Headshot damage
        textInColumn[3]="0.8";     //Fire Rate
        textInColumn[4]="2";      //Reload Time
        textInColumn[5]="62.4";     //DPS
        textInColumn[6]="7";      //Mag Size
        editor.add_column(textInColumn,R.color.weapon_gold);



        super.onViewCreated(view, savedInstanceState);
    }
}
