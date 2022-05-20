package app;

import java.util.*;

public class Card implements Comparable {

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

    public Card() {}



    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Card)) {
            return false;
        } else {
            Card other_card = (Card) other;
            return this.value == other_card.value;
        }
    }

    /** Predicate method to check if a card is the empty card
     * @return true if card is an EmptyCard instance, false otherwise
     */
    public boolean isEmptyCard() { return false; }

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

class EmptyCard extends Card {

    /**
     * An EmptyCard is a special type of card
     * used to denote empty spaces on the game
     * board
     */

    public EmptyCard() {
        this.value = 0;
        this.suit = 0;
    }

    public String toString() {
        return "EMPTY";
    }

    @Override
    public boolean isEmptyCard() { return true; }

}