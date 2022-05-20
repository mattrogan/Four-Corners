package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static ArrayList<Card> deck = new ArrayList<Card>();


    /**
     * Method to generate the deck of cards
     */
    public static void generateDeck() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 2; j <= 13; j++) {
                Card c = new Card(j,i);        // Create new card
                deck.add(c);                    // Add card to the deck
            }
        }

        // Shuffle the deck
        Collections.shuffle(deck);
    }

    public static void main(String[] args) {

        // Generate deck of cards
        generateDeck();

        // Generate board
        Board gameBoard = new Board();
        gameBoard.placeInitialCards(deck);



        // Set up scanner
        Scanner input = new Scanner(System.in);

        // Gameplay
        while (true)
        {
            gameBoard.display();

            int row, col;
            System.out.print("Enter the row (0-3) to place the next card: ");
            row = input.nextInt();
            System.out.print("Enter the column (0-3) to place the next card: ");
            col = input.nextInt();

            try{
                Card nextCard = deck.remove(0);
                gameBoard.place(nextCard, row, col);
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Couldn't place card. Try again");
            }


        }

    }
}
