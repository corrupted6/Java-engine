package base;

import basicgraphics.Animation;

/**
 * Class to contain the game loop for less clutter in the MyPanel class.
 */
public class Loop implements Runnable {
	
	private final int FRAMES = 30;
	private boolean running = true;
	private MyPanel panel;
	
	public Loop(MyPanel p) {
		panel = p;
		Thread t = new Thread(this);
		t.start();
	}
	
	public void run() {
		//get current time
		long ns = System.nanoTime(), lastFrame = System.nanoTime(), lastSecond = System.nanoTime();
		//1 second in nanoseconds over frames
		int frameLength = 1000000000 / FRAMES;
		int frameCount = 0;
		
		while (running) {
			ns = System.nanoTime();
			//if it's been a frame's time, do frame stuff and set time of last frame to current
			if (ns - lastFrame >= frameLength) {
				frame();
				lastFrame = ns;
				frameCount++;
				
				if (ns - lastSecond >= 1000000000) {
					System.out.println("fps " + frameCount);
					frameCount = 0;
					lastSecond = System.nanoTime();
				}
			}
			
		}
	}
	
	/**
	 * Everything to do when a frame is updated.
	 */
	public void frame() {
		//blank slate
		Artist.erase();
		//always repaint
		panel.repaint();
		//animations
		Animation.step();
	}
}
