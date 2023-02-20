import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class WalkerTest extends JPanel
{
    private Image leftShoe;
    private Image rightShoe;

    private Image leftSandal;
    private Image rightSandal;

  // Constructor
  public WalkerTest()
  {
    leftShoe = (new ImageIcon("leftshoe.gif")).getImage();
    rightShoe = (new ImageIcon("rightshoe.gif")).getImage();

    leftSandal = (new ImageIcon("leftsandal.gif")).getImage();
    rightSandal = (new ImageIcon("rightsandal.gif")).getImage();
  }

  // Called automatically when the panel needs repainting
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    int x = 100;
    int y = 100;

    Walker shoeWalker = new Walker(x, y, leftShoe, rightShoe);
    Walker sandalWalker = new Walker(x, y+200, leftSandal, rightSandal);

    //7 Part A

    for(int i=0;i<=6;i++){
        shoeWalker.draw(g);
        shoeWalker.nextStep();
      }

    //7 Part B

    for(int i=0;i<=2;i++){
        sandalWalker.draw(g);
        sandalWalker.nextStep();
      }

      sandalWalker.nextStep();
      sandalWalker.nextStep();
      sandalWalker.nextStep();
      sandalWalker.draw(g);

  }

  public static void main(String[] args)
  {
    
    JFrame window = new JFrame("Walker");
    window.setBounds(100, 100, 500, 480);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    WalkerTest panel = new WalkerTest();
    panel.setBackground(Color.WHITE);
    Container c = window.getContentPane();
    c.add(panel);
    
    window.setVisible(true);
  }
}