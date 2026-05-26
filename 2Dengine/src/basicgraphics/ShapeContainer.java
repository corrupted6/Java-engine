package basicgraphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import base.Root;

public class ShapeContainer {
	
	private static Color currColor = new Color(0, 0, 0);
	private static ArrayList<Line> lines = new ArrayList<Line>();
	
	/**
	 * Adds a Line to be rendered every frame. 
	 * Note that the Graphics color will only be one color, the color set for ShapeContainer.
	 * 
	 * @param l the Line to be added
	 * @return The index of the Line in the ArrayList for possible removal later
	 */
	public static int addLine(Line l) {
		lines.add(l);
		return lines.size() - 1;
	}
	
	public static void setColor(Color c) {
		currColor = c;
	}
	
	public static void drawContents() {
		//define graphics, set its color for drawing
		Graphics g = Root.frame.getGraphics();
		g.setColor(currColor);
		
		//draw all lines
		for (Line l : lines) {
			if (l != null) {
				l.drawLine(g);
			}
		}
	}
}