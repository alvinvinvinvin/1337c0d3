/**
 * Suppose Andy and Doris want to choose a restaurant for dinner, 
 * and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least 
list index sum. If there is a choice tie between answers, output all of 
them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is 
"Shogun" with index sum 1 (0+1).
Note:
The length of both lists will be in the range of [1, 1000].
The length of strings in both lists will be in the range of [1, 30].
The index is starting from 0 to the list length minus 1.
No duplicates in both lists.
 */
package minimumIndexSumOfTwoLists;

import java.util.*;

/**
 * @author han.chen
 *
 */
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int l1 = list1.length;
        int l2 = list2.length;
        if(l1 == 0 || l2 == 0) return new String[0];
        int mini_sum = Integer.MAX_VALUE;
        List<String> res = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i<l1;i++) map.put(list1[i], i);
        for(int i = 0; i<l2;i++){
        	Integer j = map.get(list2[i]);
        	if(j != null){
            	int sum = i+j;
            	if(sum > mini_sum) continue;
            	if(sum < mini_sum){
            		res = new ArrayList<String>();
            		mini_sum = sum;
            	}
        		res.add(list2[i]);
        	}
        }      
        return res.toArray(new String[res.size()]);
    }
    
}
