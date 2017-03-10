/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False
Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
package detectCAPITAL;

/**
 * The thought here is that the problem is similar with counting votes problem
 * at least this thought is subset of it. It smartly used the relations between the
 *  number of Capital Characters, the index of the cap char, and the length of
 *  the string to deconstruct the problem instead of checking the character one by one. 
 * @author han.chen
 *
 */
public class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        int len = word.length();
        for(int i = 0; i<len; i++){
            if(Character.isUpperCase(word.charAt(i))) count++;
        }
        if(count == 1) return Character.isUpperCase(word.charAt(0));
        return count == 0 || count == len;
    }
}
