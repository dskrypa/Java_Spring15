package chapter_07;

public enum CardFace {
	ACE("Ace"),DEUCE("Deuce"),THREE("Three"),FOUR("Four"),FIVE("Five"),SIX("Six"),SEVEN("Seven"),EIGHT("Eight"),NINE("Nine"),
	TEN("Ten"),JACK("Jack"),QUEEN("Queen"),KING("King");
	
	private final String faceName;
	
	CardFace(final String faceName) {
		this.faceName = faceName;
	}
	
	public String toString() {
		return faceName;
	}
}
