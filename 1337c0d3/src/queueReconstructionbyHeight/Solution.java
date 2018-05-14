/**
 * Suppose you have a random list of people standing in a queue. 
 * Each person is described by a pair of integers (h, k), where h is the height of 
 * the person and k is the number of people in front of this person who have a height 
 * greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.
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
        Map<Integer, ArrayList<int[]>> map = new HashMap<Integer, ArrayList<int[]>>();
        for(int i = 0; i<n; i++){
            int key = people[i][1];
            if(map.containsKey(key)){
                map.get(key).add(people[i]);
            }else{
            	ArrayList<int[]> tmp = new ArrayList<int[]>();
            	tmp.add(people[i]);
                map.put(key, tmp);
            }
        }
        for(Map.Entry e:map.entrySet()){
        	int key = (int)e.getKey();
        	ArrayList<int[]> tmp = (ArrayList<int[]>) e.getValue();
        	Integer[][] first = new Integer[tmp.size()][2];
        	first = tmp.toArray(first);
        	
        	Collections.sort(tmp, new Comparator<Integer[]>() {
                @Override
                public int compare(final Integer[] entry1, final Integer[] entry2) {
                    final Integer order1 = entry1[0];
                    final Integer order2 = entry2[0];
                    return order1.compareTo(order2);
                }
            });
        	
        	map.put(key, new ArrayList<int[]>().addAll(first))
        }
        
        
        
        Arrays.sort(first, new Comparator<Integer[]>() {
            @Override
            public int compare(final Integer[] entry1, final Integer[] entry2) {
                final Integer order1 = entry1[0];
                final Integer order2 = entry2[0];
                return order1.compareTo(order2);
            }
        });
        
    }
    
    public void sort(Collection data, Comparator<T>){
        
    }
}
