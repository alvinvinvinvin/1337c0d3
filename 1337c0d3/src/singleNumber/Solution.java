package singleNumber;   
/**   
* Filename:    Solution.java   
* Copyright:   Copyright (c)2014  
* Company:   UWL
* @author: Han Chen
* @version:    1.0   
* @since:  JDK 1.7
* Create at:   Oct 31, 2014 2:16:16 PM   
* Description:  
*   Find the single number from an existed integer array.
*   Using exclusive OR.
* Modification History:   
* Date    Author      Version     Description   
* ----------------------------------------------------------------- 
* Oct 31, 2014 Han Chen      1.0     1.0 Version   
*/   
public class Solution {
	public static void main(String[] args){
		int[] test = {2,1,4,5,4,2,1,7,9,0,4,4,9,0,7,8,8,1,6,6,1};
		System.out.println(method2(test));
	}
	
	private static int singleNumber(int[] A){
		int result = 0;
		for(int i=0;i<A.length;i++){
			result ^= A[i];
		}
		return result;
	}
	
	private static int method2(int[] nums){
		int result = 0;
        for(int i:nums) result ^= i;
        return result;
	}
}
 