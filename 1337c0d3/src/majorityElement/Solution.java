package majorityElement;
/**
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.

	You may assume that the array is non-empty and 
	the majority element always exist in the array.
	
	Algorithm using: Boyer–Moore majority vote algorithm 
	https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
	http://www.cs.utexas.edu/~moore/best-ideas/mjrty/
	https://www.youtube.com/watch?v=FwyW61Bm2O8
	
	NOTE!: according to assumption, 
	we don't need to check whether the number of "candidate" is greater than nums.length/2. OW
	we have to iterate the array again to ensure that.
 * @author alvin
 *
 */
public class Solution {
	public int majorityElement(int[] nums) {
        int candidate = nums[0], vote = 0;
        for(int i : nums){
            if(vote == 0){
                candidate = i;
                vote = 1;
            }else if(candidate == i){
                vote ++;
            }else{
                vote --;
            }
        }
        return candidate;
    }
}
