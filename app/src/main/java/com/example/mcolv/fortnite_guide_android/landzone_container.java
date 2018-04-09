package com.example.mcolv.fortnite_guide_android;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class landzone_container {

    public static ArrayList<land_zone> land_zones = new ArrayList<>();

    landzone_container(){
        load_zones();
    };



    public land_zone get_random_zone(){
        Random rand = new Random();

        return (land_zones.get(rand.nextInt(land_zones.size())));
    }

    private void load_zones(){
        land_zone tmp = new land_zone(1,1,"1");

        int x=0;
        int y=0;
        String zone_in_text;
        InputStream is = super.getClass().getResourceAsStream("/res/raw/jump_cordinates.txt");
        BufferedReader b_read;

        try {
            b_read= new BufferedReader(new InputStreamReader(is));


        while((zone_in_text=b_read.readLine()) != null){
                String[] words = zone_in_text.split(" "); //split at the space in file
                 //set the necessary jump zone
                land_zones.add(new land_zone(parseInt(words[0]),parseInt(words[1]),words[2]));
            }

        } catch (FileNotFoundException e) {
            Toast.makeText(null , "Resource file missing", Toast.LENGTH_SHORT).show();
        }
          catch (IOException e){
              Toast.makeText(null, "I hope this never happens", Toast.LENGTH_SHORT).show();
          }



    }
}
