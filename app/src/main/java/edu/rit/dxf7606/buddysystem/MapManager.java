package edu.rit.dxf7606.buddysystem;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

/**
 * Created by Dylan Forrest on 10/9/2016.
 */
public class MapManager {
    private static class MapManagerAux {
        private static final MapManager mapManager = new MapManager();
    }

    public static MapManager mapManager() {
        return MapManagerAux.mapManager ;
    }
    protected List<Coords> buddyLocations = ServerManager.ServerManager().getBuddyLocations();
    protected double alertRadius = SystemSettings.SystemSettings().chosenRadius ;

    protected void updateMapPositions(){}//Calls to map activity
    protected void updateMapScale(){}//Calls to map activity

    protected void updateLocations(){
        ServerManager.ServerManager().notifyMapManager();
    }

    protected void calculateDistances(){
        for (int i = 0; i < buddyLocations.size(); i++){
            Buddy alertBuddy = BuddyManager.BuddyManager().buddyList.get(0);
            double[] buddyLocation = buddyLocations.get(i).getCoord();
            double xDifference = buddyLocation[0] - Phone.Phone().getUserCoords().x ;
            double yDifference = buddyLocation[1] - Phone.Phone().getUserCoords().y ;
            double pythagoreanLeg = sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2)) ;
            for (int x = 0; x < BuddyManager.BuddyManager().buddyList.size(); i++){
                if (BuddyManager.BuddyManager().buddyList.get(x).index == i){
                    alertBuddy = BuddyManager.BuddyManager().buddyList.get(i) ;
                }
            }
            if (pythagoreanLeg > alertRadius){
                BuddyManager.BuddyManager().buddyAlert( alertBuddy );
            }
        }
    }

}
