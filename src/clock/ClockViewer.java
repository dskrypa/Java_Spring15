package clock;

import javax.swing.JFrame;

/**
 * Refresh view of clock.
 * 
 * @author Douglas Skrypa
 * @version 1
 */
public class ClockViewer
{
	public static void main(String[] args){
		viewer();
	}
	
	public static void viewer(){
		JFrame frame = new JFrame();
		ClockComponent clock;
		
		final int FRAME_WIDTH = 400;
		final int FRAME_HEIGHT = 400;
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Analog Clock");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		clock = new ClockComponent();
		frame.add(clock);
		frame.setVisible(true);
		
		while(true){
			frame.repaint();
			try {
					Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}