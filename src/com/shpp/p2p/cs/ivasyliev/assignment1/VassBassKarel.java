package com.shpp.p2p.cs.ivasyliev.assignment1;

import com.shpp.karel.KarelTheRobot;

public class VassBassKarel extends KarelTheRobot {

    public void turnRight() throws Exception {
        for (int step = 0; step < 3; step++) turnLeft();
    }

    public void turnAround() throws Exception {
        for (int step = 0; step < 2; step++) turnLeft();
    }

    public void turnToEast() throws Exception {
        while (!facingEast()) turnLeft();
    }

    public void turnToWest() throws Exception {
        while (!facingWest()) turnLeft();
    }

    public void turnToSouth() throws Exception {
        while (!facingSouth()) turnLeft();
    }

    public void turnToNorth() throws Exception {
        while (!facingNorth()) turnLeft();
    }
}
