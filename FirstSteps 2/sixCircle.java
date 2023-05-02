//import statement to access Image class in java.awt

import java.awt.Image;

//class header

public class sixCircle extends Walker{

    private int stepsCount = 0;

    //constructor that calls the Walker constructor using the keyword super
    public sixCircle(int x, int y, Image leftPic, Image rightPic) {
        super(x, y, leftPic, rightPic);
    }

    Foot leftFoot = getLeftFoot();
    Foot rightFoot = getRightFoot();
    //method to make the first step
    public void firstStep () {
        leftFoot.moveForward(100);
        stepsCount++;
    }

    public void nextStep () {
        if (stepsCount%2 == 0) {
        leftFoot.turn(120);
        leftFoot.moveForward(160);
        leftFoot.moveSideways(-100);
        stepsCount++;
        }
        else {
            rightFoot.turn(60);
        rightFoot.moveForward(80);
        rightFoot.moveSideways(-50);}
        stepsCount++;

    }

}