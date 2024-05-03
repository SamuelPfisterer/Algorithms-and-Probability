# Beer Pong

You are playing a version of beer pong with two types of beer: ale and lager. There are $a$ cups of ale and $b$ cups of lager on the table, and you throw $n$ ping-pong balls one by one with the hope of getting each into one of the cups.

You start the game sober. When you are sober, each ball you throw has some probability $p$ of making it into one of the cups and probability $1-p$ of missing. That is, with probability $p$ the ping-pong ball lands in some cup of beer (we call this a success), and with probability $1-p$ it lands on the table or on the floor (we call this a fail). In case your throw is successful, the cup in which your ball lands is chosen uniformly at random among the cups on the table.

The version of beer pong you are playing is a bit different from the usual one: each time you throw a ping-pong ball and make it into one of the cups, you have to drink the contents of that cup, and afterwards that cup is removed from the game. Regardless of whether your throw was a success or a fail, you throw the next ping-pong ball aiming at the remaining cups on the table, until you throw all the $n$ balls. With each cup you drink you become less and less sober, and as a result your throwing skills decrease by a multiplicative factor of $f$ for some  $f \leq 1 $. This means that if at some point you had some probability $s$ of success, after drinking one cup of beer you have probability $f \cdot s$ of success until the next one you drink.

## Questions

1. What is the probability of drinking a cup of lager in the first throw?
2. Given that you drink a cup of lager in the second throw, what is the probability you drank a cup of ale in the first throw?
3. After throwing all $n$ balls, what is the probability that you drank a cup of lager at least $n-1$ times?
