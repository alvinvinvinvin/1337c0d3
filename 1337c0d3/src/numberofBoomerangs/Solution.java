/**
 * Given n points in the plane that are 
 * all pairwise distinct, a "boomerang" 
 * is a tuple of points (i, j, k) such that 
 * the distance between i and j equals the 
 * distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may 
assume that n will be at most 500 and 
coordinates of points are all in the range 
[-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] 
and [[1,0],[2,0],[0,0]]
 */
package numberofBoomerangs;

import java.util.*;

/**
 * @author han.chen
 *
 */
public class Solution {
	
	public static int numberOfBoomerangs(int[][] points) {
        int res = 0;
        int n = points.length;
        for(int i = 0; i<n;i++){
        	int[] a = points[i];
        	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        	for(int j = 0;j<n;j++){
        		int[] b = points[j];
        		int d = (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
        		if(map.containsKey(d)){
        			res += map.get(d)*2;
        			map.put(d, map.get(d)+1);
        		}else{
        			map.put(d, 1);
        		}
        	}
        }
        return res;
    }
    
    public static void sort(int [][] points){
        Arrays.sort(points, new Comparator<int[]>(){
           public int compare(int a[], int b[]){
               if(a[0] != b[0])
               return Integer.compare(a[0],b[0]);
               else
               return Integer.compare(a[1],b[1]);
           } 
        });
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = {{0,3},{0,1},{2,3},{1,3},{3,0}};
		sort(points);
		for(int[] i:points){
			System.out.print("["+i[0]+","+i[1]+"] ");
		}
			
	}

}
