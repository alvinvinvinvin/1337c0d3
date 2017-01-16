/**
 * 
 */
package moveZeroes;


/**
 * @author hanchen
 *Given an array nums, write a function to move all 
 *0's to the end of it while maintaining the relative order of the non-zero elements.

 *For example, given nums = [0, 1, 0, 3, 12], after calling your function,
 * nums should be [1, 3, 12, 0, 0].

 *Note:
 *You must do this in-place without making a copy of the array.
 *Minimize the total number of operations.
 */
public class MoveZeroes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] test = {0,0,1,0,3,12};
		int[] test2 = {1,0};
		test = test2;
		s.moveZeroes(test);
		printArray(test);

	}
	
	static void printArray(int[] a){
		for(int i : a){
			System.out.print(i+", ");
		}
	}
	
	static class Solution {
		public void moveZeroes(int[] nums) {
	    	int mark = 0;
	        for(int i = 0; i<nums.length; i++){
	            if(nums[i] == 0){
	                for(int j = mark+1;j<nums.length;j++){
	                    if(nums[j] != 0){
	                        swap(nums, i, j);
	                        mark = j;
	                        break;
	                    }
	                }
	            }else{
	                mark = i;
	            }
	        }
	    }
	    
	    public void swap(int[] nums, int left, int right){
	        int temp;
	        temp = nums[left];
	        nums[left] = nums[right];
	        nums[right] = temp;
	    }
	}

}
