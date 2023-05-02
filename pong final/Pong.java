/*
 * This code is protected under the Gnu General Public License (Copyleft), 2005 by
 * IBM and the Computer Science Teachers of America organization. It may be freely
 * modified and redistributed under educational fair use.
 */

import csta.ibm.pong.Game;
import javax.swing.Timer;
//imports for sounds + file detecting 
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

//imports for JLabel
import javax.swing.JLabel;
import java.awt.Color;

//for pane instructions
import javax.swing.JOptionPane;

public class Pong extends Game {
	// Add any state variables or object references here

	// initlize private feilds for game (ball, paddles, JLabels)
	private Ball ball;
	private Paddle paddle1;
	private Paddle paddle2;
	private Obstacle obstacle1;
	private Obstacle obstacle2;
	private PowerUps powerUp;
	private JLabel winnerLabel;
	private JLabel scoreboard;
	private JLabel levelLabel;

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
		scoreboard.setLocation((getFieldWidth() / 2 - scoreboard.getWidth()) / 2, 10);

		scoreboard.setSize(200, 20);
		add(scoreboard);
		scoreboard.setText("Player 1: " + playerOneScore + "  ||  Player 2: " + playerTwoScore);

		// JLabel to show level + adding it to the screen
		levelLabel = new JLabel();
		levelLabel.setForeground(Color.WHITE);
		levelLabel.setLocation(((getFieldWidth() / 2) - 30), getFieldHeight() - 30);
		levelLabel.setSize(200, 20);
		add(levelLabel);
		levelLabel.setText("Level ONE!");

		// creates the ball object and sets it's size and location
		ball = new Ball();
		ball.setSize(10, 10);
		ball.setX(getFieldHeight() / 2);
		ball.setY(getFieldHeight() / 2);
		add(ball);

		// creates the paddle ONE (player one) and sets it's size and location
		paddle1 = new Paddle();
		paddle1.setSize(10, 70);
		paddle1.setY(getFieldHeight() / 2 - (paddle1.getWidth() / 2));
		paddle1.setX(0);
		add(paddle1);

		// creates the paddle TWO (player two) and sets it's size and location
		paddle2 = new Paddle();
		paddle2.setSize(10, 70);
		paddle2.setY(getFieldHeight() / 2 - (paddle2.getWidth() / 2));
		paddle2.setX(getFieldWidth() - paddle2.getWidth());
		add(paddle2);

		// creates the obstacle for the left side and sets it's size and location
		obstacle1 = new Obstacle();
		obstacle1.setSize(10, 40);
		obstacle1.setY(getFieldHeight() / 2);
		obstacle1.setX(getFieldWidth() / 4);

		// creates the obstacle for the right side and sets it's size and location
		obstacle2 = new Obstacle();
		obstacle2.setSize(10, 40);
		obstacle2.setY(getFieldHeight() / 2);
		obstacle2.setX(getFieldWidth() - (getFieldWidth() / 4));

		// creates the powerUP
		powerUp = new PowerUps();
		powerUp.setSize(10, 10);
		powerUp.setColor(Color.PINK);

