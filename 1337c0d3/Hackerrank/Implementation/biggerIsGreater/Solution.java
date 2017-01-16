/**
 * Given a word , rearrange the letters of  
 * to construct another word  in such a way 
 * that  is lexicographically greater than . 
 * In case of multiple possible answers, find 
 * the lexicographically smallest one among them.

Input Format

The first line of input contains , the number of 
test cases. Each of the next  lines contains .

Constraints

 will contain only lower-case English letters and 
 its length will not exceed .
Output Format

For each testcase, output a string lexicographically 
bigger than  in a separate line. In case of multiple 
possible answers, print the lexicographically smallest 
one, and if no answer exists, print no answer.

Sample Input

5
ab
bb
hefg
dhck
dkhc
Sample Output

ba
no answer
hegf
dhkc
hcdk
Explanation

Test case 1: 
There exists only one string greater than ab which can be built by rearranging ab. That is ba.
Test case 2: 
Not possible to rearrange bb and get a lexicographically greater string.
Test case 3: 
hegf is the next string lexicographically greater than hefg.
Test case 4: 
dhkc is the next string lexicographically greater than dhck.
Test case 5: 
hcdk is the next string lexicographically greater than dkhc.


Inspired Content: http://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 */
package Implementation.biggerIsGreater;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. 
        Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] inputStrs = new String[n];
        for(int i = 0; i<n; i++){
            inputStrs[i] = next_permutation(sc.nextLine().trim());
        }
        sc.close();
        for(String s:inputStrs){
            System.out.println(s);
        }
        
    }
    
    static String next_permutation(String input){
        String res = "no answer";
        char[] inputStr = input.toCharArray();
        int i = inputStr.length-1;
        //Find the starting index of the last non-increasing substring
        while(i>0 && inputStr[i-1] >= inputStr[i]){
            i--;
        }
        //If the starting index doesn't exist, it means it is already
        //the last permutation. So we return "no answer";
        if(i<=0) return res;
        //Find the next greater char in that substring comparing to pivot,
        //which is charAt(i-1).
        int j = inputStr.length-1;
        while(inputStr[j] <= inputStr[i-1]){
            j--;
        }
        //Swap that char with pivot.
        char temp = inputStr[i-1];
        inputStr[i-1] = inputStr[j];
        inputStr[j] = temp;
        
        //Reverse substring
        j = inputStr.length-1;
        while(i<j){
            temp = inputStr[i];
            inputStr[i] = inputStr[j];
            inputStr[j] = temp;
            i++;
            j--;
        }
        res = new String(inputStr);
        return res;
    }
}
