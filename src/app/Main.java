package app;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static ArrayList<Card> deck = new ArrayList<Card>();


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

        // Generate deck of cards
        generateDeck();
    }
}