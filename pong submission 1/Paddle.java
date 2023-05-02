/*
 * This code is protected under the Gnu General Public License (Copyleft), 2005 by
 * IBM and the Computer Science Teachers of America organization. It may be freely
 * modified and redistributed under educational fair use.
 */

import csta.ibm.pong.GameObject;

public class Paddle extends GameObject {
	// Add any state variables here

	/**
	 * Fill in this method with code that describes the behavior
	 * of a paddle from one moment to the next
	 */
	public void act() {

	}

	// Add any additional methods here

	/**
	 * moves the paddle up one pixel when called
	 */

	public void moveUp() {
		setY(getY() - 1);
	}

	/**
	 * moves the paddle down one pixel when called
	 */
	public void moveDown() {
		setY(getY() + 1);
	}
}
