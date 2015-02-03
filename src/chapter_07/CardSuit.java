package chapter_07;

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
