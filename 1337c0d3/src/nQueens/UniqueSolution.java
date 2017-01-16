package nQueens;   
/**   
* Filename:    UniqueSolution.java   
* Copyright:   Copyright (c)2014  
* Company:   UWL
* @author: Han Chen
* @version:    1.0   
* @since:  JDK 1.7
* Create at:   Nov 3, 2014 11:51:29 AM   
* Description:  
*   Not finished yet.
* Modification History:   
* Date    Author      Version     Description   
* ----------------------------------------------------------------- 
* Nov 3, 2014 Han Chen      1.0     1.0 Version   
*/    
public class UniqueSolution {
	static int numOfQueens = 12;//# of queens. If it is more than 15, the program will slow down.
	static int count = 0; 
	
	static void put(long ld, long cols, long rd, long all){
		if (cols != all) {//When all columns have not been occupied yet.
			long poss = (~(ld | cols | rd)) & all;//Figuring out all possible positions to put chess in current row.
			while (poss != 0) {//If there is still position available.
				long bit = poss & -poss;//Get the most right position.
				poss = poss - bit;//Remove it from all positions in current row.
				put((ld | bit) << 1, cols | bit, (rd | bit) >> 1, all);//Find next positions based on occupied positions.
			}
		}
		else
		count ++;//If all columns have been occupied, it means one solution has been found already.
	}
	
	static int numOfDigits(int input){
		int num = 0;
		int temp;
		while(input>0){
			temp =input>>1;
			input = temp;
			num++;
		}
		return num;
	}
}
 