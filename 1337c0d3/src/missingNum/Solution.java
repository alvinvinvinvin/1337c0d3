/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
package missingNum;

public class Solution {
	 public int missingNumber(int[] nums) {
	        int n = nums.length;
	        int numOfNums = n * (n+1)/2;//Sum up the total number of numbers it SHOULD have. Since array always starts at 0 and its common difference is 1.
	        int sum = 0;
	        for(int i:nums) sum += i;//Get the sum of series numbers we actually got.
	        return numOfNums - sum;//The difference is the missing one.
	 }
}
