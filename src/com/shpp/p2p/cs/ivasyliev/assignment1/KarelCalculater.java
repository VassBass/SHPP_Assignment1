package com.shpp.p2p.cs.ivasyliev.assignment1;

public class KarelCalculater extends VassBassKarel {

    private int numberOfSteps = 0;

    @Override
    public void __shutDown() throws Exception {
        super.__shutDown();
        System.err.printf("NUMBER OF STEPS : %s", numberOfSteps);
        numberOfSteps = 0;
    }

    @Override
    public void turnRight() throws Exception {
        super.turnRight();
        numberOfSteps++;
    }

    @Override
    public void turnAround() throws Exception {
        super.turnAround();
        numberOfSteps++;
    }

    @Override
    public void turnToEast() throws Exception {
        super.turnToEast();
        numberOfSteps++;
    }

    @Override
    public void turnToWest() throws Exception {
        super.turnToWest();
        numberOfSteps++;
    }

    @Override
    public void turnToSouth() throws Exception {
        super.turnToSouth();
        numberOfSteps++;
    }

    @Override
    public void turnToNorth() throws Exception {
        super.turnToNorth();
        numberOfSteps++;
    }

    @Override
    public void say(String something_inside_quotes) throws Exception {
        super.say(something_inside_quotes);
        numberOfSteps++;
    }

    @Override
    public void move() throws Exception {
        super.move();
        numberOfSteps++;
    }

    @Override
    public void putBeeper() throws Exception {
        super.putBeeper();
        numberOfSteps++;
    }

    @Override
    public void pickBeeper() throws Exception {
        super.pickBeeper();
        numberOfSteps++;
    }

    @Override
    public void turnLeft() throws Exception {
        super.turnLeft();
        numberOfSteps++;
    }

    @Override
    public boolean frontIsClear() throws Exception {
        numberOfSteps++;
        return super.frontIsClear();
    }

    @Override
    public boolean frontIsBlocked() throws Exception {
        numberOfSteps++;
        return super.frontIsBlocked();
    }

    @Override
    public boolean leftIsClear() throws Exception {
        numberOfSteps++;
        return super.leftIsClear();
    }

    @Override
    public boolean leftIsBlocked() throws Exception {
        numberOfSteps++;
        return super.leftIsBlocked();
    }

    @Override
    public boolean rightIsClear() throws Exception {
        numberOfSteps++;
        return super.rightIsClear();
    }

    @Override
    public boolean rightIsBlocked() throws Exception {
        numberOfSteps++;
        return super.rightIsBlocked();
    }

    @Override
    public boolean beepersPresent() throws Exception {
        numberOfSteps++;
        return super.beepersPresent();
    }

    @Override
    public boolean noBeepersPresent() throws Exception {
        numberOfSteps++;
        return super.noBeepersPresent();
    }

    @Override
    public boolean beepersInBag() throws Exception {
        numberOfSteps++;
        return super.beepersInBag();
    }

    @Override
    public boolean noBeepersInBag() throws Exception {
        numberOfSteps++;
        return super.noBeepersInBag();
    }

    @Override
    public boolean facingNorth() throws Exception {
        numberOfSteps++;
        return super.facingNorth();
    }

    @Override
    public boolean notFacingNorth() throws Exception {
        numberOfSteps++;
        return super.notFacingNorth();
    }

    @Override
    public boolean facingEast() throws Exception {
        numberOfSteps++;
        return super.facingEast();
    }

    @Override
    public boolean notFacingEast() throws Exception {
        numberOfSteps++;
        return super.notFacingEast();
    }

    @Override
    public boolean facingSouth() throws Exception {
        numberOfSteps++;
        return super.facingSouth();
    }

    @Override
    public boolean notFacingSouth() throws Exception {
        numberOfSteps++;
        return super.notFacingSouth();
    }

    @Override
    public boolean facingWest() throws Exception {
        numberOfSteps++;
        return super.facingWest();
    }

    @Override
    public boolean notFacingWest() throws Exception {
        numberOfSteps++;
        return super.notFacingWest();
    }
}
