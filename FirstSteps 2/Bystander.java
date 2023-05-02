import java.awt.Image;

public class Bystander extends Walker {

    public static final int PIXELS_PER_INCH = 6;
    private int stepsCount;

    public Bystander(int x, int y, Image leftPic, Image rightPic)
  {
    super(x, y, leftPic, rightPic);
  }  

  // Makes first step, starting with the left foot
  public void firstStep()
  {
    Foot leftFoot = getLeftFoot();
    leftFoot.turn(45);
    stepsCount = 1;
  }

  // Makes next step
  public void nextStep()
  {
    Foot leftFoot = getLeftFoot();
    if (stepsCount % 2 == 0) { // if stepsCount is even
    leftFoot.turn(45);
    stepsCount++;
    }
    else  {
      leftFoot.turn(-45);
      stepsCount++;
      // increment by 1
    }
  }

  // Stops this walker (brings its feet together)
  public void stop()
  {
    Foot leftFoot = getLeftFoot();
    if (stepsCount % 2 == 0) { // if stepsCount is even
      }
      else  {
        leftFoot.turn(-45);
        stepsCount++;
      }
        // increment by 1
  }

  // Returns the distance walked
  public int distanceTraveled()
  {
    return 0;
  }
    
}
