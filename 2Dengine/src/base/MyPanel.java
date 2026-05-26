package base;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * Custom JPanel for displaying things to the screen. Only has a modifiable raster, 
 * other custom things more complex than drawing shapes must be done by other classes.
 */
public class MyPanel extends JPanel {

	private static final long serialVersionUID = 676767414141420420L;
	private int width, height;
	private BufferedImage raster;
	
	public MyPanel(int w, int h) {
		
		setSize(w, h);
		width = w;
		height = h;
		
		raster = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(raster, null, 0, 0);
	}
	
	public void changeDimensions(int w, int h) {
		width = w;
		height = h;
		raster = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		setSize(width, height);
	}
	
	//getters
	
	public BufferedImage getRaster() {
		return raster;
	}
	
	public int[] getDimensions() {
		int[] out = {width, height};
		return out;
	}
	
}
