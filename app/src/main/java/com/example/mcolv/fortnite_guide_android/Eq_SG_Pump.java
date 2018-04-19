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
        gunpic.setImageResource(R.drawable.shotgun);                //sets the shotgun as the picture

        TableLayout statTable = view.findViewById(R.id.stat_table);
        TableEditor editor = new TableEditor(statTable,getContext());

        String[] textInColumn = {
                "UC",      // title for column
                "111",      //Damage
                "222",      //Headshot damage
                "333",      //Fire Rate
                "444",      //Reload Time
                "555",      //DPS
                "777",      //Mag Size

        };

        editor.add_column(textInColumn,R.color.weapon_blue);


        super.onViewCreated(view, savedInstanceState);
    }
}
