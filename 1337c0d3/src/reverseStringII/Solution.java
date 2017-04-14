/**
 * Given a string and an integer k, you need to 
 * reverse the first k characters for every 
 * 2k characters counting from the start of 
 * the string. If there are less than k characters left, 
 * reverse all of them. If there are less than 2k 
 * but greater than or equal to k characters, then 
 * reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
 */
package reverseStringII;

/**
 * @author han.chen
 *
 */
public class Solution {
	
	public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start = 0;
        int end = start + k-1;
        if(n<=k){
            end = n-1;
            reverse(chars, start, end);
            return String.valueOf(chars);
        }else if(n>=k && n<k*2){
            reverse(chars, start, k-1);
            return String.valueOf(chars);
        }else{
            while(start < n-1){
                reverse(chars, start, end);
                start += 2*k;
                end += 2*k;
                if(end> n - 1){
                	end = n-1;
                }
            }
            return String.valueOf(chars);
        }
        
    }
    
    public static void reverse(char[] chars, int start, int end){
        while(start<end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
		String expected = "fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqllgsqddebemjanqcqnfkjmi";
		int k = 39;
		System.out.println("Output: "+reverseStr(s,k));
		System.out.println("Expected: "+ expected);
		System.out.println(s.length());
	}

}
