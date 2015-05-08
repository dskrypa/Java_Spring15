package final_exam.Q2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Final Exam - Question 2
 * @author Douglas Skrypa
 * @version 2015.05.08
 */
public class MyReplacement {

	public static void main(String[] args) throws IOException {
		MyReplacementFrame mrf = new MyReplacementFrame();
		
		String a = mrf.getA();
		String b = mrf.getB();
		String input = mrf.getInName();
		String output = mrf.getOutName();
		
		BufferedReader br = new BufferedReader(new FileReader(input));
		StringBuffer sb = new StringBuffer();
		String l = null;
		while ((l = br.readLine()) != null) {
			if(l.length() > 0){
				sb.append(l.replaceAll(a, b) + "\n");
			}
		}
		br.close();
		
		String toWrite = sb.toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(output));
		bw.write(toWrite);
		bw.close();
		
		System.out.printf("Wrote to %s:\n", output);
		System.out.println(toWrite);
	}
}