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
            Double randomCardIndex;
            Double numberOfShuffles = Math.random() * 100 + 30;
            for (int i = 0; i < numberOfShuffles.intValue(); i++) {
                randomCardIndex = Math.random() * SIZE;
                cardList.addLast(cardList.remove(randomCardIndex.intValue()));
            }
        }

        public void order() {
            class CardComparator implements Comparator<Card> {
                @Override
                public int compare(Card card1, Card card2) {
                    int rankCard1 = 0;
                    int rankCard2 = 0;

                    for (int i = 0; i < Rank.values.length; i++) {
                        if (card1.getRank().getName().equals(Rank.values[i].getName()))
                            rankCard1 = i;
                        if (card2.getRank().getName().equals(Rank.values[i].getName()))
                            rankCard2 = i;

                    }

                    if (rankCard1 == rankCard2)
                        return 0;
                    else {
                        if (rankCard1 > rankCard2)
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

        //Повертає true у випадку коли в колоді ще доступні карти
        public boolean hasNext() {
            return !cardList.isEmpty();
        }

        //"Виймає" одну карту з колоди, коли буде видано всі 36 карт повертає null
        //Карти виймаються з "вершини" колоди. Наприклад перший виклик видасть SPADES 6 потім
        //SPADES 7, ..., CLUBS 6, ..., CLUBS Ace і так далі до HEARTS Ace
        public Card drawOne() {
            if (hasNext()) {
                return cardList.removeLast();
            } else
                return null;

        }
    }
