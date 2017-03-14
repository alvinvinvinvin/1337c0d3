/**
 * You are given a map in form of a 
 * two-dimensional integer grid where 1 
 * represents land and 0 represents water. 
 * Grid cells are connected horizontally/vertically 
 * (not diagonally). The grid is completely surrounded 
 * by water, and there is exactly one island 
 * (i.e., one or more connected land cells). 
 * The island doesn't have "lakes" (water inside 
 * that isn't connected to the water around the island). 
 * One cell is a square with side length 1. 
 * The grid is rectangular, width and height 
 * don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:

The formula is that the result equals to the number of total lands times 4 then minus
the two times of the total number of the connections. 
Draw a example yourself and you will see.

 */
package islandPerimeter;

public class Solution {
	public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int n_1 = 0;
        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m;j++){
                if(grid[i][j] == 1){
                    //vertical connection
                    if(i<n-1 && grid[i+1][j] == 1){
                        count++;
                    }
                    
                    //horizontal connection
                    if(j>0 && grid[i][j-1] == 1){
                        count++;
                    }
                    n_1++;
                }
            }
        }
        return (n_1*4)-(count*2);
    }
}
