package containsDuplicate;

/**
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice 
 * in the array, and it should return false if every element is distinct.
 */
import java.util.HashSet;

public class Solution {
	public boolean containsDuplicate(int[] nums){
        if (nums.length == 0) return false;
        HashSet<Integer> numSet = new HashSet<Integer>();
        for(int n : nums) {
            if (!numSet.add(n)) return true;
        }
        return false;
	}
}
