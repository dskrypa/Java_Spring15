package chapter_07;

/**
 * Chapter 7 - Problem 30: Card Shuffling and Dealing
 * @author Douglas Skrypa
 * @version 2015.02.02
 * https://github.com/dskrypa/Java_Spring15
 */
public enum CardSuit {
	HEARTS("Hearts"),DIAMONDS("Diamonds"),CLUBS("Clubs"),SPADES("Spades");
	
	private final String suitName;
	
	CardSuit(final String suitName){
		this.suitName = suitName;
	}
	
	public String toString() {
		return suitName;
	}
}
