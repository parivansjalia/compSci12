import java.awt.Image;

public class circle extends Walker{

    private int stepsCount = 0;

    public circle (int x, int y, Image leftPic, Image rightPic) {
        super (x, y, leftPic, rightPic);
    }

    //Make first step starting with left foot

    public void firstStep() {
        Foot leftFoot = getLeftFoot();

        leftFoot.turn(60);
        leftFoot.moveForward(80);
        leftFoot.moveSideways(-50);

        stepsCount++;

    }

    //Continue making steps 

    public void nextStep() {
        Foot leftFoot = getLeftFoot();
        Foot rightFoot = getLeftFoot();
        
        if (stepsCount % 2 == 0) {
            rightFoot.turn(120);
            rightFoot.moveForward(160);
            rightFoot.moveSideways(-100);
        }

        else {
            leftFoot.turn(120);
            leftFoot.moveForward(160);
            leftFoot.moveSideways(-100);
        }
    }

    //Stop

    public void stop(){

    }

    // //returns distance travelled 
    // public int distanceTraveled() {
    //     return stepsCount;
    // }

}
