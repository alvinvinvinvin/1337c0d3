package fibonacci;

/**
 * Input position number of fibonacci sequence, return the number on that position.
 * Position number start from 1.
 * Example
Given 1, return 0

Given 2, return 1

Given 10, return 34

Note
The Nth fibonacci number won't exceed the max value of signed 32-bit integer in the test cases.
 * @author alvin
 *
 */

public class Solution {
	/**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        int previous = 0, next = 1, result = 1;
        if(n == 1) return previous;
        if(n == 2) return next;
        
        for(int i = 2; i < n; i++){
            result = previous + next;
            previous = next;
            next = result;
        }
        return result;
    }
}
