/**
 * Given a time in AM/PM format, convert it to military (-hour) time.

Note: Midnight is  on a -hour clock, 
and  on a -hour clock. Noon is  on a -hour clock, and  on a -hour clock.

Input Format

A single string containing a time in -hour clock format (i.e.:  or ), where .

Output Format

Convert and print the given time in -hour format, where .

Sample Input

07:05:45PM
Sample Output

19:05:45
 */
package WarmUp.timeConversion;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. 
         * Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(input.length() == 0){
        	sc.close();
        	return;
        }
        sc.close();
        String output = "";
        String hhStr = input.substring(0,2);
        int hhInt = Integer.parseInt(hhStr);
        if(input.charAt(8) == 'P'){
            if(hhInt == 12){
                output = input.substring(0,8);
            }else
            output = (hhInt+12) + "" + input.substring(2,8);
        }else{
            if(hhInt == 12){
                output = "00" + input.substring(2,8);
            }else
            output = input.substring(0,8);
        }
        System.out.println(output);
    }
}
