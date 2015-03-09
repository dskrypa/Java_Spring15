package examples;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class FlashingText extends JApplet implements Runnable {
	private static final long serialVersionUID = -7603137002678035893L;
	private JLabel jlblText = new JLabel(" ", JLabel.CENTER);
	
	public FlashingText() {
		add(jlblText);
		new Thread(this).start();
	}
	
	public void run() {
		try {
			while (true) {
				if (jlblText.getText().equals("Now you see it.")) {
					jlblText.setText("Now you don't.");
				} else {
					jlblText.setText("Now you see it.");
				}
				Thread.sleep(2000);
			}
		} catch (Exception e) {}
	}

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Flashing Text");
				frame.add(new FlashingText());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(200, 200);
				frame.setVisible(true);
			}
		});
	}
}
