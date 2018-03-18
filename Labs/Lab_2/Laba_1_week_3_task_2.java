package com.tasks3.carddeck;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Deck {
	private final int SIZE = 36;
	private LinkedList<Card> cardList;

	public Deck() {
		cardList = new LinkedList<>();

		for (int suit = 0; suit < Suit.values.length; suit++) {
			for (int rank = 0; rank < Rank.values.length; rank++) {
				cardList.add(new Card(Rank.values[rank], Suit.values[suit]));
			}
		}

	}

	//Перемішує колоду у випадковому порядку
	public void shuffle() {
		Double RndCrdInd;
		Double numberOfShuffles = Math.random() * 100 + 30;
		for (int i = 0; i < numberOfShuffles.intValue(); i++) {
			RndCrdInd = Math.random() * SIZE;
			cardList.addLast(cardList.remove(RndCrdInd.intValue()));
		}
	}

	public void order() {
		class CardComparator implements Comparator<Card> {
			@Override
				public int compare(Card card1, Card card2) {
				int Rank_Card_1 = 0;
				int Rank_Card_2 = 0;

				for (int i = 0; i < Rank.values.length; i++) {
					if (card1.getRank().getName().equals(Rank.values[i].getName()))
						Rank_Card_1 = i;
					if (card2.getRank().getName().equals(Rank.values[i].getName()))
						Rank_Card_2 = i;

				}

				if (Rank_Card_1 == Rank_Card_2)
					return 0;
				else {
					if (Rank_Card_1 > Rank_Card_2)
						return 1;
					else
						return -1;
				}
			}

		}


		TreeSet<Card> spadesSet = new TreeSet<>(new CardComparator());
		TreeSet<Card> clubsSet = new TreeSet<>(new CardComparator());
		TreeSet<Card> diamondsSet = new TreeSet<>(new CardComparator());
		TreeSet<Card> heartsSet = new TreeSet<>(new CardComparator());


		while (this.hasNext()) {
			Card tempcard;

			tempcard = this.drawOne();

			if (tempcard.getSuit() == Suit.HEARTS)
				heartsSet.add(tempcard);
			else {
				if (tempcard.getSuit() == Suit.DIAMONDS)
					diamondsSet.add(tempcard);
				else {
					if (tempcard.getSuit() == Suit.CLUBS)
						clubsSet.add(tempcard);
					else {
						if (tempcard.getSuit() == Suit.SPADES)
							spadesSet.add(tempcard);
					}
				}
			}

		}
		cardList.addAll(heartsSet);

		cardList.addAll(diamondsSet);
		cardList.addAll(clubsSet);
		cardList.addAll(spadesSet);

		heartsSet = diamondsSet = clubsSet = spadesSet = null;
	}

	
	public boolean hasNext() {
		return !cardList.isEmpty();
	}

	
	public Card drawOne() {
		if (hasNext()) {
			return cardList.removeLast();
		}
		else
			return null;

	}
}
