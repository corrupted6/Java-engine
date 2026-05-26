package basicgraphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import base.Root;

/**
 * animates a line for right now
 * future: add smoothing
 */
public class Animation {
	
	private static ArrayList<Animation> instanceList = new ArrayList<Animation>();
	
	private animType type;
	private int[] lineStart;
	private double stepX1, stepY1, stepX2, stepY2;
	private boolean running;
	private int[] currentPixel = new int[4];
	private double[] currentActual = new double[4];
	private int frameLength, currentFrame = 0;
	private Line tempLine;
	private Color lineColor;
	
	/**
	 * Makes an Animation of a line, but doesn't use a Line object.
	 * 
	 * @param start Start coordinates formatted as {x1, y1, x2, y2}
	 * @param end End coordinates formatted as {x1, y1, x2, y2}
	 * @param frames Frame duration
	 * @param c Line color
	 */
	public Animation(int[] start, int[] end, int frames, Color c) {
		
		if (start.length != 4 || end.length != 4) { return; }
		
		lineStart = start;
		frameLength = frames;
		lineColor = c;
		
		//get all of the steps, only linear smoothing
		stepX1 = Math.abs(start[0] - end[0]) / frameLength;
		stepY1 = Math.abs(start[1] - end[1]) / frameLength;
		stepX2 = Math.abs(start[2] - end[2]) / frameLength;
		stepY2 = Math.abs(start[3] - end[3]) / frameLength;
		
		type = animType.COORDS_TO_COORDS;
		instanceList.add(this);
		
		//garbage collection
		for (int i = 0; i < instanceList.size(); i++) {
			if (instanceList.get(i) == null) {
				instanceList.remove(i);
			}
		}
	}
	
	/**
	 * Makes an Animation of a line using 2 Line objects, also makes a temp Line.
	 * 
	 * @param start Start coordinates formatted as {x1, y1, x2, y2}
	 * @param end End coordinates formatted as {x1, y1, x2, y2}
	 * @param frames Frame duration
	 * @param c Line color
	 */
	public Animation(Line start, Line end, int frames, Color c) {
		
		int[] startCoords = {(int)start.getX1(), (int)start.getY1(), (int)start.getX2(), (int)start.getY2()};
		lineStart = startCoords;
		frameLength = frames;
		lineColor = c;
		
		stepX1 = Math.abs(lineStart[0] - end.getX1()) / frameLength;
		stepY1 = Math.abs(lineStart[1] - end.getY1()) / frameLength;
		stepX2 = Math.abs(lineStart[2] - end.getX2()) / frameLength;
		stepY2 = Math.abs(lineStart[3] - end.getY2()) / frameLength;
		
		type = animType.LINE_TO_LINE;
		tempLine = start;
		
		//garbage collection
			for (int i = 0; i < instanceList.size(); i++) {
				if (instanceList.get(i) == null) {
					instanceList.remove(i);
				}
			}
	}
	
	public static void step() {
		
		for (Animation anim : instanceList) {
			switch (anim.getType()) {
			case COORDS_TO_COORDS:
				anim.stepCoordsToCoords();
				break;
			case LINE_TO_LINE:
				System.out.println("step");
				anim.stepLineToLine();
				break;
			default:
				//idc
			}
		}
	}
	
	public void play() {
		reset();
		running = true;
	}
	
	public void pause() {
		running = false;
	}
	
	public void reset() {
		for (int i = 0; i < 4; i++) {
			currentPixel[i] = lineStart[i];
			currentActual[i] = lineStart[i];
		}
	}
	
	private void stepCoordsToCoords() {
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
			
			//draw the line
			Graphics g = Root.panel.getRaster().getGraphics();
			g.setColor(lineColor);
			g.drawLine(currentPixel[0], currentPixel[1], currentPixel[2], currentPixel[3]);
		} else if (currentFrame >= 0) {
			pause();
			reset();
		}
	}
	
	private void stepLineToLine() {
		if (running && currentFrame <= frameLength) {
			System.out.println("line to line loop");
			currentFrame++;
			
			tempLine.modX1(stepX1);
			tempLine.modY1(stepY1);
			tempLine.modX2(stepX2);
			tempLine.modY2(stepY2);
			
			Graphics g = Root.panel.getRaster().getGraphics();
			tempLine.drawLine(g, lineColor);
			System.out.println("drawing line");
		} else if (currentFrame >= 0) {
			pause();
			reset();
		}
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public animType getType() {
		return type;
	}
}