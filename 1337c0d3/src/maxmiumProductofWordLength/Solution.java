/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. 
 * You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
 */
package maxmiumProductofWordLength;

/**
 * @author alvin
 *
 */
public class Solution {
	public int maxProduct(String[] words) {
        int nLength = words.length;
        int [] words_bit = new int [nLength];
        int [] lenList = new int [nLength];
        int i=0;
        int C = 1;
        for(String tmp:words){
            for(char cTmp:tmp.toCharArray()){
                words_bit[i] |=(C<<(int)(cTmp-'a'));
                //Representing each word as 1 with series of 0s following that 1;
                //i.e. 'b' will be 10, 'f' will be 100000. Then we use OR to combine all those bits together. So it's
                //sort of like use 1 to represent the corresponding position of each character. So for example, 'cab'
                //will be like "111".
            }
            lenList[i] = tmp.length();//Get each length here
            i++;
        }
        int max = 0;
        for(i=0;i<nLength;i++){
            C = (int)Math.sqrt(max);//Get square root for easier comparison.
            for(int j=i+1;j<nLength;j++){
                if ((lenList[i]>C||lenList[j]>C)&&((words_bit[i]&words_bit[j])==0)) {
                    max=Math.max(max, lenList[i]*lenList[j]);
                }
            }
        }
        return max;
    }
}
