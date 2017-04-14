/**
 * Given a string which consists of 
 * lowercase or uppercase letters, find the 
 * length of the longest palindromes that can 
 * be built with those letters.

This is case sensitive, for example "Aa" is not 
considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", 
whose length is 7.
 */
package longestPalindrome;

import java.util.HashSet;

/**
 * @author han.chen
 *
 */
public class Solution {
	
	public static int longestPalindrome(String s) {
		int n = s.length();
        if(n == 1) return 1;
        int[] alphabet = new int[52];
        char temp = 'a';
        int offset = 0;
        for(int i =0;i<n;i++){
            char c = s.charAt(i);
            if(c-'a'>=0){
                temp = 'a';
                offset = 26;
            }else{
                temp = 'A';
                offset = 0;
            }
            alphabet[c-temp+offset]++;
        }
        int max = 0;
        int res = 0;
        int offset1 = 0;
        for(int i = 0; i<52;i++){
        	
            if(alphabet[i]>0){
                if(alphabet[i]%2 == 0){
                    res += alphabet[i];
                }else{
                	if(alphabet[i]>1){
                		res += alphabet[i]-1;
                	}
                	offset1 = 1;
                }
            }
        }
        return res+offset1;
    }
	
	
	public static int longestPalindrome2(String s) {
		int n = s.length();
		if(n == 0 || n == 1) return n;
        int[] table = new int[123];
        for(char c:s.toCharArray()){
        	table[c]++;
        }
        int res = 0;
        for(int j = 65;j<123;j++){
        	int i = table[j];
        	res += i%2 == 0?i:i-1;
        }
        return res == n?res:res+1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		System.out.println("Output: "+longestPalindrome2(s));
		System.out.println("Expected: 983");
		
	}

}
