package com.example.mcolv.fortnite_guide_android.Equipment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.mcolv.fortnite_guide_android.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Eq_AR_Scar extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.eq_last_screen_template, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ImageView gunpic = view.findViewById(R.id.pic_above_table);
        gunpic.setImageResource(R.drawable.ar_scar);                //sets the sg_pump as the picture

        TextView gunlabel = view.findViewById(R.id.Gun_name);
        gunlabel.setText("Scar");

        ImageView plusputton = view.findViewById(R.id.plusbutton);

        if(     ((ViewGroup)getView().getParent()).getId() == R.id.Gun1_Frame  ||
                ((ViewGroup)getView().getParent()).getId() == R.id.Gun2_Frame){
            plusputton.setVisibility(View.VISIBLE);
        }else{
            plusputton.setVisibility(View.INVISIBLE);
        }

        TableLayout statTable = view.findViewById(R.id.stat_table);
        TableEditor editor = new TableEditor(statTable,getContext());  // made this object to make data easy to edit
        //Grey: Common, Green: Uncommon, Blue: Rare, Purple: Epic, Orange: Legendary
        String[] textInColumn = {
                "E",      // title for column
                "35",      //Damage
                "70",      //Headshot damage
                "5.5",      //Fire Rate
                "2.2",      //Reload Time
                "192.5",      //DPS
                "30",      //Mag Size

        };
        editor.add_column(textInColumn,R.color.weapon_purple);


        textInColumn[0]="L";      // title for column
        textInColumn[1]="36";     //Damage
        textInColumn[2]="72";     //Headshot damage
        textInColumn[3]="5.5";     //Fire Rate
        textInColumn[4]="2.1";      //Reload Time
        textInColumn[5]="198";     //DPS
        textInColumn[6]="30";      //Mag Size
        editor.add_column(textInColumn,R.color.weapon_gold);


        super.onViewCreated(view, savedInstanceState);
    }
}
