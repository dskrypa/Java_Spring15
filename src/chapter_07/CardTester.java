package chapter_07;

import java.io.IOException;
import java.util.ArrayList;

import common.BFWriter;

public class CardTester {
	public static void main(final String[] args) throws IOException {
		DeckOfCards doc = new DeckOfCards();
		int numShuffles = 5000;
		
		BFWriter bfw = new BFWriter("C:/unix/home/user/classes/2015Q1/Java/temp.txt");
		for (int x = 0; x < numShuffles; x++) {
			for (String line : processDeck(doc)) {
				bfw.write(line + "\n");
			}
		}
		bfw.close();
	}
	
	public static ArrayList<String> processDeck(final DeckOfCards doc) {
		ArrayList<String> output = new ArrayList<>();
		doc.shuffle();
		while (doc.cardsRemaining() >= 5) {	
			Card[] hand = doc.dealHand(5);
			String analysis = DeckOfCards.analyzeHand(hand);
			String contents = getHandString(hand);
			output.add(contents + "\t:\t" + analysis);
		}
		return output;
	}
	
	public static String getHandString(final Card[] hand) {
		String toPrint = "";
		for (Card c : hand) {
			if (toPrint.length() > 0) {
				toPrint += ", ";
			}
			toPrint += c.toString();
		}
		return toPrint;
	}
}
