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
public class Eq_Pistol_basic extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.eq_last_screen_template, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ImageView gunpic = view.findViewById(R.id.pic_above_table);
        gunpic.setImageResource(R.drawable.pistol_basic);                //sets the sg_pump as the picture

        TextView gunlabel = view.findViewById(R.id.Gun_name);
        gunlabel.setText("Basic Pistol");



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
                "C",      // title for column
                "23",      //Damage
                "57.5",      //Headshot damage
                "6.75",      //Fire Rate
                "1.5",      //Reload Time
                "155.2",      //DPS
                "16",      //Mag Size

        };
        editor.add_column(textInColumn,R.color.weapon_grey);

        textInColumn[0]="UC";      // title for column
        textInColumn[1]="24";     //Damage
        textInColumn[2]="60";     //Headshot damage
        textInColumn[3]="6.75";     //Fire Rate
        textInColumn[4]="1.5";      //Reload Time
        textInColumn[5]="162";     //DPS
        textInColumn[6]="16";      //Mag Size
        editor.add_column(textInColumn,R.color.weapon_green);



        textInColumn[0]="R";      // title for column
        textInColumn[1]="25";     //Damage
        textInColumn[2]="62.5";     //Headshot damage
        textInColumn[3]="6.75";     //Fire Rate
        textInColumn[4]="1.4";      //Reload Time
        textInColumn[5]="168.8";     //DPS
        textInColumn[6]="16";      //Mag Size
        editor.add_column(textInColumn,R.color.weapon_blue);


        super.onViewCreated(view, savedInstanceState);
    }
}
