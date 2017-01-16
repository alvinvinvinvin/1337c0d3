/**
 * You are given an array of  integers, , 
 * and a positive integer, . 
 * Find and print the number of pairs where  and  +  is evenly divisible by .

Input Format

The first line contains  space-separated integers,  and , respectively. 
The second line contains  space-separated integers describing the respective values of .

Constraints

Output Format

Print the number of  pairs where  and  +  is evenly divisible by .

Sample Input

6 3
1 3 2 6 1 2
Sample Output

 5
Explanation

Here are the  valid pairs:

***
*Notice that the number of n is only between 0 to 100.
*It's a small case therefore we only need brutal loop.
***
 */
package Implementation.divisibleSumPairs;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        in.close();
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j<n; j++){
                if((a[i] + a[j])%k == 0){
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
