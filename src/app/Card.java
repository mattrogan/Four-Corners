package app;

import java.util.*;

public class Card implements Comparable {

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

        // Generate string for suit
        if (value==10){
            value_str="Jack";
        }else if (value==11){
            value_str="Queen";
        }else if(value==12){
            value_str="King";
        }else if (value==13){
            value_str="Ace";
        }else{
            value_str = Integer.toString(value);
        }

        // Generate string for suit
        if (suit == 1) {
            suit_str = "Clubs";
        } else if (suit == 2) {
            suit_str = "Diamonds";
        } else if (suit == 3) {
            suit_str = "Hearts";
        } else {
            suit_str = "Spades";
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

    /**
     * Compare a Card to another object
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Card)){
            throw new ClassCastException("can only compare Card objects to other cards");
        } else {
            Card other = (Card) o;
            return Integer.compare(value, other.value);
        }
    }
}
