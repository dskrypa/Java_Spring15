package chapter_07;

import java.security.SecureRandom;
import java.util.Hashtable;

public class DeckOfCards {
	private Card[] deck;
	private int currentCard;
	private static final int NUMBER_OF_CARDS = 52;
	private static final SecureRandom sr = new SecureRandom();
	
	public DeckOfCards() {
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		deck = new Card[NUMBER_OF_CARDS];
		currentCard = 0;
		for (int c = 0; c < deck.length; c++) {
			deck[c] = new Card(faces[c%13], suits[c/13]);
		}
	}
	
	public void shuffle() {
		currentCard = 0;
		for (int a = 0; a<deck.length; a++) {
			int b = sr.nextInt(NUMBER_OF_CARDS);
			Card temp = deck[a];
			deck[a] = deck[b];
			deck[b] = temp;
		}
	}
	
	public Card dealCard() {
		if (currentCard < deck.length) {
			return deck[currentCard++];
		} else {
			return null;
		}
	}
	
	public Card[] dealHand(final int cards) {
		if (cards <= (deck.length-currentCard)) {
			Card[] hand = new Card[cards];
			for (int x = 0; x < cards; x++) {
				hand[x] = dealCard();
			}
			return hand;
		}
		return null;
	}
	
	public String analyzeHand(final Card[] hand) {
		Hashtable<String, Integer> faceCount = new Hashtable<>();
		Hashtable<String, Integer> suitCount = new Hashtable<>();
		
		
		
		
		
		return null;
	}
}
