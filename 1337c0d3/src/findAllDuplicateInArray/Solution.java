/**
 * This is a special problem. The assumption is the key of it.
 * 
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), 
 * some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

If we want to solve it without extra space and in O(n) runtime, we have
to mark the number that we have been checked in original array, and more
importantly, we have to have a method to revert the marked number to its
original value. So the assumption should be our breakthrough.

As you can see here, the `1 ≤ a[i] ≤ n (n = size of array)`  and 
`some elements appear twice and others appear once` are the key.
So first, the numbers are all positive.
Second, the greatest number is the size of array at most.
Third, the duplicates at most appear twice.

So we have a way to mark the numbers which is using negative.

 */
package findAllDuplicateInArray;

import java.util.*;

public class Solution {
	public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new LinkedList<Integer>();
        for(int num:nums){
            int index = Math.abs(num)-1;
            /*
             * Matching the concept, we should use `list.add(Math.abs(num))`
             * here. But `index+1` in more efficient.
             */
            if(nums[index] < 0) list.add(index+1);
            nums[index] = -nums[index];
        }
        return list;
    }
	
	
}
