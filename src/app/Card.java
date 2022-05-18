package app;

import java.util.*;

public class Card {

    public static ArrayList<Card> deck = new ArrayList<Card>();

    int value, suit;

    /**
     * A card object
     *
     * @param value: the value of the card (ranging from 1-13)
     * @param suit: the card's suit (ranging from 1-4)
     */
    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Card)) {
            return false;
        } else {
            Card other_card = (Card) other;
            return this.value == other_card.value;
        }
    }

    @Override
    public String toString() {
        String value_str;
        String suit_str;

        switch (value) {
            case 10:
                value_str = "Jack";
            case 11:
                value_str = "Queen";
            case 12:
                value_str = "King";
            case 13:
                value_str = "Ace";
            default:
                value_str = Integer.toString(value);
        }

        if (suit == 1) {
            suit_str = "Clubs";
        } else if (suit == 2) {
            suit_str = "Diamonds";
        } else if (suit == 3) {
            suit_str = "Hearts";
        } else {
            suit_str = "Clubs";
        }

        return value_str + " of " + suit_str;
    }

    /**
     * Method to generate the deck of cards
     */
    public static void generateDeck() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13; j++) {
                Card c = new Card(j,i);        // Create new card
                deck.add(c);                    // Add card to the deck
            }
        }
    }

    public static void main(String[] args) {
        generateDeck();
    }

}
