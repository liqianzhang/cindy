package com.packtpublishing.tddjava.ch04ship;

import java.util.HashMap;
import java.util.Map;

public class Ship {

    private static Location location = null;

    private static final Map<String, Boolean> strategies = new HashMap<>();

    private Planet planet;





    public Ship(Location location, Planet planet) {
        this.planet = planet;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public static void main(String[] args) {

    }


    public boolean moveForward() {
        //return location.forward();
        return location.forward(planet.getMax());
    }

    public boolean moveBackward() {
        return location.backward();
    }

    public void turnLeft() {
        location.turnLeft();
    }

    public void turnRight() {
        location.turnRight();
    }

    //趁这个机会，把策略模式搞一下
    public void receiveCommands(String commands) {
        for (char command : commands.toCharArray()) {
            if (command == 'f') {
                moveForward();
            } else if (command == 'b') {
                moveBackward();
            } else if (command == 'l') {
                turnLeft();
            } else if (command == 'r') {
                turnRight();
            }
        }
    }


    public Planet getPlanet() {
        return planet;
    }
}
