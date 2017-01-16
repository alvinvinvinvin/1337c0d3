/**
 * Given a set, , of  distinct integers, 
 * print the size of a maximal subset, , 
 * of  where the sum of any  numbers in  are not evenly divisible by .

Input Format

The first line contains  space-separated integers,  and , respectively. 
The second line contains  space-separated integers 
(we'll refer to the  value as ) describing the unique values of the set.

Constraints

All of the given numbers are distinct.
Output Format

Print the size of the largest possible subset ().

Sample Input

4 3
1 7 2 4
Sample Output

3
Explanation

The largest possible subset of integers is , 
because no two integers will have a sum that is evenly divisible by :

, and  is not evenly divisible by .
, and  is not evenly divisible by .
, and  is not evenly divisible by .
The number  cannot be included in our subset 
because it will produce an integer that is evenly 
divisible by when summed with any of the other integers in our set:

, and .
, and .
, and .
Thus, we print the length of  on a new line, which is .
 */
package Implementation.non_divisibleSubSet;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. 
        Print output to STDOUT. Your class should be named Solution. */
    	Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] map = new int[k];
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            map[num%k] += 1;
        }
        sc.close();
        int count = 0;
        
        for(int i=0;i<k/2+1;i++){
            if(i == 0 || i == k-i){
                if(map[i] > 0) count += 1;
                else continue;
            }else{
                
                count +=  map[i] >= map[k-i] ? map[i] : map[k-i];
            }
        }       
        
        System.out.println(count);
        
    }
    
}
