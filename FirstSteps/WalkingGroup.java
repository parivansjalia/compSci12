import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WalkingGroup implements StudentGroup
{
  private Walker amy;
  private Walker ben;
  private circle cat;
  private Image leftWomansShoe, rightWomansShoe;
  private Image leftMansShoe, rightMansShoe;
  private Image leftFoot, rightFoot;

  private DanceFloor danceFloor;

  private enum State {READY, MOVING, STOPPED}
  private State currentState;
  private int stepsCount;

  // Constructor
  public WalkingGroup(DanceFloor df)
  {
    danceFloor = df;
    leftWomansShoe = (new ImageIcon("leftsandal.gif")).getImage();
    rightWomansShoe = (new ImageIcon("rightsandal.gif")).getImage();
    leftMansShoe = (new ImageIcon("leftshoe.gif")).getImage();
    rightMansShoe = (new ImageIcon("rightshoe.gif")).getImage();
    leftFoot = (new ImageIcon("leftshoe.gif")).getImage();
    rightFoot = (new ImageIcon("rightshoe.gif")).getImage();
  }

  // Sets up this group of participants
  public void setup(int floorDir, Dance steps1, Dance steps2)
  {
    int width = danceFloor.getWidth();
    int height = danceFloor.getHeight();
    int x = width / 10;
    int y = height / 2;

    if (floorDir == 0)
    {
      amy = new Walker(x, y - height / 5, leftWomansShoe, rightWomansShoe);
      ben = new Walker(x, y + height / 5, leftMansShoe, rightMansShoe);
      cat = new circle(x, y, leftFoot, rightFoot);
    }
    else
    {
      amy = new Walker(x, y + height / 5, leftWomansShoe, rightWomansShoe);
      ben = new Walker(x, y - height / 5, leftMansShoe, rightMansShoe);
      cat = new circle(x, y, leftFoot, rightFoot);
    }
    currentState = State.READY;
    danceFloor.update(this);
  }

  // Moves the group by one step
  public void makeNextStep()
  {
    if (currentState == State.READY)
    {
      amy.firstStep();
      ben.firstStep();
      cat.firstStep();
      currentState = State.MOVING;
      stepsCount = 0;
    }
    else if (currentState == State.MOVING)
    {
      if (amy.distanceTraveled() <= danceFloor.getWidth() * 3 / 4)
      {
        amy.nextStep();
        ben.nextStep();
        cat.nextStep();
        stepsCount++;
      }
      else
      {
        amy.stop();
        ben.stop();
        cat.stop();
        currentState = State.STOPPED;
      }
    }

    danceFloor.update(this);
  }

  // Draws this group
  public void draw(Graphics g)
  {
    amy.draw(g);
    ben.draw(g);
    cat.draw(g);
  }
}

