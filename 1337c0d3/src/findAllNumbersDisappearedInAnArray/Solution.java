/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), 
 * some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? 
You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]


Similar to "find all duplicates in array". The difference is that even you
can find duplicate, you cannot say which number is missing, because this 
duplicate is possible to place any one.

The similar part is, as what "find all duplicates in array" assumed, the value
is actually the index. So we can use negative mark again here to mark the value(the index)
we have checked. If the corresponding value is positive, then we mark it to negative;
If it is already negative, we do nothing. Therefore, the value at the index which has never
been reached will be positive eventually, and they indicate that the corresponding 
index doesn't exist in this array.
 */
package findAllNumbersDisappearedInAnArray;

import java.util.*;

public class Solution {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new LinkedList<Integer>();
        int len = nums.length;
        for(int i = 0; i<len;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0)nums[index] = -nums[index];
        }
        for(int i = 0; i<len;i++){
            if(nums[i] > 0) list.add(i+1);
        }
        return list;
    }
}
