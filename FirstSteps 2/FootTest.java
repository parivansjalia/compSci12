import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class FootTest extends JPanel
{
  private Image shoe;

  // Constructor
  public FootTest()
  {
    shoe = (new ImageIcon("leftshoe.gif")).getImage();
  }

  // Called automatically when the panel needs repainting
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    int x = 300;
    int y = 100;
    int stepLength = 100;

    Foot foot = new Foot(x, y, shoe);

    //6 Part A

    foot.turn(-90);

    for(int i=0; i<4;i++){
      foot.draw(g);
      foot.moveSideways(stepLength);
    }

    //6 Part B

    foot.turn(-90);
    foot.moveForward(100);
    foot.moveSideways(-stepLength);

    for(int i=0; i<4;i++){
      foot.draw(g);
      foot.moveForward(stepLength);
      
    }

    //6 Part C

    foot.turn(180);
    foot.moveForward(100);
    foot.moveSideways(stepLength);

    for(int i=0; i<4;i++){
      foot.moveSideways(50);
      foot.turn(90);
      foot.draw(g);
      foot.moveForward(50);
      
    }

    // Draw a cursor at the expected center of the first "shoe":
    g.drawLine(x - 50, y, x + 50, y);
    g.drawLine(x, y - 50, x, y + 50);
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Feet");
    window.setBounds(100, 100, 500, 480);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    FootTest panel = new FootTest();
    panel.setBackground(Color.WHITE);
    Container c = window.getContentPane();
    c.add(panel);

    window.setVisible(true);
  }
}