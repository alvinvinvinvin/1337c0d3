/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */
package excelSheetColumnTitle;

/**
 * @author hanchen
 *
 */
public class Solution {
	public String convertToTitle(int n) {
	       String result = "";
	       //Basically we treat letters as 26 digits number.
	       while(n != 0){
	    	   //65 is 'A'. 'n-1' is because
	    	   //the actual number of n is 1 greater
	    	   //than actual index of letter.
	           char bit = (char)((n-1)%26+65);
	           n = (n-1)/26;
	           result = bit + result;
	       }
	       return result;
	}
}
