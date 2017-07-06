/**
 * Given an integer (signed 32 bits), 
 * write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
 */
package powerOfFour;

/**
 * @author e007777
 *
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        return num>0 && Integer.highestOneBit(num) == num && Integer.numberOfTrailingZeros(num) % 2 == 0;
    }
}
