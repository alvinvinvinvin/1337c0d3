/**
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
package pascalTriangle;

import java.util.*;

/**
 * @author e007777
 *
 */
public class Solution {
    public static List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> row = new ArrayList<Integer>();
    	for(int i = 0; i< numRows; i++){
    		row.add(1);
    		for(int j = 1; j<i;j++){
    			List<Integer> p = res.get(i-1);
    			row.set(j, p.get(j-1)+p.get(j));
    		}
    		row.set(i, 1);
    		res.add(new ArrayList<Integer>(row));
    	}
    	return res;
    	
    }
    
	public static List<List<Integer>> generate2(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(numRows < 1) return res;
    	int[][] result = new int[numRows][];
    	result[0] = new int[]{1};
    	res.add(new ArrayList<Integer>(Arrays.asList(1)));
    	for(int i = 1; i< numRows; i++){
    		List<Integer> row = new ArrayList<Integer>();
    		result[i] = new int[i+1];
    		result[i][0] = 1;
    		for(int j = 1; j<i;j++){
    			result[i][j] = result[i-1][j-1] + result[i-1][j];
    		}
    		result[i][i] = 1;
    		for(int n: result[i]) row.add(n);
    		res.add(row);
    	}
    	//List<List<Integer>> res = Arrays.stream(result).map(row -> IntStream.of(row).boxed().collect(Collectors.toList())).collect(Collectors.toList());
    	//List res = Arrays.asList(result);
    	return res;
    	
    }
    
    public static void main(String args[]){
    	System.out.println("Pascal's Triangle");
    	int n = 7;
    	List<List<Integer>> test = generate2(n);
    	for(List<Integer> r:test){
    		System.out.println(r.toString());
    	}
    }
}
