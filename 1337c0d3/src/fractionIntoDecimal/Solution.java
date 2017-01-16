/**
 * Given two integers representing 
 * the numerator and denominator of a fraction, 
 * return the fraction in string format.

If the fractional part is repeating, 
enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
Hint:

No scary math, just apply elementary math knowledge. 
Still remember how to perform a long division?
Try a long division on 4/9, the repeating part is obvious. 
Now try 4/333. Do you see a pattern?
Be wary of edge cases! 
List out as many test cases as you can think of and test your code thoroughly.
 */
package fractionIntoDecimal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author han
 *
 */
public class Solution {
	
	public static void main(String... args){
		System.out.println(fractionIntoDecimal(3,700));
	}
	
	public static String fractionIntoDecimal(int numerator, int denominator){
		StringBuilder result = new StringBuilder();
		if(denominator == 0) return "";
		if(numerator == 0) return 0+"";
		result.append((denominator>0) ^ (numerator > 0)	? "-":"");
		
		long n = Math.abs(numerator);
		long d = Math.abs(denominator);
		
		result.append(n/d+"");
		
		if(n%d == 0){
			return result.toString();
		}
		
		result.append(".");
		
		long r = n%d;
		Map<Long, Integer> tmp = new HashMap<Long,Integer>();
		int len = result.length();
		while(r>0){
			if(tmp.containsKey(r)){
				result.insert(tmp.get(r), "(");
				result.append(")");
				break;
			}
			tmp.put(r, len);
			r*=10;
			result.append(r/d+"");
			len++;
			r %= d;
		}
		
		return result.toString();
	}
}
