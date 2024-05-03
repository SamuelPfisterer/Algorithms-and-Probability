Anthill
On a warm summer morning you find nothing better to do than to observe how ants move around in the grass. You see that ants move between 
 different intersections using a fixed set of two-way connections. After more careful observation, you realize that the connections between these intersections can either be in the shade or in the sun, and that the ants prefer the ones in the sun.

At some point, the ants reassemble at their anthill (intersection 
), but you still see their connections as trails in the grass. You realize that some of these connections lead to your lunch box (intersection 
)! As amusing as you find the ants, you are not willing to share your food with them. Thus, you have to destroy some of their connections to ensure they cannot reach your lunch box from their anthill.

You still want to be nice to the ants and be careful with how you destroy the connections. Above all, you want to minimize the number of connections in the sun that you destroy and so, you would rather destroy multiple (even all!) connections in the shade than one in the sun. As a second criterion, you would like to also destroy as few connections in the shade as possible. Therefore, if there are multiple ways to achieve your goal that would destroy the same number of connections in the sun, among them you would choose the one that would destroy the smallest number of connections in the shade.

Consider all possibilities of removing connections that would prevent the ants from going from their anthill (intersection 
) to your lunch box (intersection 
). What is the smallest number of connections in the sun among these possibilities? If there are multiple possibilities with the same (smallest) number of connections in the sun, what is the smallest number of connections in the shade among these?

Input
The first line of the input file contains a number 
 of test cases. Each of the 
 test cases is described as follows.

It starts with a line that contains three integers , separated by a space, denoting the number of intersections (), the number of connections in the sun (), and the number of connections in the shade ().
The following lines each describe a connection in the sun. Each such line contains two integers , separated by a space, denoting that there is a connection between intersections and (). This means that if this connection is not destroyed, ants can travel between and (in either direction).
The following lines each describe a connection in the shade. Each such line contains two integers , separated by a space, denoting that there is a connection between intersections and (). This means that if this connection is not destroyed, ants can travel between and (in either direction).
Output
For each test case output one line containing two integers separated by a space. The first integer is the smallest number of connections in the sun that have to be destroyed, possibly in combination with destroying some connections in the shade, to ensure that the ants cannot reach the lunch box (intersection ) from the anthill (intersection ). The second integer is the smallest number of connections in the shade that have to be destroyed among all possibilities which destroy the same (smallest) number of connections in the sun.

Points
There are two groups of test sets, worth points in total.

For the first group of test sets, worth points, you may assume that there are no connections in the sun ().
For the second group of test sets, worth points, there are no additional assumptions.
