import javax.swing.Timer;

import csta.ibm.pong.GameObject;

public class PowerUps extends GameObject {

    private int delay = 10000;

    /**
     * called every millisecond
     */
    public void act() {

    }

    /**
     * the powerup will increase the paddle size by 20 pixels once it hits it
     */
    public void hits(Paddle paddle) {
        paddle.setSize(10, paddle.getHeight() + 20);
        Timer timer = new Timer(delay, e -> restartPaddle(paddle));
        timer.setRepeats(false);
        timer.start();
    }

    /**
     * the powerup will be reset after 20 seconds and return the paddle to it's
     * original size
     */
    public void restartPaddle(Paddle paddle) {
        paddle.setSize(10, paddle.getHeight() - 20);
    }

}
