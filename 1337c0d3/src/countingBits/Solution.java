/**
 * Given a non negative integer number num. 
 * For every numbers i in the range 0 ≤ i ≤ num 
 * calculate the number of 1's in their binary 
 * representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with 
run time O(n*sizeof(integer)). But can you do it 
in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using 
any builtin function like __builtin_popcount in 
c++ or in any other language.

Hint:

1. You should make use of what you have produced already.
2. Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. 
And try to generate new range from previous.
3. Or does the odd/even status of the number help you in calculating the number of 1s?
 */

/**
 * -------2^0---------	section 1
 * 0	0	0	0=a		=a
 * 1	1	1	1=b		=b
 * -------2^1---------	1 + section1 = section2
 * 10	2	1	1+0		=1+a	=c
 * 11	3	2	1+1		=1+b	=d
 * -------2^2---------	1 + section1 + section2 = section3
 * 100	4	1	1+0		=1+a	=c
 * 101	5	2	1+1		=1+b	=d
 * 110	6	2	1+1+0	=1+c	=e
 * 111	7	3	1+1+1	=1+d	=f
 * -------2^3---------	1 + section1 + section2 + section3 = section4
 * 1000	8	1	1+0		=1+a	=c
 * 1001	9	2	1+1		=1+b	=d
 * 1010	10	2	1+1+0	=1+c	=e
 * 1011	11	3	1+1+1	=1+d	=f
 * 1100	12	2	1+1+0	=1+c	=e
 * 1101	13	3	1+1+1	=1+d	=f
 * 1110	14	3	1+1+1+0	=1+e	
 * 1111	15	4	1+1+1+1	=1+f
 * 
 * b(num) num r 1+x
 */
package countingBits;

/**
 * @author alvin
 *
 */
public class Solution {
	public int[] countBits(int num) {
	    if(num <=0) return new int[1];
	    int[] result = new int[num+1];//including 0
	    result[1] = 1;
	    int idx = 2, pwr2 = 2;
	    while(idx <= num){
	    	//if it points to the power of 2 like 2,4,8, then the number of 1's should be 1.
	        if(idx == pwr2){
	            pwr2 *= 2;
	            result[idx] = 1;	            
	        }else{
	        	/*
	        	 * 1 + previous result as shown in comment above.
	        	 * The problem is: How to locate to the previous index we want.
	        	 * Each section consists by the sum of each result of all previous sections + 1.
	        	 * Thus the pwr2 here represents the total number of results we will get.
	        	 * Then pwr2/2 represents the first index of current section.
	        	 * Then if we use current index to subtract the first index of current section,
	        	 * we are able to get the corresponding index in the sum of all previous section.
	        	 */
	            result[idx] = 1 + result[idx - pwr2/2];
	        }
	        idx ++;
	    }
	    return result;
	}
}
