/**
 * Consider a staircase of size :

   #
  ##
 ###
####
Observe that its base and height are both equal to , 
and the image is drawn using # symbols and spaces. 
The last line is not preceded by any spaces.

Write a program that prints a staircase of size .

Input Format

A single integer, , denoting the size of the staircase.

Output Format

Print a staircase of size  using # symbols and spaces.

Note: The last line must have  spaces in it.

Sample Input

6 
Sample Output

     #
    ##
   ###
  ####
 #####
######
Explanation

The staircase is right-aligned, composed of # 
symbols and spaces, and has a height and width of .
 */
package WarmUp.stairCase;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. 
         * Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int total = n*(n+1)-1;
        char[] str = new char[total];
        int i = 0;
        while(i<total){
        	int step=i/n;
        	int space_start = step*(n+1);
        	int space_end = (step+1)*n-1;
        	int newLine = step * n +(step -1);
        	if(i>= space_start && i < space_end){
        		str[i] = ' ';
        	} 
        	else if(i == newLine){
        		str[i] = '\n';	
        	}else str[i] = '#';
        	i++;
        }
        
        System.out.print(str);
    }
}
