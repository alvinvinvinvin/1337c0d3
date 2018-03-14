/**
 * A string S of lowercase letters is given. We want to partition this string into 
 * as many parts as possible so that each letter appears in at most one part, 
 * and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.
 */
package partitionLabels;

import java.io.*;
import java.util.*;

/**
 * @author e007777
 *
 */
public class Solution {
	public static List<Integer> partitionLabels(String S) {
        int[] all = new int[26];
        int total_all = S.length();
        for(int i = 0; i<total_all; i++){
            all[S.charAt(i)-'a']++;
        }
        
        int[] bus = new int[26];
        for(int i = 0; i<26; i++){
        	bus[i] = -1;
        }
        int total_cur = 0;
        List<Integer> list_ebus_i = new ArrayList<Integer>();
        list_ebus_i.add(-1);
        for(int i = 0; i<total_all; i++){
            
            char c = S.charAt(i);
            int index = c-'a';
            
            if(bus[index] == -1){
                bus[index] = all[index] - 1;
                total_cur += bus[index];
            }else{
                bus[index]--;
                total_cur--;
            }
            if(total_cur == 0){
                list_ebus_i.add(i);
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        
        for(int i = 1; i<list_ebus_i.size(); i++){
            res.add(list_ebus_i.get(i)-list_ebus_i.get(i-1));
        }
        
        return res;
    }
	
	
	public static void main(String[] args) throws IOException {
        System.out.println("hello");
        String S = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(S).toString());
    }
}



