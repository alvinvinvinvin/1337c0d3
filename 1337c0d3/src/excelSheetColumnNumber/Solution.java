/**
 * Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 */
package excelSheetColumnNumber;

/**
 * @author hanchen
 *
 */
public class Solution {
	public int titleToNumber(String s) {
        char[] sChars = s.toCharArray();
        int result = 0;
        for(char c: sChars){
            result = result * 26 + ((int)c - 'A' + 1);
        }
        return result;
    }
}
