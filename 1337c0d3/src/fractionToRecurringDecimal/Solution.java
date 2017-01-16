/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
Hint:

No scary math, just apply elementary math knowledge. Still remember how to perform a long division?
Try a long division on 4/9, the repeating part is obvious. Now try 4/333. Do you see a pattern?
Be wary of edge cases! List out as many test cases as you can think of and test your code thoroughly.

 */
package fractionToRecurringDecimal;

/**
 * @author hanchen
 *
 */
public class Solution {
	public static String fractionToDecimal(int numerator, int denominator) {
		if (denominator == 0)
	        return "NaN";
	    if (numerator == 0)
	        return "0";
	    StringBuilder result = new StringBuilder();
	    
	    Long n = new Long(numerator);
	    Long d = new Long(denominator);
	    // negative or positive
	    result.append((n>0) ^ (d>0) ? "-" : "");
	    
	    n = Math.abs(n);
	    d = Math.abs(d);
	    result.append(Long.toString(n / d));
	    // result is integer or float
	    if (n % d == 0)
	        return result.toString();
	    else
	        result.append(".");
	    
	    return result.toString();
    }
	
	public static void main(String... args){
		System.out.println(fractionToDecimal(1,6));
	}
}
