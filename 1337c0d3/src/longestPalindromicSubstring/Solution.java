/**
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
 */
package longestPalindromicSubstring;

import java.util.*;

/**
 * @author e007777
 *
 */
public class Solution {

	public String longestPalindrome(String s) {
		int len = s.length();
		if(len == 0 || len == 1) return s;
        Stack<Character> stack = new Stack<Character>();
        int count = 1,res = 1;
        for(int i = 0; i<len;i++){
        	char c = s.charAt(i);
        	if(!stack.isEmpty()){
        		char peek = stack.peek();
        		if(peek == c){
        			count++;
        		}else{
        			//if it is not same, but the count is still 1
        			if(count==1){
        				//there are more than 1 element in stack
        				if(stack.size()>1){
        					peek = stack.get(stack.size()-2);
        					if(peek == c){
        						count+=2;
        						stack.pop();
        						stack.pop();
        					}else{
        						
        					}
        				}else{
        					stack.push(c);
        				}
        			}
        			if(!stack.isEmpty()){
        				peek = stack.pop();
        				if(peek == c){
        					count++;
        				}
        			}
        		}
        	}else
    		stack.push(c);
        	
        }
		return s;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
