/**
 *  	The Goal

Batman will look for the hostages on a given building by 
jumping from one window to another using his grapnel gun. 
Batman's goal is to jump to the window where the hostages 
are located in order to disarm the bombs. Unfortunately he 
has a limited number of jumps before the bombs go off...
 	Rules

Before each jump, the heat-signature device will provide 
Batman with the direction of the bombs based on Batman current position: 
U (Up)
UR (Up-Right)
R (Right)
DR (Down-Right)
D (Down)
DL (Down-Left)
L (Left)
UL (Up-Left)

Your mission is to program the device so that it indicates 
the location of the next window Batman should jump to in 
order to reach the bombs' room as soon as possible.

Buildings are represented as a rectangular array of windows, 
the window in the top left corner of the building is at index (0,0).
 	Note

For some tests, the bombs' location may change from one 
execution to the other: the goal is to help you find the best algorithm in all cases.

The tests provided are similar to the validation tests used 
to compute the final score but remain different.
 	Game Input

The program must first read the initialization data from 
standard input. Then, within an infinite loop, read the device 
data from the standard input and provide to the standard 
output the next movement instruction.
Initialization input
Line 1 : 2 integers W H. The (W, H) couple represents the 
width and height of the building as a number of windows.

Line 2 : 1 integer N, which represents the number of jumps 
Batman can make before the bombs go off.

Line 3 : 2 integers X0 Y0, representing the starting position of Batman.

Input for one game turn
The direction indicating where the bomb is.
Output for one game turn
A single line with 2 integers X Y separated by a space character. 
(X, Y) represents the location of the next window Batman should 
jump to. X represents the index along the horizontal axis, Y 
represents the index along the vertical axis. (0,0) is located 
in the top-left corner of the building.
Constraints
1 ≤ W ≤ 10000
1 ≤ H ≤ 10000
2 ≤ N ≤ 100
0 ≤ X, X0 < W
0 ≤ Y, Y0 < H
Response time per turn ≤ 150ms
Response time per turn ≤ 150ms
 */
package shadowsOfTheKnightEpisode1;

import java.util.Scanner;

/**
 * @author han.chen
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	 public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int W = in.nextInt(); // width of the building.
		int H = in.nextInt(); // height of the building.
		int N = in.nextInt(); // maximum number of turns before game over.
		int X0 = in.nextInt();
		int Y0 = in.nextInt();
		int X_max = W-1;
		int Y_max = H-1;
		int X_min = 0;
		int Y_min = 0;
		// game loop
		while (true) {
		    String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
		
			// Write an action using System.out.println()
			// To debug: System.err.println("Debug messages...");
			
			// have to detect round trip
			
			// the location of the next window Batman should jump to.
			if(bombDir.indexOf("U")>-1){
				Y0 = (Y_min+Y0)%2 == 0?(Y_min+Y0)/2 : (Y_min+Y0)/2+1;
				Y_max = Y0;
			}
			if(bombDir.indexOf("D")>-1){
			    Y0 = (Y_max+Y0)%2 == 0?(Y_max+Y0)/2 : (Y_max+Y0)/2+1;
				Y_min = Y0;
				
			}
			if(bombDir.indexOf("R")>-1){
			    X0 = (X_max+X0)%2 == 0?(X_max+X0)/2 : (X_max+X0)/2+1;
				X_min = X0;
			
			}
			if(bombDir.indexOf("L")>-1){
			    X0 = (X_min+X0)%2 == 0?(X_min+X0)/2 : (X_min+X0)/2+1;
				X_max = X0;
			}
			
			System.err.println("X_min: "+X_min+" Y_min: "+Y_min+" X_max: "+X_max+" Y_max: "+Y_max);
			
			System.out.println(X0+" "+Y0);
		}
	 }
	 

}
