package base;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class FrameListener implements ComponentListener{

	private MyFrame frame;
	private MyPanel panel;
	
	public FrameListener(MyFrame f, MyPanel p) {
		frame = f;
		panel = p;
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
		int width = frame.getWidth();
		int height = frame.getHeight();
		panel.changeDimensions(width, height);
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
