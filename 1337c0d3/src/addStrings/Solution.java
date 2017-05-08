/**
 * Given two non-negative integers num1 
 * and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger 
library or convert the inputs to integer directly.
 */
package addStrings;

/**
 * @author han.chen
 *
 */
public class Solution {

	public static String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        if(n1>n2) return helper(num1,num2);
        return helper(num2, num1);
    }
    
    public static String helper(String longer, String shorter){
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int j = shorter.length()-1;
        for(int i = longer.length()-1;i>=0;i--,j--){
            int l = Character.getNumericValue(longer.charAt(i));
            int s = j>=0?Character.getNumericValue(shorter.charAt(j)):0;
            int temp = l+s+carry;
            sb.insert(0,temp%10);
            carry = temp/10;
            if(j<0 && carry == 0){
                return longer.substring(0,i)+sb.toString();
            }
        }
        if(carry == 1) sb.insert(0,1);
        return sb.toString();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "9193";
		String s2 = "7";
		System.out.println(addStrings(s1,s2));
	}

}
