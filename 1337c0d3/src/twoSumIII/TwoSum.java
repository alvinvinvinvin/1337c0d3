/**
 * Design and implement a TwoSum class. 
 * It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
 */
package twoSumIII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author alvin
 *
 */
public class TwoSum {
    List<Integer> list = new ArrayList<Integer>();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public void add(int num){
    	if(map.containsKey(num)){
    		map.put(num, map.get(num)+1);
    	}else{
    		map.put(num, 1);
    		list.add(num);
    	}
    }
    
    public boolean find(int target){
    	for (int i : list) {
    		/* 'i' is from the list which contains
    		 * all numbers added to map.
    		 * If there is a key in map which equals
    		 * to target minus the already existed 'i',
    		 * it means target = i + "that key".
    		 * If that key equals to i, then we check
    		 * the number of it appears. If it appears
    		 * twice, it is also the answer we want.
    		*/
			if(map.containsKey(target-i)){
				if(target - i != i) return true;
				else if(map.get(i) == 2) return true;
			}
		}
    	return false;
    }
}
