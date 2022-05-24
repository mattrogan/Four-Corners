package app;

import java.util.ArrayList;
import java.util.Arrays;

public class Board
{

    Card[][] positions = new Card[4][4];
    final EmptyCard EMPTY_CARD = new EmptyCard();
    EmptyCard ACTIVATED_CARD = new EmptyCard();

    /**
     * Constructs an object containing the game board
     */
    public Board() { }

    public void placeInitialCards(ArrayList<Card> deck) {
        // Place corner cards
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                Card cardToPlace;
                if (row == 0 && col == 0 || row == 0 && col == 3 || row == 3 && col == 0 || row == 3 && col == 3) {
                    cardToPlace = deck.remove(0);
                } else {
                    cardToPlace = EMPTY_CARD;
                }
                positions[row][col] = cardToPlace; // Place manually to avoid exception handling
            }
        }

        // Activate surrounding places
        revise();
    }

    /** Predicate method to check whether a space on the board is free
     * @param row Row of position to check
     * @param col Column of position to check
     * @return true if the position is free, false otherwise
     */
    public boolean isFree(int row, int col) {
        if (positions[row][col] != null && positions[row][col].isEmptyCard()) {
            return ((EmptyCard) positions[row][col]).isPlaceable();
        } else {
            return false;
        }
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
            System.out.println("A card cannot be placed at row="+row +", col=" + col);
            throw new IndexOutOfBoundsException();
        } else if (!(0 <= row && row <= 3)) {
            throw new IllegalArgumentException("cannot place a card at row="+row);
        } else if (!(0 <= col && col <= 3)) {
            throw new IllegalArgumentException("cannot place a card at col="+row);
        } else {
            try{
                positions[row][col] = card;
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Couldn't place card here (exception thrown");
            }
        }
    }

    /** Gets the card at the position (row, col) of the board
     * @param row The row of the card to get
     * @param col The column of the card to get
     * @return The card at (row, col)
     */
    public Card get(int row, int col) { return positions[row][col]; }

    /** Method to revise the state of the board
     *
     * @return true if revision successful, false otherwise
     */
    public boolean revise() {
        // Iterate through each space on the board
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                Card c = get(row, col);
                if (!(c.isEmptyCard())) {
                    reviseIndividualSpace(row, col);
                }
            }
        }
        return true;
    }

    /** Revise the neighbours of an individual space
     * @param row Row of space to revise
     * @param col Column of space to revise
     * @return true if revision successful, false otherwise
     */
    public boolean reviseIndividualSpace(int row, int col) {
        ArrayList<Integer> neighbours = new ArrayList<Integer>();
        neighbours.add(-1); neighbours.add(0); neighbours.add(1);

        for (int i : neighbours)
        {
            for (int j : neighbours)
            {
                int rowToActivate = row + i;
                int colToActivate = col + j;
                if (rowToActivate>=0 && rowToActivate<=3 && colToActivate>=0 && colToActivate<=3 && i!=j && i!=-j && -i!=j) {
                    // Activate card at position [rowToActivate][colToActivate]
                    EmptyCard activatedCard = new EmptyCard();
                    activatedCard.activateSpace();
                    positions[rowToActivate][colToActivate] = activatedCard;
                }
            }
        }

        return true;
    }



    public void display()
    {
        System.out.println("The current state of the game board is...\n"+toString());
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
