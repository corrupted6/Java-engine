package base;

import java.awt.Color;

public class Input {
	
	private static InputListener il = new InputListener();
	private static boolean[] keysDown = new boolean[256];

	public static void start() {
		Root.panel.addKeyListener(il);
	}
	
	//no modifier so only accessible in this package
	static void keyDown(int key) {
		if (key < 256) {
			keysDown[key] = true;
		}
		Artist.line((int)(Math.random() * 900), (int)(Math.random() * 900), (int)(Math.random() * 900), (int)(Math.random() * 900), new Color(0, 0, 0));
	}
	
	static void keyUp(int key) {
		if (key < 256) {
			keysDown[key] = false;
		}
	}
	
	static void keyTyped(int key) {
		if (key < 256) {
			
		}
	}
	
	public static boolean getKey(int key) {
		if (key < 256 && key >= 0) {
			return keysDown[key];
		}
		System.err.println("Input.getKey ran with key index not 0-255.");
		return false;
	}
	
}