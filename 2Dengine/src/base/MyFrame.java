package base;

import java.awt.Color;

import javax.swing.JFrame;

/**
 * Custom JFrame just in case anything custom is needed in the future.
 */
public class MyFrame extends JFrame {

	private static final long serialVersionUID = 676767414141420420L;
	
	public MyFrame() {
		setBackground(new Color(200, 200, 200));
	}

}
