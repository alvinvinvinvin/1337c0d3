/**
 * You are given a matrix with N rows and N columns. (important, square)
 * Elements in matrix can be either 1 or 0.  
 * Each row and column of matrix is sorted in ascending order. (important, sorted)
 * Find number of 0-s in the given matrix.
 * Example:
 * 
 * 0 0 1
 * 0 1 1
 * 1 1 1
 * answer=3;
 * 
 * 0 0
 * 0 0
 * answer=4;
 * 
 * 0 1 1 1
 * 0 1 1 1
 * 1 1 1 1
 * 1 1 1 1
 * answer=2;
 * 
 * Update: Expected complexity is O(log(N)). 
 * 
 * Worst case is O(N).
 * 
 */
package findZerosInNxNMatrix;


public class Solution {
	public static int countZerosInMatrix(int[][] matrix){
		int answer = 0;
		int n = matrix.length;
		int row = n-1;
		int col = 0;
		while(col < n){
			//if its 0 then it wont go through following loop,
			//which also means the numbers on its top are all 0s.
			//if not, which means its a 1, then we check if its
			//the first row by moving row pointer upper.
			//if its first row, then return answer;
			//if not, since we've already moved pointer upper anyway,
			//we'll do nothing.
			//Notice that we don't have to worry about 0s on its left,
			//because we have already counted them in previous time.
			//This is the key point to make it O(log(N)).
			while(matrix[row][col] != 0){
				if(--row < 0)//move row upper
					return answer;
			}
			answer += row + 1;//+1 since row starts from 0;
			col++;
		}
		return answer;
	}
	
	//This one is easier to understand. 
	//It starts from up left corner and goes along
	//the diagonal to check the number.
	//If its 1, then stop; if not, start from that
	//cell and go along vertically and horizontally
	//to check the numbers, then count.
	//I think this one is slightly faster in most cases.
	static int methodTwo(int[][] matrix){
		int answer = 0;
		int n = matrix.length;
		int row = 0, col = 0;
		while(row<n && matrix[row][col] != 1){
			answer++;
			int colTmp = col+1;//start from the next cell on the same column.
			while(colTmp<n && matrix[row][colTmp]!=1){
				answer ++;
				colTmp++;
			}
			int rowTmp = row+1;//start from the next cell on the same row.
			while(rowTmp<n && matrix[rowTmp][col]!=1){
				answer ++;
				rowTmp++;
			}
			row++;
			col++;
		}
		return answer;
	}
	
	static String test1(){
		int a = 0,b=0;
		int[][] matrix = 
			{	{0,0,0,0,0,0,0,0},
				{0,0,0,0,1,1,1,1},
				{0,0,1,1,1,1,1,1},
				{0,0,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1}};
		long start1 = System.nanoTime();
		a = countZerosInMatrix(matrix);
		
		long end1 = System.nanoTime();
		long start2 = System.nanoTime();
		b = methodTwo(matrix);
		long end2 = System.nanoTime();
		long duration1 = (start1 - end1);
		long duration2 = (start2 - end2);
		System.out.println("1: "+duration1);
		System.out.println("2: "+duration2);
		return (duration1>=duration2 ? a+"" : b+"");

	}
	public int singleNumber(int[] nums) {
        int result = 0;
        for(int i:nums) result ^= i;
        return result;
    }
	public static void main(String... args){
		System.out.println(test1());
	}
}
