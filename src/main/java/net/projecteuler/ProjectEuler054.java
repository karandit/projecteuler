package net.projecteuler;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.projecteuler.util.Tuple;

public class ProjectEuler054 {

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_054());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static int solve_054() {
		try (InputStream is = ProjectEuler054.class.getResourceAsStream("ProjectEuler_054.txt");
				BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

			String line = null;
			while ((line = reader.readLine()) != null) {
				Hand h1 = new Hand(line.substring(0, 15));
				Hand h2 = new Hand(line.substring(15));
				System.out.println(h1 + " | " + h1.rank());
				System.out.println(h2 + " | " + h2.rank());
			}
			return 0;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private enum CardValue {
		Two('2'), Three('3'), Four('4'), Five('5'), Six('6'), Seven('7'), Eight('8'), Nine('9'), 
		Ten('T'), Jack('J'), Queen('Q'), King('K'), Ace('A');
		
		public final char charValue;
		private CardValue(char value) { this.charValue = value; }
		
		public static CardValue parse(char c) {
			for (CardValue cardValue : CardValue.values()) { if (cardValue.charValue == c) { return cardValue; } }
			throw new RuntimeException("Unrecognizable card value");
		}
		
		@Override public String toString() { return String.valueOf(charValue); }
	}
	
	private enum CardSuit {
		Clubs('C'), Diamonds('D'), Hearts('H'), Spades('S');
		
		public final char charValue;
		private CardSuit(char value) { this.charValue = value; }

		public static CardSuit parse(char c) {
			for (CardSuit suit : CardSuit.values()) { if (suit.charValue == c) { return suit; } }
			throw new RuntimeException("Unrecognizable card suit");
		}

		@Override public String toString() { return String.valueOf(charValue); }
	}
	
	public static class Card extends Tuple<CardValue, CardSuit> {
		public Card(String cc) { super(CardValue.parse(cc.charAt(0)), CardSuit.parse(cc.charAt(1))); }
		
		@Override public String toString() { return getA() + "" + getB(); }
	}

	private interface Rank { }
	
	public static class Flush implements Rank {
		private final List<Card> cards;
		public Flush(List<Card> cards) { this.cards = cards; }
		@Override public String toString() { return "Flush " + cards; }
	}

	public static class FourOfAKind implements Rank {
		private final CardValue value;
		public FourOfAKind(CardValue value) { this.value = value; }
		@Override public String toString() { return "Poker " + value; }
	}
	
	public static class ThreeOfAKind implements Rank {
		private final CardValue value;
		public ThreeOfAKind(CardValue value) { this.value = value; }
		@Override public String toString() { return "Triple " + value; }
	}

	public static class TwoOfAKind implements Rank {
		private final CardValue value;
		public TwoOfAKind(CardValue value) { this.value = value; }
		@Override public String toString() { return "Pair " + value; }
	}

	public static class HighValue implements Rank {
		private final CardValue value;
		public HighValue(CardValue value) { this.value = value; }
	}
	
	public static class Hand {
		private final List<Card> cards;
		
		public Hand(String cardsAsString) {
			this.cards = stream(cardsAsString.split(" ")).map(Card::new).collect(toList());
		}

		public List<Rank> rank() {
			Map<CardSuit, List<Card>> groupedBySuit = new HashMap<>();
			Map<CardValue, List<Card>> groupedByValue = new HashMap<>();
			List<Rank> ranks = new LinkedList<>();
			
			for (Card card : cards) {
				List<Card> sameByValue = groupedByValue.getOrDefault(card.getA(), new LinkedList<>());
				sameByValue.add(card);
				groupedByValue.put(card.getA(), sameByValue);

				List<Card> sameBySuit = groupedBySuit.getOrDefault(card.getB(), new LinkedList<>());
				sameBySuit.add(card);
				groupedBySuit.put(card.getB(), sameBySuit);
			}
			
			for (Map.Entry<CardSuit, List<Card>> entry : groupedBySuit.entrySet()) {
				List<Card> sameSuits = entry.getValue();
				if (sameSuits.size() == 5) {
					ranks.add(new Flush(sameSuits));
				}
			}
			for (Map.Entry<CardValue, List<Card>> entry : groupedByValue.entrySet()) {
				List<Card> sameValues = entry.getValue();
				if (sameValues.size() == 4) {
					ranks.add(new FourOfAKind(sameValues.get(0).getA()));
				} else if (sameValues.size() == 3) {
					ranks.add(new ThreeOfAKind(sameValues.get(0).getA()));
				} else if (sameValues.size() == 2) {
					ranks.add(new TwoOfAKind(sameValues.get(0).getA()));
				}
			}
			
			return ranks;
		}
		
		@Override public String toString() { return cards.toString(); }
	}

}
