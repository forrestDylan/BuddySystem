package edu.rit.dxf7606.buddysystem;

import java.util.ArrayList;

/**
 * Created by Dylan Forrest on 10/9/2016.
 */
public class Server {
    private static class ServerAux {
        private static final Server server = new Server();
    }

    public static Server Server() {
        return ServerAux.server ;
    }
    Coords coord1 = new Coords(1.000, 1.000) ;
    Coords coord2 = new Coords(2.000, 2.000) ;
    Coords coord3 = new Coords(3.000, 3.000) ;
    Coords[] buddyLocations = new Coords[]{coord1, coord2, coord3};


}
