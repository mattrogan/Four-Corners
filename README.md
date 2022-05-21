# Four Corners 🃏
This is an implementation of a game my friends and I played at university. I have very fond memories of playing this game, particularly in my first year!

## How the game works
Four Corners is a card game whereby you need to complete a 4x4 grid of cards.
- You start with 4 cards out in each of the four corners.
- You must then choose a position to place the card, either to the left, right, above, or below one of the cards laid out already (NB: you cannot go outside the bounds of the game space)
- You must also say whether the next card, placed from the deck, will be higher or lower.

## Rules
Once you've made your guess (whether the next card is higher or lower), it is placed and compared with the card it is next to.
- If your guess is **correct**, you choose another place to lay the next card. You need three correct guesses to end your turn and move to the next player
- If your guess is **incorrect**, you wipe out either the row/column (both if it's an intersection).
- You also pick up penalty points, calculated as the sum of the values of the card(s) you removed.
- If the card is a match (i.e. the next card is the same as the one you're placing next to), you double the penalty points
- Eliminating the entire 4x4 grid results in 16 penalty points (32 if the card is a match)

## How to win
The game is won once you have completed the 4x4 grid, although based on the rules of the game this is _very_ unlikely to happen.
