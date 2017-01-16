package nQueens;   
/**   
* Filename:    Solution.java   
* Copyright:   Copyright (c)2014  
* Company:   UWL
* @author: Han Chen
* @version:    1.0   
* @since:  JDK 1.7
* Create at:   Nov 1, 2014 11:02:34 PM   
* Description:  
*   N (from 1 to 12) queens problem solving by Bit pattern & recursion.
*   Inspired by http://www.cl.cam.ac.uk/~mr10/backtrk.pdf
*   This algorithm is for counting the total solution of nQueen problem, not unique solutions.
*   (There are 92 total solutions for 8 queens but only 12 unique solutions)
* Modification History:   
* Date    Author      Version     Description   
* ----------------------------------------------------------------- 
* Nov 1, 2014 Han Chen      1.0     1.0 Version   
*/     
public class Solution {
	static int numOfQueens = 20;//# of queens. If it is more than 15, the program will slow down.
	static int count = 0; 
	
	public static void main(String[] args){
		print();
	}
	
	static void print(){
		for(int i = 1; i<=numOfQueens; i++){
			count = 0;
			put(0,0,0,(long)(Math.pow(2, i)-1));//Start from a empty board.
			System.out.println("There are "+count+" solutions for "+i+"-queens problem.");
		}
	}
	
	/**
	 * This method will use bit pattern and backtracking mechanism to solve n queens problem.
	 * 
	 * @param ld Left going diagonal
	 * @param cols Column
	 * @param rd Right going diagonal
	 * @param all When all columns have been occupied.
	 */
	static void put(long ld, long cols, long rd, long all){
		if (cols != all) {//When all columns have not been occupied yet.
			//"& all" is kind of the way to set the size of board.
			long poss = (~(ld | cols | rd)) & all;//Figuring out all possible positions to put chess in current row.
			while (poss != 0) {//If there is still position available.
				long bit = poss & -poss;//Get the most right position.
				poss ^= bit;//Remove it from all positions in current row.
				put((ld | bit) << 1, cols | bit, (rd | bit) >> 1, all);//Find next positions based on occupied positions.
			}
		}
		else
		count ++;//If all columns have been occupied, it means one solution has been found already.
	}
}
 