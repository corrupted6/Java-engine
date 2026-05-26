package base;

import java.awt.Color;
import java.awt.Graphics;

/**
 * animates a line for right now
 */
public class Animation {
	
	private int[] lineStart, lineEnd;
	private double stepX1, stepY1, stepX2, stepY2;
	private boolean running;
	private int[] currentPixel = new int[4];
	private double[] currentActual = new double[4];
	private int frameLength, currentFrame = 0;
	
	public Animation(int[] start, int[] end, int frames) {
		
		if (start.length != 4 || end.length != 4) { return; }
		
		lineStart = start;
		lineEnd = end;
		frameLength = frames;
		
		stepX1 = Math.abs(start[0] - end[0]) / frameLength;
		stepY1 = Math.abs(start[1] - end[1]) / frameLength;
		stepX2 = Math.abs(start[2] - end[2]) / frameLength;
		stepY2 = Math.abs(start[3] - end[3]) / frameLength;
		
	}
	
	public void play() {
		//reset line
		for (int i = 0; i < 4; i++) {
			currentPixel[i] = lineStart[i];
			currentActual[i] = lineStart[i];
		}
		running = true;
		
	}
	
	public void step() {
		if (running && currentFrame <= frameLength) {
			currentFrame++;
			
			currentActual[0] += stepX1;
			currentActual[1] += stepY1;
			currentActual[2] += stepX2;
			currentActual[3] += stepY2;
			
			currentPixel[0] = (int) Math.round(currentActual[0]);
			currentPixel[1] = (int) Math.round(currentActual[1]);
			currentPixel[2] = (int) Math.round(currentActual[2]);
			currentPixel[3] = (int) Math.round(currentActual[3]);
		} else {
			currentFrame = 0;
			running = false;
		}
		
		//draw the line
		Graphics g = Root.panel.getRaster().getGraphics();
		g.setColor(new Color(0, 0, 0));
		g.drawLine(currentPixel[0], currentPixel[1], currentPixel[2], currentPixel[3]);
	}
	
}