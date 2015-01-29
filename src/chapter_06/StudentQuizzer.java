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
	private int difficulty, qType, numCorrect, numWrong;
	private float answer;
	
	/**
	 * Main method to test/run StudentQuizzer
	 * @param args runtime arguments (ignored)
	 */
	public static void main(String[] args){
		System.out.println("Welcome to the Computer-Assisted Instruction Quizzer.");
		StudentQuizzer sq = new StudentQuizzer();
		sq.runQuiz();
	}
	
	/**
	 * Construct a new StudentQuizzer, initializing a new random number generator.
	 */
	public StudentQuizzer(){
		gen = new SecureRandom();
		numCorrect = 0;
		numWrong = 0;
	}
	
	/**
	 * Main loop for posing questions and getting user responses.
	 */
	public void runQuiz(){
		Scanner s = new Scanner(System.in);
		setDifficulty(s);
		setType(s);
		boolean canRun = true, askNew = true;
		
		while (canRun) {
			if (askNew) {
				System.out.print(getQuestion());
			}
			String inpt = s.nextLine();
			if (inpt.equals("quit")) {
				canRun = false;
				System.out.println("Goodbye.");
				continue;
			}
			
			Float val = null;
			try {
				val = Float.parseFloat(inpt);
			} catch (NumberFormatException e) {
				askNew = false;
				System.out.print("Invalid input. (Type 'quit' to exit) Please try again: ");
				continue;
			}
			
			if (checkAnswer(val)) {
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
	
	/**
	 * Picks an operation to use for the next question.
	 * @return the int representing the operation to use
	 */
	public int pickOperation(){
		if (qType == 5){
			return gen.nextInt(4)+1;
		} else {
			return qType;
		}
	}
	
	/**
	 * Generate a new question based on difficulty level and the type
	 * of operation to use, and store the proper answer for later verification.
	 * @return a String containing the question for the user
	 */
	public String getQuestion(){
		String operation = null;
		float a = gen.nextInt((int)Math.pow(10, difficulty));
		float b = gen.nextInt((int)Math.pow(10, difficulty));
		switch (pickOperation()) {
			case 1:
				operation = " plus ";
				answer = a + b;
				break;
			case 2:
				operation = " minus ";
				answer = a - b;
				break;
			case 3:
				operation = " times ";
				answer = a * b;
				break;
			case 4:
				operation = " divided by ";
				while (b == 0) {
					b = gen.nextInt((int)Math.pow(10, difficulty));
				}
				answer = a / b;
				break;
		}
		return "How much is " + (int)a + operation + (int)b + "? ";
	}
	
	/**
	 * Check a given value against the proper answer.
	 * @param val the user-provided value
	 * @return true if val and answer are equal to the thousandths place
	 */
	public boolean checkAnswer(final float val){
		return Math.floor(val*1000) == Math.floor(answer*1000);
	}
	
	/**
	 * Fetch a response to provide the user based on their input
	 * @param positive true for a positive response, false for a negative response
	 * @return a random response with the given tone
	 */
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
	
	/**
	 * Check to see how well a student is performing, and provide an appropriate
	 * message after every 10 student answers
	 * @return null if fewer than 10 answers have been given, otherwise a message
	 */
	public String checkPercentage(){
		String response = null;
		if ((numCorrect + numWrong) == 10) {
			float pct = (float)(numCorrect/10.0) * 100;
			if (pct < 75) {
				response = "Please ask your teacher for extra help.\n";
			} else {
				response = "Congratulations, you are ready to go to the next level!\n";
			}
			numCorrect = 0;
			numWrong = 0;
		}
		return response;
	}
	
	/**
	 * Retrieve user input regarding the difficulty that they want to use,
	 * looping until valid input is provided.
	 * @param s the Scanner to use for user input
	 */
	private void setDifficulty(final Scanner s){
		int diff = 0;
		while ((diff > 5) || (diff < 1)) {
			System.out.print("Please enter a valid difficulty level (between 1 and 5): ");
			String dlvl = s.nextLine();
			try {
				diff = Integer.parseInt(dlvl);
			} catch (NumberFormatException e) {}
		}
		difficulty = diff;
	}
	
	/**
	 * Retrieve user input regarding the type of problems that they want to
	 * solve, looping until valid input is provided.
	 * @param s the Scanner to use for user input
	 */
	private void setType(final Scanner s){
		System.out.println("Problem types:");
		System.out.println("1. Addition Only");
		System.out.println("2. Subtraction Only");
		System.out.println("3. Multiplication Only");
		System.out.println("4. Division Only");
		System.out.println("5. Random");
		int qType = 0;
		while ((qType > 5) || (qType < 1)) {
			System.out.print("Please enter a valid problem type to work on: ");
			String qt = s.nextLine();
			try {
				qType = Integer.parseInt(qt);
			} catch (NumberFormatException e) {}
		}
		this.qType = qType;
	}
}