		showInstructions();

	}

	/**
	 * Fill in this method with code that tells the playing field what to do
	 * from one moment to the next (paddle will continusly )
	 */
	public void act() {

		if (ball.collides(paddle1)) {
			if (ball.getDx() < 0) {
				ball.bounceX();
				bounceSound(); // too big of a file for my macbook (between 10-100 KB, should work on school
								// comptuers)
			}

		}
		if (ball.collides(paddle2)) {
			if (ball.getDx() > 0) {
				ball.bounceX();
				bounceSound();// too big of a file for my macbook (between 10-100 KB, should work on school
				// comptuers)
			}

		}

		// if ball hits top or bottom wall
		if (ball.getY() < 0 || ball.getY() > getFieldHeight() - ball.getHeight()) {
			ball.bounceY(); // reverse the vertical direction when it hits the top or bottom of the screen
			bounceSound(); // too big of a file for my macbook (between 10-100 KB, should work on school
							// comptuers)
		}

		// if paddle hits powerUp
		if (paddle1.collides(powerUp)) {
			powerUp.hits(paddle1);
			powerUp.setX(getFieldWidth() / 2 - (powerUp.getWidth() / 2));
			powerUp.setY(getFieldHeight() - powerUp.getHeight());
			// too big of a file for my macbook (between 10-100 KB, should work on school
			// comptuers)
		}
		// if paddle hits powerUp
		if (paddle2.collides(powerUp)) {
			powerUp.hits(paddle2);
			powerUp.setX(getFieldWidth() / 2 - (powerUp.getWidth() / 2));
			powerUp.setY(getFieldHeight() - powerUp.getHeight());
			// too big of a file for my macbook (between 10-100 KB, should work on school
			// comptuers)
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
	 * sets next level depending on points
	 */

	public void restartGame() {

		paddle1.setY(getFieldHeight() / 2 - (paddle1.getWidth() / 2));
		paddle1.setX(0);

		paddle2.setY(getFieldHeight() / 2 - (paddle2.getWidth() / 2));
		paddle2.setX(getFieldWidth() - paddle2.getWidth());

		ball.setX(getFieldHeight() / 2);
		ball.setY(getFieldHeight() / 2);

		winnerLabel.setText("");

		// code to add power up to screen and using math.random to decide where it will
		// be located

		int powerUpLocation = (int) (Math.random() * 3 + 1);

		if (powerUpLocation == 1) {
			powerUp.setY(getFieldHeight() / 2 - (powerUp.getWidth() * 5));
			powerUp.setX(0);
			add(powerUp);
		} else if (powerUpLocation == 2) {
			powerUp.setY(getFieldHeight() / 2 - (powerUp.getWidth() * 5));
			powerUp.setX(getFieldWidth());
			add(powerUp);
		} else {
			powerUp.setX(getFieldWidth() / 2 - (powerUp.getWidth() / 2));
			powerUp.setY(getFieldHeight() - powerUp.getHeight());
			add(powerUp);
		}

		// level two
		if (playerOneScore + playerTwoScore > 4) {
			setDelay(6);
			ball.setColor(Color.ORANGE);

			paddle1.setY(getFieldHeight() / 2 - (paddle2.getWidth() / 2));
			paddle2.setY(getFieldHeight() / 2 - (paddle2.getWidth() / 2));

			levelLabel.setText("Level TWO!");

		}

		// level 3

		if (playerOneScore + playerTwoScore > 9) {

			// general settings
			setDelay(5);
			ball.setColor(Color.RED);

			paddle1.setSize(10, 35);
			paddle2.setSize(10, 35);

			paddle1.setY(getFieldHeight() / 2 - 30);
			paddle2.setY(getFieldHeight() / 2 - 30);

			levelLabel.setText("Level THREE!");

			// obstacle

			add(obstacle1);
			add(obstacle2);

		}
	}

	/**
	 * Used to create a sound file
	 */
	public static void playSound(String fileName)
			throws MalformedURLException, LineUnavailableException, UnsupportedAudioFileException, IOException {
		File url = new File(fileName);
		Clip clip = AudioSystem.getClip();
		AudioInputStream ais = AudioSystem.getAudioInputStream(url);
		clip.open(ais);
		clip.start();
	}

	/**
	 * Method to play sound effect
	 */
	public static void bounceSound() {
		try {
			playSound("bounce.wav");
		} catch (LineUnavailableException | UnsupportedAudioFileException
				| IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method to shower intital instructions, called again in the setUp method. It
	 * is made upsing JOptionPane
	 */

	public void showInstructions() {

		String message = "<html><head><title>Pong Instructions</title>" +
				"<style>" +
				"h1 { color: #be0467; }" +
				"p { font-size: 10px; }" +
				"ul { list-style-type: circle; }" +
				"</style>" +
				"</head><body>" +
				"<h1>HEY PLAYERS, WELCOME TO PONG!</h1>" +
				"<p>You need two players to play the game. Player one will use the M (down) and N (up) keys to control their paddles and player two will use the Z (up) and X (down) keys.</p>"
				+
				"<p>Use the paddles to bounce the ball, if it hits the right or left wall the game will restart and the player who touched the ball last will win a point.</p>"
				+
				"<p>Once you reach 5 points, level two will begin, and once you reach 10 points, level 3 will begin. I won't spill the details now, get ready for the surprises and GOOD LUCK!</p>"
				+
				"<h2>Tips and Tricks</h2>" +
				"<ul>" +
				"<li>Try to keep your paddle in the center of the court to maximize your chances of hitting the ball.</li>"
				+
				"<li>Don't be too aggressive - sometimes it's better to let the ball pass by and wait for a better opportunity to strike.</li>"
				+
				"<li>Communicate with your partner if you're playing doubles - coordination can be the key to victory!</li>"
				+
				"</ul>" +
				"</body></html>";
		JOptionPane.showMessageDialog(null, message, "Pong Instructions", JOptionPane.PLAIN_MESSAGE, null);

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