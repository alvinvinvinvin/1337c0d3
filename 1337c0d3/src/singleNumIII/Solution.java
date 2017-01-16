package singleNumIII;

import java.util.HashSet;

/**
 * Given an array of numbers nums, in which exactly two 
 * elements appear only once and all the other elements appear exactly twice. 
 * Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * @author alvin
 *
 */

public class Solution {
	public int[] singleNumber(int[] nums) {
        HashSet<Integer> tmp = new HashSet<Integer>();
        for(int n: nums){
            if(tmp.contains(n)) tmp.remove(n);
            else tmp.add(n);
        }
        
        int[] result = new int[2];
        Object[] t = tmp.toArray();
        result[0] = Integer.parseInt(t[0].toString());
        result[1] = Integer.parseInt(t[1].toString());
        return result;
    }
}
