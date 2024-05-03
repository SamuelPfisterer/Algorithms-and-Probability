# Finite Slot Machine

No visit to Algoland can go without spending a few bucks at a casino, trying to win millions, but mostly just having fun with friends. This time, you find yourself in front of an unusual finite slot machine.

The finite slot machine has a finite set of values $1,...,n$ it can display. Before each game the machine chooses a finite number of cards, each card with one of the values written on it. It then provides you with the information on how many times each of the values appears among these cards. When you pull the lever for the first time, a card chosen uniformly at random from these shows up on the display.

Every following time you pull the lever, a new card chosen uniformly at random among the remaining ones replaces the card previously shown on the display. If the value on the new card is equal to the previously displayed value, you win the game! However, if the new value is smaller than the previously displayed value, you lose the game. Lastly, if the new value is larger than the previous value, the game continues with this new card as the one on the display (recall, the old one is substituted and thrown away). You then have to pull the lever again.

You sit down, insert your coin, and the finite slot machine starts flashing. After a series of random-looking flashes, it chooses its cards and lets you know about its choices. Armed with this information, can you determine what is the probability of you winning this particular game?
