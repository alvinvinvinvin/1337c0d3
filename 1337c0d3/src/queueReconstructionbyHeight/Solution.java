/**
 * Suppose you have a random list of people standing in a queue. 
 * Each person is described by a pair of integers (h, k), where h is the height of 
 * the person and k is the number of people in front of this person who have a height 
 * greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
package queueReconstructionbyHeight;

import java.util.*;

/**
 * @author e007777
 *
 */
public class Solution {
	public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        if(people == null || people.length == 0 || people[0] ==null ||people[0].length == 0) return people;
        SortedMap<Integer, TreeSet<int[]>> map = new TreeMap<Integer, TreeSet<int[]>>();
        for(int i = 0; i<n; i++){
            int key = people[i][1];
            TreeSet<int[]> tmp;
            if(map.containsKey(key)){
                tmp = map.get(key);
            }else{
            	tmp = new TreeSet<int[]>();
            }
            
        	tmp.add(people[i]);
            map.put(key, tmp);
        }
        int[][] res = new int[n][2];
        
        for(Map.Entry e:map.entrySet()){
        	int key = (int)e.getKey();
        	ArrayList<int[]> tmp = (ArrayList<int[]>) e.getValue();
        	Collections.sort(tmp, (arr1, arr2) -> arr1[0]- arr2[0]);
        	map.put(key, tmp);
        }
        
        ArrayList<int[]> res_list = map.get(0);
        
        for(Map.Entry e:map.entrySet()){
        	int key = (int)e.getKey();
        	if(key == 0) continue;
        	ArrayList<int[]> tmp = (ArrayList<int[]>) e.getValue();
        	for(int i = 0; i<tmp.size();i++){
        		int[] arr = tmp.get(i);
        		int index = arr[1];
        		res_list.add(index, arr);
        	}
        }
        
        return res;
        
	}
    
//    public void sort(Collection data, Comparator<T>){
//        
//    }
}
