/*
 * This code is protected under the Gnu General Public License (Copyleft), 2005 by
 * IBM and the Computer Science Teachers of America organization. It may be freely
 * modified and redistributed under educational fair use.
 */

/*
* Pari Vansjalia
* April 13th, 2023
* Pong Assignment (Milestone)
* Grade 12 Computer Science: Mr. Benum 
*/

import csta.ibm.pong.Game;
import javax.swing.Timer; //import to delay game after one player loses

//JLabel imports 
import javax.swing.JLabel;
import java.awt.Color;

public class Pong extends Game {
	// Add any state variables or object references here

	// initlize private feilds for game (ball, paddles, JLabels)
	private Ball ball;
	private Paddle paddle1;
	private Paddle paddle2;
	private JLabel winnerLabel;
	private JLabel scoreboard;

	private int playerOneScore = 0; // player one points
	private int playerTwoScore = 0; // player two points
	private int delay = 2000; // delay in how fast the game starts after a player wins

	/**
	 * Fill in this method with code that tells the game what to do
	 * before actual play begins
	 */
	public void setup() {
		// make game slower
		setDelay(10);

		// JLabel to show winner + adding it to the screen. It will only show something
		// when a player wins
		winnerLabel = new JLabel();
		winnerLabel.setForeground(Color.WHITE);
		winnerLabel.setHorizontalAlignment(JLabel.CENTER);
		add(winnerLabel);
		setComponentZOrder(winnerLabel, 0);

		// JLabel to show score + adding it to the screen
		scoreboard = new JLabel();
		scoreboard.setForeground(Color.WHITE);
		scoreboard.setLocation(10, 10);
		scoreboard.setSize(200, 20);
		add(scoreboard);
		scoreboard.setText("Player 1: " + playerOneScore + "  ||  Player 2: " + playerTwoScore);

		// creates the ball object and sets it's size and location
		ball = new Ball();
		ball.setSize(10, 10);
		ball.setX(getFieldHeight() / 2);
		ball.setY(getFieldHeight() / 2);
		add(ball);

		// creates the paddle ONE (player one) and sets it's size and location
		paddle1 = new Paddle();
		paddle1.setSize(10, 50);
		paddle1.setY(getFieldHeight() / 2 - (paddle1.getHeight() / 2));
		paddle1.setX(0);
		add(paddle1);

		// creates the paddle TWO (player two) and sets it's size and location
		paddle2 = new Paddle();
		paddle2.setSize(10, 50);
		paddle2.setY(getFieldHeight() / 2 - (paddle2.getHeight() / 2));
		paddle2.setX(getFieldWidth() - paddle2.getWidth());
		add(paddle2);

	}

	/**
	 * Fill in this method with code that tells the playing field what to do
	 * from one moment to the next (paddle will continusly )
	 */
	public void act() {

		// ball collides with paddle bounce
		if (ball.collides(paddle1)) {
			ball.bounceX();

		}
		if (ball.collides(paddle2)) {
			ball.bounceX();

		}
		if (ball.getY() <= ball.getHeight() || ball.getY() > getFieldHeight() - ball.getHeight()) {
			ball.bounceY(); // reverse the vertical direction when it hits the top or bottom of the screen
		}

		// if keys pressed, move paddle ONE up and down
		if (ZKeyPressed() && paddle1.getY() > 0) {
			paddle1.moveUp();
		}
		if (XKeyPressed() && paddle1.getY() < getFieldHeight() - paddle1.getHeight()) {
			paddle1.moveDown();
		}

		// if keys pressed, move paddle TWO up and down
		if (NKeyPressed() && paddle2.getY() > 0) {
			paddle2.moveUp();
		}
		if (MKeyPressed() && paddle2.getY() < getFieldHeight() - paddle2.getHeight()) {
			paddle2.moveDown();
		}

		// if ball hits RIGHT wall (player ONE wins)
		if (ball.getX() == getFieldWidth() - ball.getWidth()) {
			playerOneWins();
		}

		// if ball hits LEFT wall (player TWO wins)
		if (ball.getX() == 0) {
			playerTwoWins();
		}
	}

	// Add any additional methods here

	/**
	 * prints that player one has won after a delay of x seconds
	 * increments player one score by one
	 * (resets game)
	 */

	public void playerOneWins() {
		// Display the winner label with text
		winnerLabel.setText("Player 1 wins!");
		playerOneScore++;
		// Restart the game after a delay of 2 seconds
		Timer timer = new Timer(delay, e -> restartGame());
		timer.setRepeats(false);
		timer.start();
		scoreboard.setText("Player 1: " + playerOneScore + "  ||  Player 2: " + playerTwoScore);
	}

	/**
	 * prints that player two has won after a delay of x seconds
	 * increments player two score by one
	 * (resets game)
	 */

	public void playerTwoWins() {
		winnerLabel.setText("Player 2 wins!");
		playerTwoScore++;
		// Restart the game after a delay of 2 seconds
		Timer timer = new Timer(delay, e -> restartGame());
		timer.setRepeats(false);
		timer.start();
		scoreboard.setText("Player 1: " + playerOneScore + "  ||  Player 2: " + playerTwoScore);
	}

	/**
	 * (resets game)
	 * put balls and paddles back to their original spot
	 * resets the winnerLabel text to nothing
	 */

	public void restartGame() {

		paddle1.setY(getFieldHeight() / 2 - (paddle1.getWidth() / 2));
		paddle1.setX(0);

		paddle2.setY(getFieldHeight() / 2 - (paddle2.getWidth() / 2));
		paddle2.setX(getFieldWidth() - paddle2.getWidth());

		ball.setX(getFieldHeight() / 2);
		ball.setY(getFieldHeight() / 2);

		winnerLabel.setText("");
	}

	/**
	 * This code has been provided for you, and should not be modified
	 */
	public static void main(String[] args) {
		Pong p = new Pong();
		p.setVisible(true);
		p.initComponents();

	}
}