/**
 * Given an array of N integers, can you find the sum of its elements?

Input Format

The first line contains an integer, N, denoting the size of the array. 
The second line contains N space-separated integers representing the array's elements.

Output Format

Print the sum of the array's elements as a single integer.

Sample Input

6
1 2 3 4 10 11
Sample Output

31
Explanation

We print the sum of the array's elements, which is: 1+2+3+4+10+11=31.
 */
package WarmUp.simpleArraySum;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. 
         * Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n < 0){
        	scanner.close();
        	return;
        } 
        if(n == 0) System.out.println(0);
        int res = 0;
        for(int i = 0; i<n; i++){
            res += scanner.nextInt();
        }
        scanner.close();
        System.out.println(res);
    }
}
