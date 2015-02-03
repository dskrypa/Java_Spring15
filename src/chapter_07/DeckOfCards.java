package chapter_07;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Hashtable;

public class DeckOfCards {
	private Card[] deck;
	private int currentCard;
	private static final int NUMBER_OF_CARDS = 52;
	private static final SecureRandom sr = new SecureRandom();
	
	public DeckOfCards() {
		deck = new Card[NUMBER_OF_CARDS];
		currentCard = 0;
		int c = 0;
		for (CardSuit cs : CardSuit.values()) {
			for (CardFace cf : CardFace.values()) {
				deck[c++] = new Card(cf, cs);
			}
		}
	}
	
	public int cardsRemaining() {
		return NUMBER_OF_CARDS - currentCard;
	}
	
	public void shuffle() {
		currentCard = 0;
		for (int a = 0; a < deck.length; a++) {
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
	
	public static String analyzeHand(final Card[] hand) {
		Arrays.sort(hand);
		Hashtable<CardFace, Integer> faceCount = new Hashtable<>();
		Hashtable<CardSuit, Integer> suitCount = new Hashtable<>();
		
		for (Card c : hand) {
			CardFace face = c.getFace();
			CardSuit suit = c.getSuit();
			
			if (faceCount.containsKey(face)) {
				faceCount.replace(face, faceCount.get(face)+1);
			} else {
				faceCount.put(face, 1);
			}
			
			if (suitCount.containsKey(suit)) {
				suitCount.replace(suit, suitCount.get(suit)+1);
			} else {
				suitCount.put(suit, 1);
			}
		}
		
		boolean has4f = false, has3f = false, has2f = false;
		for (Integer faceCounter : faceCount.values()) {
			switch (faceCounter) {
				case 4:	has4f = true;	break;
				case 3:	has3f = true;	break;
				case 2: has2f = true;	break;
			}
		}
		
		if (has3f && has2f) {
			return "Full House";
		}
		
		boolean expand = false;
		int[] faceVals = new int[hand.length];
		for (int i = 0; i < hand.length; i++) {
			faceVals[i] = hand[i].getFace().ordinal();
			if (faceVals[i] == 0) {
				expand = true;
			}
		}
		if (expand) {
			faceVals = Arrays.copyOf(faceVals, faceVals.length+1);
			faceVals[faceVals.length-1] = 13;
		}
		Arrays.sort(faceVals);
		
		int straight = 1;
		int lastVal = faceVals[0];
		for (int x = 1; x < faceVals.length; x++) {
			if ((faceVals[x] - lastVal) == 1) {
				straight++;
				lastVal = faceVals[x];
			} else if ((x == 1) && (faceVals.length > hand.length)) {
				lastVal = faceVals[x];
			} else {
				break;
			}
		}

		int numSuits = suitCount.size();
		
		if (straight == 5) {
			if (numSuits == 1) {
				return "Straight Flush";
			}
			return "Straight";
		} else if (numSuits == 1) {
			return "Flush";
		} else if (has4f) {
			return "Four of a kind";
		} else if (has3f) {
			return "Three of a kind";
		} else if (has2f && (faceCount.size() == 3)) {
			return "Two pairs";
		} else if (has2f) {
			return "Pair";
		}
		return "Nothing";
	}
}
