/**
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
 */
package intersectionOfTwoArrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hanchen
 * Using two sets to get rid of duplicates in result collection.
 */
public class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> tmp = new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        for(int i: nums1) tmp.add(i);
        for(int j: nums2){
            if(tmp.contains(j)){
                res.add(j);
            }
        }
        int i = 0;
        int[] intersec = new int[res.size()];
        for(Integer num:res){
            intersec[i++] = num;
        }
        return intersec;
    }
}
