/**
 * Given a List of words, return the words that can 
 * be typed using letters of alphabet on only one 
 * row's of American keyboard like the image below.


American keyboard



Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
Note:
You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.
 */
package keyboardRow;

import java.util.*;

/**
 * @author han.chen
 *
 */
public class Solution {
	
	public static void main(String... args){
		String[] words = {"Hello","Alaska","Dad","Peace"};
		String[] result = findWords(words);
		for(String r: result) System.out.println(r);
	}
	
	public static String[] findWords(String[] words) {
    	int l = words.length;
    	List<String> res = new LinkedList<String>();
        Set<Character> first_set = convertStrToCharSet("QWERTYUIOP");
        Set<Character> second_set = convertStrToCharSet("ASDFGHJKL");
        Set<Character> last_set = convertStrToCharSet("ZXCVBNM");
        
        for(int i = 0; i<l; i++){
        	boolean flag_break = false;
        	int n = words[i].length();
        	String temp = words[i].toUpperCase();
        	if(first_set.contains(temp.charAt(0))){
        		for(int j = 1; j<n;j++){
        			if(!first_set.contains(temp.charAt(j))){
        				flag_break = true;
        				break;
        			}
        		}
        		if(!flag_break) res.add(words[i]);
        		continue;
        	}
        	if(second_set.contains(temp.charAt(0))){
        		for(int j = 1; j<n;j++){
        			if(!second_set.contains(temp.charAt(j))){
        				flag_break = true;
        				break;
        			}
        		}
        		if(!flag_break) res.add(words[i]);
        		continue;
        	} 
        	if(last_set.contains(temp.charAt(0))){
        		for(int j = 1; j<n;j++){
        			if(!last_set.contains(temp.charAt(j))){
        				flag_break = true;
        				break;
        			}
        		}
        		if(!flag_break) res.add(words[i]);
        	}
        	
        }

        String[] output = new String[res.size()];
        output = res.toArray(output);
        return output;
        
    }
    
    static Set<Character> convertStrToCharSet(String input){
    	int n = input.length();
    	Set<Character> set = new HashSet<Character>();
    	for(int i = 0; i<n; i++){
    		set.add(new Character(input.charAt(i)));
    	}
    	return set;
    }
    
}
