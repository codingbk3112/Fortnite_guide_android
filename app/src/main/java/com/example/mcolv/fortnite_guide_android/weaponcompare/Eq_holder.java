package com.example.mcolv.fortnite_guide_android.weaponcompare;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.mcolv.fortnite_guide_android.Equipment.Eq;
import com.example.mcolv.fortnite_guide_android.R;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class Eq_holder extends Fragment {


    public Eq_holder() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eq_holder, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Fragment addition = new Eq();

        Random randint = new Random();
        int container_id = randint.nextInt(70000000);

        FrameLayout container = view.findViewById(R.id.child_holder);
        container.setId(container_id);

        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(container_id,addition);
        fragmentTransaction.commit();



    }
}
