package edu.rit.dxf7606.buddysystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dylan Forrest on 10/9/2016.
 */
public class Phone {
    private static class PhoneAux {
        private static final Phone phone = new Phone();
    }

    public static Phone Phone() {
        return PhoneAux.phone ;
    }
    void Vibrate(){}
    void FlashScreen(){}
    void SoundAlarm(){}
    Contact buddy1 = new Contact("Buddy One", "216-644-2047") ;
    Contact buddy2 = new Contact("Buddy Two", "585-585-5858") ;
    Contact buddy3 = new Contact("Buddy Three", "222-222-2222") ;
    List<Contact> chosenContacts = new ArrayList<>();

    protected Coords getUserCoords(){
        Coords coords = new Coords(0,0);
        return coords ;
    }
}
