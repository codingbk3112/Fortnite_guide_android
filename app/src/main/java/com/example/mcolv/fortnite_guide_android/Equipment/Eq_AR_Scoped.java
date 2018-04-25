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
public class Eq_AR_Scoped extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.eq_last_screen_template, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ImageView gunpic = view.findViewById(R.id.pic_above_table);
        gunpic.setImageResource(R.drawable.ar_scoped);                //sets the sg_pump as the picture

        TextView gunlabel = view.findViewById(R.id.Gun_name);
        gunlabel.setText("Scoped Assault Rifle");


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
                "R",      // title for column
                "23",      //Damage
                "46",      //Headshot damage
                "3.5",      //Fire Rate
                "2.3",      //Reload Time
                "80.5",      //DPS
                "20",      //Mag Size

        };
        editor.add_column(textInColumn,R.color.weapon_blue);

        textInColumn[0]="E";      // title for column
        textInColumn[1]="24";     //Damage
        textInColumn[2]="48";     //Headshot damage
        textInColumn[3]="3.5";     //Fire Rate
        textInColumn[4]="2.2";      //Reload Time
        textInColumn[5]="84";     //DPS
        textInColumn[6]="20";      //Mag Size
        editor.add_column(textInColumn,R.color.weapon_purple);




        super.onViewCreated(view, savedInstanceState);
    }
}
