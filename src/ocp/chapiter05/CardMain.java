package ocp.chapiter05;

import java.util.HashMap;
import java.util.Map;

class Card {
	private String rank;
	private String suit;

	public Card(String r, String s) {
		if (r == null || s == null)
			throw new IllegalArgumentException();
		rank = r;
		suit = s;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if(!(o instanceof Card))
			return false;
		Card c = (Card) o;
		return c.rank == this.rank && c.suit == this.suit;
	}
	
	@Override
	public int hashCode() {
		int result = rank.hashCode();
		result = 31 * result + suit.hashCode();
		return result;
	}

}

public class CardMain {

	public static void main(String[] args) {
		Map<Card, String> c = new HashMap<Card, String>();
		c.put(new Card("4", "52"), "Jenny");
		System.out.println(c.get(new Card("4", "52"))); // Jenny
	}
}
