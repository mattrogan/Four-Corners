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
