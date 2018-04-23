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
import android.widget.TextView;

import com.example.mcolv.fortnite_guide_android.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Eq_SG_Pump extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.eq_last_screen_template, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ImageView gunpic = view.findViewById(R.id.pic_above_table);
        gunpic.setImageResource(R.drawable.sg_pump);                //sets the sg_pump as the picture

        TextView gunlabel = view.findViewById(R.id.Gun_name);
        gunlabel.setText("Pump Shotgun");


        ImageView plusputton = view.findViewById(R.id.plusbutton);

        if(     ((ViewGroup)getView().getParent()).getId() == R.id.Gun1_Frame  ||
                ((ViewGroup)getView().getParent()).getId() == R.id.Gun2_Frame){
            plusputton.setVisibility(View.VISIBLE);
        }else{
            plusputton.setVisibility(View.INVISIBLE);
        }

        TableLayout statTable = view.findViewById(R.id.stat_table);
        TableEditor editor = new TableEditor(statTable,getContext());

        String[] textInColumn = {
                "UC",      // title for column
                "90",      //Damage
                "225",      //Headshot damage
                "0.7",      //Fire Rate
                "4.8",      //Reload Time
                "63",      //DPS
                "5",      //Mag Size

        };
        editor.add_column(textInColumn,R.color.weapon_green);

        textInColumn[0]="R";      // title for column
        textInColumn[1]="95";     //Damage
        textInColumn[2]="237.5";     //Headshot damage
        textInColumn[3]="0.7";     //Fire Rate
        textInColumn[4]="4.6";      //Reload Time
        textInColumn[5]="66.5";     //DPS
        textInColumn[6]="5";      //Mag Size
        editor.add_column(textInColumn,R.color.weapon_blue);




        super.onViewCreated(view, savedInstanceState);
    }
}
