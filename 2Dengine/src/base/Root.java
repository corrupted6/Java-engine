package base;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Root {
	
	public static MyFrame frame;
	public static MyPanel panel;
	public static Animation anim;
	private static final int WIDTH = 1600, HEIGHT = 900;
	@SuppressWarnings("unused")
	private static Loop loop;
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				@SuppressWarnings("unused")
				Root r = new Root();
			}
		});
	}
	
	public Root() {
		frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		
		panel = new MyPanel(WIDTH, HEIGHT);
		panel.setFocusable(true);
		
		Input.start();
		
		frame.add(panel);
		frame.addComponentListener(new FrameListener(frame, panel));
		frame.setVisible(true);
		
		int[] s = {0, 0, 100, 100};
		int[] e = {100, 100, 200, 200};
		anim = new Animation(s, e, 60);
		
		loop = new Loop(panel);
		
		anim.play();
	}
}