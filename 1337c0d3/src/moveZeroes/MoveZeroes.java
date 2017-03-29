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
		Solution2 s2 = new Solution2();
		int[] test = {0,0,1,0,3,12};
		int[] test2 = {1,0};
		int[] test3 = {0,0,1,0,3,12};
		//test = test2;
		s.moveZeroes(test);
		s2.moveZeros(test3);
		printArray(test);
		printArray(test3);

	}
	
	static void printArray(int[] a){
		for(int i : a){
			System.out.print(i+", ");
		}
		System.out.println();
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
	
	static class Solution2{
		public void moveZeros(int[] nums){
			if(nums.length == 0 || nums == null) return;
			int most_left_0 = -1;
			for(int i = 0; i<nums.length;i++){
				if(nums[i] != 0){
					if(most_left_0 != -1){
						nums[most_left_0] = nums[i];
						nums[i] = 0;
						most_left_0++;
					}
				}else{
					if(most_left_0 == -1){
						most_left_0 = i;
					}
				}
			}
		}
	}
	
	static class Solution3{
		public void moveZeros(int[] nums){
			if(nums.length == 0 || nums == null) return;
			int most_left_0 = -1;
			for(int i = 0; i<nums.length;i++){
				if(nums[i] == 0){
					most_left_0 = i;
					break;
				}
			}
			if(most_left_0 == -1) return;
			
			for(int j = most_left_0+1; j<nums.length; j++){
				if(nums[j] != 0){
					nums[most_left_0] = nums[j];
					nums[j] = 0;
					most_left_0++;
				}
			}
		}
	}

}
