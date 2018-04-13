package com.example.mcolv.fortnite_guide_android;


import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


import static android.content.Context.VIBRATOR_SERVICE;


public class Equipment extends Fragment implements View.OnClickListener{
    final Context context = super.getContext();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.equipment_fragment,container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
     super.onViewCreated(view, savedInstanceState);

        ImageButton assaultrifle_Button = view.findViewById(R.id.assaultrifle_Button);
        ImageButton shotgun_Button = view.findViewById(R.id.shotgun_Button);
        ImageButton explosive_Button = view.findViewById(R.id.explosives_Button);
        ImageButton sniper_Button = view.findViewById(R.id.sniper_Button);
        ImageButton bandages_Button = view.findViewById(R.id.bandages_Button);
        ImageButton utilities_Button = view.findViewById(R.id.utilities_Button);
        ImageButton pistol_Button = view.findViewById(R.id.pistol_Button);

        assaultrifle_Button.setOnClickListener(this);
        shotgun_Button.setOnClickListener(this);
        explosive_Button.setOnClickListener(this);
        sniper_Button.setOnClickListener(this);
        bandages_Button.setOnClickListener(this);
        utilities_Button.setOnClickListener(this);
        pistol_Button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        final Vibrator buttonvibe = (Vibrator) super.getContext().getSystemService(VIBRATOR_SERVICE);
        buttonvibe.vibrate(50);

        switch(v.getId()){

            case R.id.assaultrifle_Button:

                break;
            case R.id.shotgun_Button:

                break;
            case R.id.explosives_Button:

                break;
            case R.id.sniper_Button:

                break;
            case R.id.bandages_Button:

                break;
            case R.id.utilities_Button:

                break;
            case R.id.pistol_Button:

                break;



        }


    }


}
