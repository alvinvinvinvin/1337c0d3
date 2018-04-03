/**
 * 
 */
package minStack;

import java.util.*;

/**
 * @author e007777
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack min = new MinStack();
		min.push(1);
		print(min.pop());
		min.push(2);
		min.push(3);
		print(min.min());
		min.push(1);
		print(min.min());
		

	}
	
	public static void print(Object o){
		System.out.println(o.toString());
	}
	

}


