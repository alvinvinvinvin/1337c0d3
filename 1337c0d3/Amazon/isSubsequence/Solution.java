/**
 * Implement the following function. 
 * The goal of this function is to return true 
 * if the first string is a subsequence of the second.

ABC
A XXXX B X B XXC C CXA
A      B       C
 */
package isSubsequence;

public class Solution {
	boolean isSubsequence(String first, String second) {
	    if(first.length() > second.length()) return false;
	    int count = -1;
	    boolean flag = false;
	    for(int i = 0; i< first.length(); i++){
	        flag = false;
	        for(int j = count+1; j<second.length(); j++){
	            if(second.charAt(j) == first.charAt(i)){
	                count = j;
	                flag = true;
	                break;
	            }
	        }
	        if(!flag) return flag;
	    }
	    return flag;
	}
}
