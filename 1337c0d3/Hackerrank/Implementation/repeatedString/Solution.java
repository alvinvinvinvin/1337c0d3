/**
 * Lilah has a string, , of lowercase English letters that 
 * she repeated infinitely many times.

Given an integer, , find and print the number of letter a's 
in the first  letters of Lilah's infinite string.

Input Format

The first line contains a single string, . 
The second line contains an integer, .

Constraints

For  of the test cases, .
Output Format

Print a single integer denoting the number 
of letter a's in the first  letters of the 
infinite string created by repeating  infinitely many times.

Sample Input 0

aba
10
Sample Output 0

7
Explanation 0
The first  letters of the infinite string are abaabaabaa. 
Because there are  a's, we print  on a new line.

Sample Input 1

a
1000000000000
Sample Output 1

1000000000000
Explanation 1 
Because all of the first  letters of the infinite string are a, we print  on a new line.
 */
package Implementation.repeatedString;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        in.close();
        long l = (long)(s.length());
        long count_t = 0;
        long count_r = 0;
        long rem = n%l;
        char[] sChar = s.toCharArray();
        for(int i = 0; i< sChar.length;i++){
            if(sChar[i] == 'a') count_t++;
            if(i == rem-1){
                count_r=count_t;
            } 
        }

        count_t = count_t*(n/l)+count_r;

        System.out.println(count_t);
    }
}