import java.awt.*;
import javax.swing.*;

/**
 *  This program displays a red cross on a white
 *  background.
 */

public class RedCross extends JPanel
{
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method
                              //   to paint the background
    int xCenter = getWidth() / 2;
    int yCenter = getHeight() / 2;
    g.setColor(Color.RED);
    g.fillRect(xCenter, yCenter/2, 10, 100);
    g.fillRect(xCenter/2, yCenter, 100, 10);
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Red Cross");
    window.setBounds(300, 300, 200, 200);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    RedCross panel = new RedCross();
    panel.setBackground(Color.WHITE);
    Container c = window.getContentPane();
    c.add(panel);
    window.setVisible(true);
  }
}