package chapter_07;

/**
 * Chapter 7 - Problem 30: Card Shuffling and Dealing
 * @author Douglas Skrypa
 * @version 2015.02.02
 * https://github.com/dskrypa/Java_Spring15
 */
public class Card implements Comparable<Card> 
{
	private final CardFace face;
	private final CardSuit suit;
	
	public Card (final CardFace cardFace, final CardSuit cardSuit) {
		face = cardFace;
		suit = cardSuit;
	}
	
	public String toString() {
		return face.toString() + " of " + suit.toString();
	}

	public CardFace getFace() {
		return face;
	}

	public CardSuit getSuit() {
		return suit;
	}

	@Override
	public int compareTo(Card o) {
		if (this.getSuit() != o.getSuit()) {
			return this.getSuit().compareTo(o.getSuit());
		} else {
			return this.getFace().compareTo(o.getFace());
		}
	}
}
