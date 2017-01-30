/**
 * Casablanca’s hippodrome is organizing a new type of 
 * horse racing: duals. During a dual, only two horses 
 * will participate in the race. In order for the race to 
 * be interesting, it is necessary to try to select two horses with similar strength.

Write a program which, using a given number of strengths, 
identifies the two closest strengths and shows their difference with an integer (≥ 0).
 	Game Input

Input
Line 1: Number N of horses

The N following lines: the strength Pi of each horse. Pi is an integer.

Output
The difference D between the two closest strengths. 
D is an integer greater than or equal to 0.

Constraints

1 < N  < 100000
0 < Pi ≤ 10000000

Example

Input

3
5
8
9

Output

1
 */
package horseRacingDuals;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author han.chen
 *
 */
/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            numbers[i] = pi;
        }
        in.close();
        Arrays.sort(numbers);
        if(numbers.length == 1){
        	System.out.println(numbers[0]);
        	return;
        }
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i+1 < numbers.length; i++){
    		diff = Math.min(diff, Math.abs(numbers[i+1]-numbers[i]));
        }

        System.out.println(diff);
    }
}
