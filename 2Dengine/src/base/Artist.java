package base;

import java.awt.Color;
import java.awt.Graphics;

public class Artist {
	
	//so u aren't making a new object every trime a method is called
	private static Graphics g;
	
	/**
	 * don't use this method every frame or it will trigger epileptic seizures,
	 * fills the whole frame with a random color
	 */
	public static void randomColor() {
		 g = Root.panel.getRaster().getGraphics();
		int[] dimensions = Root.panel.getDimensions();
		
		g.setColor(new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256)));
		
		g.fillRect(0, 0, dimensions[0], dimensions[1]);
	}
	
	/**
	 * @param x X coordinate of the pixel on the screen.
	 * @param y Y coordinate of the pixel on the screen.
	 */
	public static void pixel(int x, int y) {
		g = Root.panel.getRaster().getGraphics();
		int[] dimensions = Root.panel.getDimensions();
		
		if (x >= dimensions[0] || y >= dimensions[1]) {return;}
		
		g.drawRect(x, y, 1, 1);
	}
	
	/**
	 * @param x X coordinate of the pixel on the screen.
	 * @param y Y coordinate of the pixel on the screen.
	 * @param c Color of the pixel.
	 */
	public static void pixel(int x, int y, Color c) {
		g = Root.panel.getRaster().getGraphics();
		int[] dimensions = Root.panel.getDimensions();
		
		if (x >= dimensions[0] || y >= dimensions[1]) {return;}
		
		g.setColor(c);
		g.drawRect(x, y, 1, 1);
	}
	
	/**
	 * @param x X coordinate of the pixel on the screen.
	 * @param y Y coordinate of the pixel on the screen.
	 * @param w Width of the rectangle.
	 * @param h Height of the rectangle.
	 */
	public static void rect(int x, int y, int w, int h) {
		g = Root.panel.getRaster().getGraphics();
		int[] dimensions = Root.panel.getDimensions();
		
		if (x + w >= dimensions[0] || y + h >= dimensions[1]) {return;}
		
		g.drawRect(x, y, w, h);
	}
	
	/**
	 * @param x X coordinate of the pixel on the screen.
	 * @param y Y coordinate of the pixel on the screen.
	 * @param w Width of the rectangle.
	 * @param h Height of the rectangle.
	 * @param c Color of the rectangle.
	 */
	public static void rect(int x, int y, int w, int h, Color c) {
		g = Root.panel.getRaster().getGraphics();
		int[] dimensions = Root.panel.getDimensions();
		
		if (x + w >= dimensions[0] || y + h >= dimensions[1]) {return;}
		
		g.setColor(c);
		g.drawRect(x, y, w, h);
	}
	
	/**
	 * @param x X coordinate of the pixel on the screen.
	 * @param y Y coordinate of the pixel on the screen.
	 * @param w Width of the rectangle.
	 * @param h Height of the rectangle.
	 */
	public static void fillRect(int x, int y, int w, int h) {
		g = Root.panel.getRaster().getGraphics();
		int[] dimensions = Root.panel.getDimensions();
		
		if (x + w >= dimensions[0] || y + h >= dimensions[1]) {return;}
		
		g.fillRect(x, y, w, h);
	}
	
	/**
	 * @param x X coordinate of the pixel on the screen.
	 * @param y Y coordinate of the pixel on the screen.
	 * @param w Width of the rectangle.
	 * @param h Height of the rectangle.
	 * @param c Color of the rectangle.
	 */
	public static void fillRect(int x, int y, int w, int h, Color c) {
		g = Root.panel.getRaster().getGraphics();
		int[] dimensions = Root.panel.getDimensions();
		
		if (x + w >= dimensions[0] || y + h >= dimensions[1]) {return;}
		
		g.setColor(c);
		g.fillRect(x, y, w, h);
	}
	
	/**
	 * @param x1 Starting X coordinate.
	 * @param y1 Starting Y coordinate.
	 * @param x2 Ending X coordinate.
	 * @param y2 Ending Y coordinate.
	 */
	public static void line(int x1, int y1, int x2, int y2) {
		g = Root.panel.getRaster().getGraphics();
		int[] dimensions = Root.panel.getDimensions();
		
		if (x1 >= dimensions[0] || y1  >= dimensions[1] || x2 >= dimensions[0] || y2  >= dimensions[1]) {return;}
		
		g.drawLine(x1, y1, x2, y2);
	}
	
	/**
	 * @param x1 Starting X coordinate.
	 * @param y1 Starting Y coordinate.
	 * @param x2 Ending X coordinate.
	 * @param y2 Ending Y coordinate.
	 * @param c Color of the line.
	 */
	public static void line(int x1, int y1, int x2, int y2, Color c) {
		g = Root.panel.getRaster().getGraphics();
		int[] dimensions = Root.panel.getDimensions();
		
		if (x1 >= dimensions[0] || y1  >= dimensions[1] || x2 >= dimensions[0] || y2  >= dimensions[1]) {return;}
		
		g.setColor(c);
		g.drawLine(x1, y1, x2, y2);
	}
	
	public static void erase() {
		g = Root.panel.getRaster().getGraphics();
		int[] dimensions = Root.panel.getDimensions();
		
		g.setColor(Root.panel.getBackground());
		
		g.fillRect(0, 0, dimensions[0], dimensions[1]);
	}
}