package app;

import java.util.ArrayList;
import java.util.Arrays;

public class Board
{

    Card[][] positions = new Card[4][4];

    public Board(){}

    /**
     * @param deck Deck of cards to place from
     */
    public void placeInitialCards(ArrayList<Card> deck){
        positions[0][0] = deck.remove(0);
        positions[0][3] = deck.remove(0);
        positions[3][0] = deck.remove(0);
        positions[3][3] = deck.remove(0);
    }

    public boolean isOccupied(int row, int col) { return (positions[row][col] == null); }

    public void place(Card card, int row, int col) throws IllegalArgumentException{
        if (isOccupied(row, col)) {
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

                throw ex;
            }
        }
    }

    @Override
    public String toString()
    {
        String returnStr = "";

        for (int row = 0; row < 4; row++)
        {
                returnStr += Arrays.deepToString(positions[row]) + "\n";

        }

        return returnStr;
    }

}
