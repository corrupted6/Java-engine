package basicgraphics;

import java.awt.Color;
import java.awt.Graphics;

public class Line {

	private double x1, y1, x2, y2;
	private boolean isInContainer = false;
	
	public Line() {
		
	}
	
	public Line(int x, int y, int xx, int yy) {
		x1 = x;
		y1 = y;
		x2 = xx;
		y2 = yy;
	}
	
	public Line(int x, int y, int xx, int yy, boolean contained) {
		x1 = x;
		y1 = y;
		x2 = xx;
		y2 = yy;
		
		if (contained) {
			isInContainer = true;
			ShapeContainer.addLine(this);
		}
	}
	
	public void drawLine(Graphics g) {
		if (isInContainer) {return;}
		g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
	}
	
	public void drawLine(Graphics g, Color c) {
		if (isInContainer) {return;}
		g.setColor(c);
		g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
	}
	
	public void modX1(double d) {
		x1 += d;
	}
	
	public void modX2(double d) {
		x2 += d;
	}
	
	public void modY1(double d) {
		y1 += d;
	}
	
	public void modY2(double d) {
		y2 += d;
	}
	
	public double getX1() {
		return x1;
	}
	
	public double getX2() {
		return x2;
	}
	
	public double getY1() {
		return y1;
	}
	
	public double getY2() {
		return y2;
	}
	
}