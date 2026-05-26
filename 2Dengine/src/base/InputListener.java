package base;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Just a base listener to be added to the JPanel
 * This should not need anything more than the basics as Input.java will be the middleman with more customized and complicated stuff
 */
public class InputListener implements KeyListener {
	
	public void keyTyped(KeyEvent e) {
		Input.keyTyped(e.getKeyCode());
	}

	public void keyPressed(KeyEvent e) {
		Input.keyDown(e.getKeyCode());
	}

	public void keyReleased(KeyEvent e) {
		Input.keyUp(e.getKeyCode());
	}

}
