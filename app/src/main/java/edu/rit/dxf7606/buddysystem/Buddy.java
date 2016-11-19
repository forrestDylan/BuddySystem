package edu.rit.dxf7606.buddysystem;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Dylan Forrest on 10/9/2016.
 */
public class Buddy {
    String name;
    Coords location = new Coords(0, 0) ;
    boolean alertStatus = false ;
    int index;
    String phoneNumber;

    public Buddy(String name, String phoneNumber, int index){
        this.name = name ;
        this.phoneNumber = phoneNumber ;
        this.index = index ;
    }

    protected void setLocation(Coords coord){
        this.location = coord;
    }
}

class Coords {
    public double x;
    public double y;

    public Coords(double x, double y) {
        this.x = x ;
        this.y = y ;
    }

    protected double[] getCoord() {
        double coords[] = {x, y};
        return coords;
    }
}