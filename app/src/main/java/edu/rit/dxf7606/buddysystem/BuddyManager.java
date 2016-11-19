package edu.rit.dxf7606.buddysystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dylan Forrest on 10/9/2016.
 */
public class BuddyManager {
    private BuddyManager(){}
    List<Buddy> buddyList = new ArrayList<>() ;
    private static int indexer = 0 ;
    protected Phone phone = new Phone() ;

    private static class BuddyManagerAux {
        private static final BuddyManager buddyManager = new BuddyManager();
    }

    public static BuddyManager BuddyManager() {
        return BuddyManagerAux.buddyManager ;
    }

    protected void addBuddy( String name, String phoneNumber ) {
        Buddy newBuddy = new Buddy(name, phoneNumber, indexer);
        buddyList.add(indexer, newBuddy);
        indexer++;
    }

    protected void buddyAlert( Buddy buddy ) {
        buddy.alertStatus = true;
        phone.FlashScreen();
        phone.SoundAlarm();
        phone.Vibrate();
    }
}
