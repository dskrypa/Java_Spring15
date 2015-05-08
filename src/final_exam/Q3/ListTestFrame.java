package final_exam.Q3;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Final Exam - Question 3
 * @author Douglas Skrypa
 * @version 2015.05.08
 */
public class ListTestFrame extends JPanel
{
	private static final long serialVersionUID = -2435894944792540270L;

	private int n;
	private String fname;
	
	public ListTestFrame() {
		JFileChooser jfc = new JFileChooser();
		FileNameExtensionFilter fnef = new FileNameExtensionFilter("Text Files", "txt");
		jfc.setFileFilter(fnef);
		
		int rval = jfc.showSaveDialog(this);
		if (rval == JFileChooser.APPROVE_OPTION) {
			fname = jfc.getSelectedFile().getAbsolutePath();
		} else {
			System.err.println("Error: No output file chosen.");
			System.exit(0);
		}
		
		String nstr = (String) JOptionPane.showInputDialog("Please enter the String you would like to replace.");
		
		boolean badInput = false;
		try {
			n = Integer.parseInt(nstr);
		} catch (NumberFormatException e) {
			badInput = true;
		}
		
		if (badInput || n < 1) {
			System.err.println("Error: Invalid input.  Must provide a positive integer");
			System.exit(0);
		}
	}
	
	public int getN() {		return n;}
	public String getFileName() {	return fname;}
}