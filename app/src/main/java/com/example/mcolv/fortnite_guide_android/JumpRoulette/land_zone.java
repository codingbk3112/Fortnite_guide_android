package com.example.mcolv.fortnite_guide_android.JumpRoulette;

public class land_zone {
    private int x;//rand x for map landing
    private int y;//rand y for map landing
    private String title;

    land_zone(int xx, int yy, String title) { //constructor
        title = title;
        x = xx;
        y = yy;
    }

    public int get_x() {
        return x;
    }

    public int get_y() {
        return y;
    }

    public String get_title() {
        return title;
    }

    public void set(int xx, int yy, String titlee) {
        x = xx;
        y = yy;
        title = titlee;
    }

}

