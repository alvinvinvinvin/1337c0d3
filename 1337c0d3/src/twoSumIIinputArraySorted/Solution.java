/**
 * Given an array of integers that is already 
 * sorted in ascending order, find two numbers 
 * such that they add up to a specific target number.

The function twoSum should return indices of 
the two numbers such that they add up to the target, 
where index1 must be less than index2. Please note 
that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly 
one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */
package twoSumIIinputArraySorted;

public class Solution {
	public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int n = numbers.length;
        int i = 0;
        int left = 0;
        int right = n-1;
        //Exclude the numbers greater than target
        while(left < right && right - left > 1){
            i = (left+right)>>1;
            if(numbers[i]>target) right = i;
            else if(numbers[i]<target) left = i;
            else break;
        }
        //Find combination
        left = 0; right = i+1;
        while(left < right){
            if((target - numbers[left]) < numbers[right]){
                right--;
            }else if((target - numbers[left]) > numbers[right]){
                left++;
            }else{
                res[0] = left+1;
                res[1] = right+1;
                break;
            }
        }
        return res;
    }
}
