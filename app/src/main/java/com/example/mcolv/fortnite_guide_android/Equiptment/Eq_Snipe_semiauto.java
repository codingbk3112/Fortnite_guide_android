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
public class Eq_Snipe_semiauto extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.eq_last_screen_template, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ImageView gunpic = view.findViewById(R.id.pic_above_table);
        gunpic.setImageResource(R.drawable.snipe_semiauto);                //sets the sg_pump as the picture

        TableLayout statTable = view.findViewById(R.id.stat_table);


        ImageView plusputton = view.findViewById(R.id.plusbutton);

        if(     ((ViewGroup)getView().getParent()).getId() == R.id.Gun1_Frame  ||
                ((ViewGroup)getView().getParent()).getId() == R.id.Gun2_Frame){
            plusputton.setVisibility(View.VISIBLE);
        }else{
            plusputton.setVisibility(View.INVISIBLE);
        }

        TextView gunlabel = view.findViewById(R.id.Gun_name);
        gunlabel.setText("Semi-Auto Sniper");

        TableEditor editor = new TableEditor(statTable,getContext());  // made this object to make data easy to edit
        //Grey: Common, Green: Uncommon, Blue: Rare, Purple: Epic, Orange: Legendary
        String[] textInColumn = {
                "E",      // title for column
                "63",      //Damage
                "157.5",      //Headshot damage
                "1.2",      //Fire Rate
                "2.5",      //Reload Time
                "75.6",      //DPS
                "10",      //Mag Size

        };
        editor.add_column(textInColumn,R.color.weapon_purple);

        textInColumn[0]="L";      // title for column
        textInColumn[1]="66";     //Damage
        textInColumn[2]="165";     //Headshot damage
        textInColumn[3]="1.2";     //Fire Rate
        textInColumn[4]="2.3";      //Reload Time
        textInColumn[5]="79.2";     //DPS
        textInColumn[6]="10";      //Mag Size
        editor.add_column(textInColumn,R.color.weapon_gold);


        super.onViewCreated(view, savedInstanceState);
    }
}
