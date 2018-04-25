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
public class Eq_Snipe_bolt extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.eq_last_screen_template, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ImageView gunpic = view.findViewById(R.id.pic_above_table);
        gunpic.setImageResource(R.drawable.snipe_bolt);                //sets the sg_pump as the picture

        TableLayout statTable = view.findViewById(R.id.stat_table);

        TextView gunlabel = view.findViewById(R.id.Gun_name);
        gunlabel.setText("Bolt-Action Sniper");


        ImageView plusputton = view.findViewById(R.id.plusbutton);

        if(     ((ViewGroup)getView().getParent()).getId() == R.id.Gun1_Frame  ||
                ((ViewGroup)getView().getParent()).getId() == R.id.Gun2_Frame){
            plusputton.setVisibility(View.VISIBLE);
        }else{
            plusputton.setVisibility(View.INVISIBLE);
        }

        TableEditor editor = new TableEditor(statTable,getContext());  // made this object to make data easy to edit
        //Grey: Common, Green: Uncommon, Blue: Rare, Purple: Epic, Orange: Legendary
        String[] textInColumn = {
                "R",      // title for column
                "105",      //Damage
                "262.5",      //Headshot damage
                "0.33",      //Fire Rate
                "3",      //Reload Time
                "34.7",      //DPS
                "1",      //Mag Size

        };
        editor.add_column(textInColumn,R.color.weapon_blue);

        textInColumn[0]="E";      // title for column
        textInColumn[1]="110";     //Damage
        textInColumn[2]="275";     //Headshot damage
        textInColumn[3]="0.33";     //Fire Rate
        textInColumn[4]="2.8";      //Reload Time
        textInColumn[5]="36.3";     //DPS
        textInColumn[6]="1";      //Mag Size
        editor.add_column(textInColumn,R.color.weapon_purple);



        textInColumn[0]="L";      // title for column
        textInColumn[1]="116";     //Damage
        textInColumn[2]="290";     //Headshot damage
        textInColumn[3]="0.33";     //Fire Rate
        textInColumn[4]="2.7";      //Reload Time
        textInColumn[5]="38.3";     //DPS
        textInColumn[6]="1";      //Mag Size
        editor.add_column(textInColumn,R.color.weapon_gold);


        super.onViewCreated(view, savedInstanceState);
    }
}
