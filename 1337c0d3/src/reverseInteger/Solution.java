package reverseInteger;   
/**   
* Filename:    Solutition.java   
* Copyright:   Copyright (c)2014  
* Company:   UWL
* @author: Han Chen
* @version:    1.0   
* @since:  JDK 1.7
* Create at:   Nov 1, 2014 3:52:24 PM   
* Description:  
*   Reverse digits of an integer.
*	Example1: x = 123, return 321
*	Example2: x = -123, return -321
* Modification History:   
* Date    Author      Version     Description   
* ----------------------------------------------------------------- 
* Nov 1, 2014 Han Chen      1.0     1.0 Version   
*/     
public class Solution {
	
	public static void main(String[] args){
		System.out.println(reverse(-1999999999));
	}

	    public static int reverse(int x) {
	       		long output = 0;
	       		while(x !=0){
	       			output = output*10+x%10;
	       			x = x/10;
	       		}
	       		if(output<Integer.MIN_VALUE||output>Integer.MAX_VALUE){
	       			System.out.println("overflow");
	       			return 0;
	       		}
	       		return (int)output;
	    }
}
 