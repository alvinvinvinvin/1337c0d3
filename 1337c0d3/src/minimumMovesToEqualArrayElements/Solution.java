/**
 * Given a non-empty integer array of size n, 
 * find the minimum number of moves required to 
 * make all array elements equal, where a move is 
 * incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
package minimumMovesToEqualArrayElements;

/**
 * @author han.chen
 * This is actually a mathematics question. Assume the current summary is
 * `sum`. After `m` steps moves, we got the final answer which is an array
 * with `n` equally elements `x`. So it should be like this:
 * [a1, a2, a3, a4, ..., an]	step 1
 * ...							after `m` steps
 * [x, x, x, x, ..., x]			step m
 * Since each step we add `n-1` `1`s to the `sum`, so the formula should be
 * like this:
 * 
 * sum + m * (n-1) = x * n;
 * 
 * Thinking about it, if we want every single number in the `nums` to become
 * to the `x`, what will happen on the minimum number in the `nums`?
 * 
 * It's not hard to figure that `x = minNum + m * 1`.
 * 
 * We combine these two formula together then we get:
 * 
 * sum - minNum * n = m;
 * 
 */
public class Solution {
	public int minMoves(int[] nums) {
        if(nums.length == 1) return 0;
        int min = nums[0];
        int sum = min;
        for(int i=1;i<nums.length;i++){
            sum += nums[i];//Adding numbers up
            if(nums[i]<min) min = nums[i];//Finding the minimum number
        }
        return sum-(min*nums.length);
    }
}
