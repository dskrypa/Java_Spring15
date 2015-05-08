package final_exam.Q2;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Final Exam - Question 2
 * @author Douglas Skrypa
 * @version 2015.05.08
 */
public class MyReplacementFrame extends JPanel
{
	private static final long serialVersionUID = -3064735206770055955L;
	
	private String iname, oname;
	private String a, b;
	
	public MyReplacementFrame() {
		JFileChooser jfc = new JFileChooser();
		FileNameExtensionFilter fnef = new FileNameExtensionFilter("Text Files", "txt");
		jfc.setFileFilter(fnef);
		
		int rval = jfc.showOpenDialog(this);
		if (rval == JFileChooser.APPROVE_OPTION) {
			iname = jfc.getSelectedFile().getAbsolutePath();
		} else {
			System.err.println("Error: No input file chosen.");
			System.exit(0);
		}
		
		rval = jfc.showSaveDialog(this);
		if (rval == JFileChooser.APPROVE_OPTION) {
			oname = jfc.getSelectedFile().getAbsolutePath();
		} else {
			System.err.println("Error: No output file chosen.");
			System.exit(0);
		}
		
		a = (String) JOptionPane.showInputDialog("Please enter the String you would like to replace.");
		b = (String) JOptionPane.showInputDialog("Please enter the String you would like to replace the other string with.");	
	}
	
	public String getInName() {	return iname;}
	public String getOutName() {	return oname;}
	public String getA() {		return a;}
	public String getB() {		return b;}
}