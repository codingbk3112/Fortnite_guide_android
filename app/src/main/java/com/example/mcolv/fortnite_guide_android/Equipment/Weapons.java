package com.example.mcolv.fortnite_guide_android.Equipment;

public class Weapons {

    //Constructor:

    Weapons(double Damage, double head_shot, double firerate, double reload, double mag) {
        damage = Damage;
        head_shot_damage = head_shot;
        fire_rate = firerate;
        reload_time = reload;
        mag_size = mag;
    }

    //Member variables:

    private double damage;              //damage stat
    private double head_shot_damage;    //headshot damage stat
    private double fire_rate;           //fire rate stat
    private double reload_time;         //reload time stat
    private double mag_size;            //mag size stat

    //Accessor functions:

    public double getDamage() {
        return damage;
    }

    public double getHead_shot_damage() {
        return head_shot_damage;
    }

    public double getFire_rate() {
        return fire_rate;
    }

    public double getReload_time() {
        return reload_time;
    }

    public double getMag_size() {
        return mag_size;
    }

    public double getDPS(){
        return damage*fire_rate;
    }



}
