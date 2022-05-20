package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Board
{

    Card[][] positions = new Card[4][4];
    final EmptyCard EMPTY_CARD = new EmptyCard();

    /**
     * Constructs an object containing the game board
     */
    public Board() {}

    public boolean isFree(int row, int col) {
        return Objects.isNull(positions[row][col]);
    }

    /**
     * Places a card on the game board.
     * @param card The card to be placed
     * @param row The row (0-3) where the card goes
     * @param col The column (0-3) where the card goes
     * @throws IllegalArgumentException if the position provided is either invalid or already occupied
     */
    public void place(Card card, int row, int col) throws IllegalArgumentException{
        if (!(isFree(row,col))) {
            System.out.println("Couldn't place " + card + " at row="+row +", col=" + col);
            throw new IndexOutOfBoundsException();
        } else if (!(0 <= row && row <= 3)) {
            throw new IllegalArgumentException("cannot place card at row="+row);
        } else if (!(0 <= col && col <= 3)) {
            throw new IllegalArgumentException("cannot place card at col="+row);
        } else {
            try{
                positions[row][col] = card;
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Couldn't place card here (exception thrown");
            }
        }
    }

    /**
     * Generates the initial four corners of the game state
     * @param deck The deck of cards to draw the corner pieces from
     */
    public void placeInitialCards(ArrayList<Card> deck){
        for (int row = 0; row < 4; row++)
        {
            for (int col = 0; col < 4; col++)
            {
                Card cardToPlace;
                if (row==0&&col==0 || row==0&&col==3 || row==3&&col==0 || row==3&&col==3) {
                    cardToPlace = deck.remove(0);
                    place(cardToPlace, row, col);
                } else {
                    cardToPlace = EMPTY_CARD;
                }
                positions[row][col] = cardToPlace; // Place manually to avoid exception handling
            }
        }
    }

    @Override
    public String toString()
    {
        StringBuilder returnStr = new StringBuilder();

        for (int row = 0; row < 4; row++)
        {
            returnStr.append(Arrays.deepToString(positions[row])).append("\n");

        }

        return returnStr.toString();
    }

}
