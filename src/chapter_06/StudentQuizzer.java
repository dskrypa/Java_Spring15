package chapter_06;

import java.security.SecureRandom;
import java.util.Scanner;

public class StudentQuizzer {
	private static String[] responses_positive = {
		"Very good!", "Excellent!", "Nice work!", "Keep up the good work!"
	};
	private static String[] responses_negative = {
		"No.  Please try again.", "Wrong.  Try once more.", "Don't give up!", "No.  Keep trying."
	};
	private SecureRandom gen;
	private int a, b;
	private int numCorrect = 0, numWrong = 0;
	private int difficulty;
	private int qType;
	
	public static void main(String[] args){
		System.out.println("Welcome to the Computer-Assisted Instruction Quizzer.");
		StudentQuizzer sq = new StudentQuizzer();
		sq.runQuiz();
	}
	
	public StudentQuizzer(){
		gen = new SecureRandom();
	}
	
	public void runQuiz(){
		Scanner s = new Scanner(System.in);
		setDifficulty(s);
		setType(s);
		boolean canRun = true, askNew = true;
		
		while (canRun) {
			if (askNew) {
				System.out.println(getQuestion());
			}
			String inpt = s.nextLine();
			if (inpt.equals("quit")) {
				canRun = false;
				System.out.println("Goodbye.");
				continue;
			}
			Integer val = null;
			try {
				val = Integer.parseInt(inpt);
			} catch (NumberFormatException e) {
				askNew = false;
				System.out.println("Invalid input.  Please try again.");
				continue;
			}
			
			boolean correct = checkAnswer(val);
			
			if (correct) {
				askNew = true;
				System.out.println(getResponse(true));
			} else {
				askNew = false;
				System.out.println(getResponse(false));
			}
			
			String pctMessage = checkPercentage();
			if (pctMessage != null) {
				System.out.println(pctMessage);
			}
		}
		s.close();
	}
	
	public String getQuestion(){
		String operation = null;
		switch (qType) {
			case 1:	operation = " plus ";	break;
			case 2:	operation = " minus ";	break;
			case 3:	operation = " times ";	break;
			case 4:	operation = "divided by ";	break;
			default: operation = " idklol ";	break;
		}
		a = gen.nextInt((int)Math.pow(10, difficulty));
		b = gen.nextInt((int)Math.pow(10, difficulty));
		return "How much is " + a + operation + b + "?";
	}
	
	public boolean checkAnswer(final int val){
		return val == (a * b);
	}
	
	public String getResponse(final boolean positive){
		String[] responses;
		if (positive) {
			responses = responses_positive;
			numCorrect++;
		} else {
			responses = responses_negative;
			numWrong++;
		}
		return responses[gen.nextInt(4)];
	}
	
	public String checkPercentage(){
		String response = null;
		if ((numCorrect + numWrong) == 10) {
			float pct = (float)(numCorrect/10.0) * 100;
			if (pct < 75) {
				response = "Please ask your teacher for extra help.";
			} else {
				response = "Congratulations, you are ready to go to the next level!";
			}
			numCorrect = 0;
			numWrong = 0;
		}
		return response;
	}
	
	private void setDifficulty(final Scanner s){
		int diff = 0;
		while ((diff > 5) || (diff < 1)) {
			System.out.println("Please enter a difficulty level (between 1 and 5).");
			String dlvl = s.nextLine();
			try {
				diff = Integer.parseInt(dlvl);
			} catch (NumberFormatException e) {}
		}
		difficulty = diff;
	}
	
	private void setType(final Scanner s){
		System.out.println("Problem types:");
		System.out.println("1. Addition Only");
		System.out.println("2. Subtraction Only");
		System.out.println("3. Multiplication Only");
		System.out.println("4. Division Only");
		System.out.println("5. Random");
		int qType = 0;
		while ((qType > 5) || (qType < 1)) {
			System.out.println("Please enter a problem type to work on.");
			String qt = s.nextLine();
			try {
				qType = Integer.parseInt(qt);
			} catch (NumberFormatException e) {}
		}
		this.qType = qType;
	}
}
