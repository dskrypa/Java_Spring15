package chapter_07;

public class Card {
	private final String face;
	private final String suit;
	
	public Card (final String cardFace, final String cardSuit) {
		face = cardFace;
		suit = cardSuit;
	}
	
	public String toString() {
		return face + " of " + suit;
	}

	public String getFace() {
		return face;
	}

	public String getSuit() {
		return suit;
	}
}
