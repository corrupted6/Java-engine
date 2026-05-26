package testcode;

import java.awt.Color;

import basicgraphics.Animation;
import basicgraphics.Line;

public class TestCode {
	public static void codeStart() {
		System.out.println("code start");
		Line s = new Line(0, 0, 200, 200);
		Line e = new Line(500, 100, 700, 300);
		Animation anim = new Animation(s, e, 120, new Color(0, 0, 0));
		
		anim.play();
	}
}
