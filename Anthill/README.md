# Anthill

On a warm summer morning you find nothing better to do than to observe how ants move around in the grass. You see that ants move between different intersections using a fixed set of two-way connections. After more careful observation, you realize that the connections between these intersections can either be in the shade or in the sun, and that the ants prefer the ones in the sun.

At some point, the ants reassemble at their anthill (intersection 0), but you still see their connections as trails in the grass. You realize that some of these connections lead to your lunch box (intersection n-1)! As amusing as you find the ants, you are not willing to share your food with them. Thus, you have to destroy some of their connections to ensure they cannot reach your lunch box from their anthill.

You still want to be nice to the ants and be careful with how you destroy the connections. Above all, you want to minimize the number of connections in the sun that you destroy and so, you would rather destroy multiple (even all!) connections in the shade than one in the sun. As a second criterion, you would like to also destroy as few connections in the shade as possible. Therefore, if there are multiple ways to achieve your goal that would destroy the same number of connections in the sun, among them you would choose the one that would destroy the smallest number of connections in the shade.

Consider all possibilities of removing connections that would prevent the ants from going from their anthill (intersection 0) to your lunch box (intersection n-1). What is the smallest number of connections in the sun among these possibilities? If there are multiple possibilities with the same (smallest) number of connections in the sun, what is the smallest number of connections in the shade among these?

