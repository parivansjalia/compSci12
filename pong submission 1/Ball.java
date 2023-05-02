/*
 * This code is protected under the Gnu General Public License (Copyleft), 2005 by
 * IBM and the Computer Science Teachers of America organization. It may be freely
 * modified and redistributed under educational fair use.
 */

import csta.ibm.pong.GameObject;
import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject {
	// Add any state variables here
	private int dx = 1; // change in the x value of the ball
	private int dy = 1; // chane in the y value of the ball
	private Color c = Color.WHITE; // color of the ball

	/**
	 * Fill in this method with code that describes the behavior
	 * of a ball from one moment to the next
	 */
	public void act() {
		setX(getX() + dx);
		setY(getY() + dy);
		// System.out.println(dy);

	}

	// Add any additional methods here

	/**
	 * bounce method reflect the ball off in a rand ome angle
	 * this allows the ball to keep moving to different places on the field
	 * constraints include not moving off the field from the top of bottom
	 */

	public void bounce() {
		bounceX();
		bounceY();

	}

	/**
	 * bounce method changes the bounceX to it's negative
	 */
	public void bounceX() {
		dx = -dx;

	}

	/**
	 * bounce method changes the bounceY to it's negative
	 */
	public void bounceY() {
		dy = -dy;

	}

	/**
	 * collides method reflect the ball off in a rand ome angle
	 * this allows the ball to keep moving to different places on the field
	 * constraints include not moving off the field from the top of bottom
	 */
	public boolean collides(Ball o) {
		return getBounds().intersects(o.getBounds());
	}

	/**
	 * setter method for the dy value
	 */
	// public void setDy(int i) {
	// dy = i;
	// }

	/**
	 * setter method for the dx value
	 */
	public void setDx(int i) {
		dx = i;

	}

	/**
	 * over-rides the Game Object paint method and paint the ball into the shape of
	 * a circle
	 */
	public void paint(Graphics g) {
		g.setColor(c);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
	}

	/**
	 * sets the colour of the object to a new colour, over-riding game object
	 */
	public void setColor(Color c) {
		this.c = c;
	}

	/**
	 * sets a random value for y between -1 and 1
	 */
	// public void newDy() {
	// dy = (int) Math.random() * 3 - 1;
	// }
}
