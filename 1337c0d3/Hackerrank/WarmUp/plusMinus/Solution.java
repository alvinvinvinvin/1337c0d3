/**
 * Given an array of integers, 
 * calculate which fraction of its elements are positive, 
 * which fraction of its elements are negative, 
 * and which fraction of its elements are zeroes, 
 * respectively. Print the decimal value of each fraction on a new line.

Note: This challenge introduces precision problems. 
The test cases are scaled to six decimal places, 
though answers with absolute error of up to  are acceptable.

Input Format

The first line contains an integer, , 
denoting the size of the array. 
The second line contains  space-separated integers describing an array of numbers .

Output Format

You must print the following  lines:

A decimal representing of the fraction of positive numbers in the array.
A decimal representing of the fraction of negative numbers in the array.
A decimal representing of the fraction of zeroes in the array.
Sample Input

6
-4 3 -9 0 4 1         
Sample Output

0.500000
0.333333
0.166667
Explanation

There are  positive numbers,  negative numbers, and  zero in the array. 
The respective fractions of positive numbers, 
negative numbers and zeroes are ,  and , respectively.
 */
package WarmUp.plusMinus;

import java.util.*;
import java.text.DecimalFormat;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n < 0) {
        	sc.close();
        	return;
        }
        if(n == 0){
            System.out.println(0);
            sc.close();
            return;
        }

        double numOfPos=0,numOfNeg=0,numOfZero=0;
        for(int i=0; i<n ;i++){
            int number = sc.nextInt();
            if(number > 0) numOfPos += 1;
            if(number < 0) numOfNeg += 1;
            if(number == 0) numOfZero += 1;
        }
        sc.close();
        DecimalFormat df = new DecimalFormat("0.000000");
        String numOfZeroStr = df.format(numOfZero/n) ;
        String numOfPosStr = df.format(numOfPos/n);
        String numOfNegStr = df.format(numOfNeg/n);
        System.out.println(numOfPosStr+"\n"+numOfNegStr+"\n"+numOfZeroStr);
    }
}
