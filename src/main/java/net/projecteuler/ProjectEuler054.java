package net.projecteuler;

import static java.util.Arrays.stream;
import static java.util.Collections.reverseOrder;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
			int cnt = 0;
			while ((line = reader.readLine()) != null) {
				Hand h1 = new Hand(line.substring(0, 15));
				Hand h2 = new Hand(line.substring(15));
				int won = HandComparator.INSTANCE.compare(h1, h2);
//				System.out.println(h1 + "\t" + h2 + "\t" + (won > 0 ? h1 : h2));
				if (won > 0) {
					cnt++;
				}
			}
			return cnt;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private enum CardValue  {
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

	private interface Rank extends Comparable<Rank> { 
		int getRank();
	}

	public static class StraightFlush implements Rank {
		private final List<Card> cards;
		public StraightFlush(List<Card> cards) { this.cards = cards; }
		@Override public String toString() { return "StraightFlush " + cards; }
		@Override public int getRank() { return 9; }
		@Override public int compareTo(Rank that) { return 0; }
	}

	public static class FourOfAKind implements Rank {
		private final CardValue value;
		public FourOfAKind(CardValue value) { this.value = value; }
		@Override public String toString() { return "Poker " + value; }
		@Override public int getRank() { return 8; }
		@Override public int compareTo(Rank that) { return this.value.ordinal() - ((FourOfAKind) that).value.ordinal(); }
	}
	
	public static class FullHouse implements Rank {
		private final CardValue triple;
		private final CardValue pair;
		public FullHouse(ThreeOfAKind trip, Pair pair) { this.triple = trip.value; this.pair = pair.value; }
		@Override public String toString() { return "Full House, " + triple + "'s over " + pair + "'s"; }
		@Override public int getRank() { return 7; }

		@Override
		public int compareTo(Rank o) {
			FullHouse that = (FullHouse) o;
			int dTriple = this.triple.compareTo(that.triple);
			if (dTriple != 0) return dTriple;
			return this.pair.compareTo(that.pair);
		}
	}

	public static class Flush implements Rank {
		private final List<Card> cards;
		public Flush(List<Card> cards) { this.cards = cards; }
		@Override public String toString() { return "Flush " + cards; }
		@Override public int getRank() { return 6; }
		@Override public int compareTo(Rank that) { return 0; }
	}
	
	public static class Straight implements Rank {
		private final CardValue value;
		public Straight(CardValue value) { this.value = value; }
		@Override public String toString() { return "Straight, " + value + " High"; }
		@Override public int getRank() { return 5; }
		@Override public int compareTo(Rank o) { return this.value.compareTo(((Straight) o).value); }
	}
	
	public static class ThreeOfAKind implements Rank {
		private final CardValue value;
		public ThreeOfAKind(CardValue value) { this.value = value; }
		@Override public String toString() { return "Three of a Kind, " + value + "'s"; }
		@Override public int getRank() { return 4; }
		@Override public int compareTo(Rank that) { return this.value.ordinal() - ((ThreeOfAKind) that).value.ordinal(); }
	}

	public static class TwoPairs implements Rank {
		private final CardValue value1;
		private final CardValue value2;
		public TwoPairs(Pair pair1, Pair pair2) { this.value1 = pair1.value; this.value2 = pair2.value; }
		@Override public String toString() { return "Two Pair, " + value1 + "'s & " + value2 + "'s"; }
		@Override public int getRank() { return 3; }

		@Override
		public int compareTo(Rank o) {
			TwoPairs that = (TwoPairs) o;
			int d1 = this.value1.compareTo(that.value1);
			if (d1 != 0) return d1;
			return this.value2.compareTo(that.value2);
		}
	}

	public static class Pair implements Rank {
		private final CardValue value;
		public Pair(CardValue value) { this.value = value; }
		@Override public String toString() { return "Pair, " + value + "'s"; }
		@Override public int getRank() { return 2; }
		@Override public int compareTo(Rank that) { return this.value.ordinal() - ((Pair) that).value.ordinal(); }
	}

	public static class HighCard implements Rank {
		private final CardValue value;
		public HighCard(CardValue value) { this.value = value; }
		@Override public String toString() { return value + " High"; }
		@Override public int getRank() { return 1; }
		@Override public int compareTo(Rank that) { return this.value.ordinal() - ((HighCard) that).value.ordinal(); }
	}
	
	private static enum RankComparator implements Comparator<Rank> {
		INSTANCE;

		@Override
		public int compare(Rank a, Rank b) { 
			return a.getRank() == b.getRank() ? a.compareTo(b) : a.getRank() - b.getRank(); 
		}
	}
	
	private static enum HandComparator implements Comparator<Hand> {
		INSTANCE;

		@Override
		public int compare(Hand handA, Hand handB) {
			int i = 0;
			while (true) {
				Rank rankA = handA.ranks.get(i);
				Rank rankB = handB.ranks.get(i);
				int compareRes = RankComparator.INSTANCE.compare(rankA, rankB);
				if (compareRes != 0) {
					return compareRes;
				}
				i++;
			}
		}
	}
	
	public static class Hand {
		private final List<Card> cards;
		private final List<Rank> ranks;
		
		public Hand(String cardsAsString) {
			this.cards = stream(cardsAsString.split(" ")).map(Card::new).collect(toList());
			this.ranks = rank(this.cards);
		}

		private static List<Rank> rank(List<Card> cards) {
			List<Rank> ranks = new LinkedList<>();

			List<Card> sortedByValues = cards.stream().sorted((cardA, cardB) -> cardA.getA().compareTo(cardB.getA())).collect(Collectors.toList());
			boolean consecutive = isConsecutive(sortedByValues);
			
			cards.stream()
				.collect(groupingBy(card -> card.getB()))
				.values().stream()
				.filter(suits -> suits.size() == 5)
				.forEach(suits -> ranks.add(newFlush(suits, consecutive)));
			
			if (ranks.isEmpty()) {
				Map<CardValue, List<Card>> cardsGroupedByValue = cards.stream().collect(groupingBy(Card::getA));
				cardsGroupedByValue.entrySet().forEach((Map.Entry<CardValue, List<Card>> entry) -> {
					CardValue value = entry.getKey();
					List<Card> sameValues = entry.getValue();
					if (sameValues.size() == 4) {
						ranks.add(new FourOfAKind(value));
					} else if (sameValues.size() == 3) {
						ranks.add(new ThreeOfAKind(value));
					} else if (sameValues.size() == 2) {
						ranks.add(new Pair(value));
					}
				});
				if (consecutive) {
					ranks.add(new Straight(sortedByValues.get(sortedByValues.size() - 1 ).getA()));
				} else {
					cardsGroupedByValue.entrySet().forEach((Map.Entry<CardValue, List<Card>> entry) -> {
						if (entry.getValue().size() == 1) {
							ranks.add(new HighCard(entry.getKey()));
						}
					});
				}
			}
			Collections.sort(ranks, reverseOrder(RankComparator.INSTANCE));
			if (ranks.size() == 2 && ranks.get(0) instanceof ThreeOfAKind && ranks.get(1) instanceof Pair) {
				ThreeOfAKind triple = (ThreeOfAKind) ranks.get(0);
				Pair pair = (Pair) ranks.get(1);
				ranks.clear();
				ranks.add(new FullHouse(triple, pair));
			}
			if (ranks.size() >= 2 && ranks.get(0) instanceof Pair && ranks.get(1) instanceof Pair) {
				Pair pair1 = (Pair) ranks.get(0);
				Pair pair2 = (Pair) ranks.get(1);
				ranks.remove(0);
				ranks.remove(0);
				
				ranks.add(0, new TwoPairs(pair1, pair2));
			}
			
			return ranks;
		}

		public static Rank newFlush(List<Card> cards, boolean consecutive) {
			return consecutive ? new StraightFlush(cards) : new Flush(cards);
		}
		
		public static boolean isConsecutive(List<Card> sortedByValues) {
			boolean consecutive = true;
			for (int i = 0; i < sortedByValues.size() - 1; i++) {
				if (sortedByValues.get(i).getA().ordinal() + 1 != sortedByValues.get(i+1).getA().ordinal()) {
					consecutive = false;
					break;
				}
			}
			return consecutive;
		}


		
		@Override public String toString() { return /*cards + "" + */ranks.get(0).toString(); }
	}

}
