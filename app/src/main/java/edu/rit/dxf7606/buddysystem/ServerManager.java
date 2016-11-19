package edu.rit.dxf7606.buddysystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Dylan Forrest on 10/9/2016.
 */
public class ServerManager {
    private static class ServerManagerAux {
        private static final ServerManager serverManager = new ServerManager();
    }

    public static ServerManager ServerManager() {
        return ServerManagerAux.serverManager ;
    }

    protected ArrayList<Coords> buddyLocations = new ArrayList<>();
    protected HashMap<String, Boolean> buddyAlertStatuses = new HashMap<>();

    protected List<Coords> getBuddyLocations(){
        return buddyLocations;
    }

    protected HashMap<String, Boolean> getBuddyAlertStatuses(){
        return buddyAlertStatuses;
    }

    protected void notifyBuddyManager() {
        for (int i = 0; i < buddyLocations.size(); i++) {
            BuddyManager.BuddyManager().buddyList.get(i).setLocation(buddyLocations.get(i));
        }
    }

    protected void notifyMapManager(){
        for (int i = 0; i < buddyLocations.size(); i++) {
            MapManager.mapManager().buddyLocations.set(i, buddyLocations.get(i));
        }
    }
}
