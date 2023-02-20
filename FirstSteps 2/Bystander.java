import java.awt.Image;

public class Bystander extends Walker {

    public static final int PIXELS_PER_INCH = 6;
  private Foot leftFoot, rightFoot;
  private int stepLength;
  private int stepsCount;

    public Bystander(int x, int y, Image leftPic, Image rightPic)
  {
    super(x, y, leftPic, rightPic);
    leftFoot =  new Foot(x, y - PIXELS_PER_INCH * 4, leftPic);
    rightFoot = new Foot(x, y + PIXELS_PER_INCH * 4, rightPic);
    stepLength = PIXELS_PER_INCH * 12;
  }  
  // Makes first step, starting with the left foot
  public void firstStep()
  {
    leftFoot.moveForward(stepLength);
    stepsCount = 1;
  }

  // Makes next step
  public void nextStep()
  {
    if (stepsCount % 2 == 0)  // if stepsCount is even
      leftFoot.turn(45);
      
    else  
      rightFoot.turn(-45);

    stepsCount++;  // increment by 1
  }

  // Stops this walker (brings its feet together)
  public void stop()
  {
    
  }

  // Returns the distance walked
  public int distanceTraveled()
  {
    return 0;
  }
    
}
