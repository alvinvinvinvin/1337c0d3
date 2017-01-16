package object_Oriented_nQueen;   

import java.awt.Graphics;

/**   
* Filename:    Queen.java   
* Copyright:   Copyright (c)2014  
* Company:   UWL
* @author: Han Chen
* @version:    1.0   
* @since:  JDK 1.7
* Create at:   Nov 3, 2014 1:50:48 PM   
* Description:  
*   Object_oriented way to solve 8 queens problem.
*   Inspired by http://web.engr.oregonstate.edu/~budd/Books/oopintro3e/info/chap06.pdf
* Modification History:   
* Date    Author      Version     Description   
* ----------------------------------------------------------------- 
* Nov 3, 2014 Han Chen      1.0     1.0 Version   
*/     
public class Queen {
	static int numOfQueen = 8;
	private int column;
	private int row;
	private Queen neighbor;
	
	//Constructor
	public Queen(int c, Queen n){
		this.row = 1;
		this.column = c;
		this.neighbor = n;
	}
	
	public boolean findSolution(){
		while(neighbor != null && neighbor.canAttack(row, column)){
			if(!advance()){
				return false;
			}
		}
		return true;
	}

	public boolean advance() {
		// TODO Auto-generated method stub
		if(row<numOfQueen){
			row++;
			return this.findSolution();
		}
		else{
				if (neighbor!=null&&!neighbor.advance())
					return false;
				else {
					row = 1;
					return this.findSolution();
				}
		}
	}

	private boolean canAttack(int testRow, int testColumn) {
		// TODO Auto-generated method stub
		if(row == testRow) return true;
		int columnDifference = testColumn - column;
		if(((row + columnDifference) == testRow) || ((row - columnDifference) == testRow)){
			return true;
		}
		if(neighbor != null)
		return neighbor.canAttack(testRow, testColumn);
		else	return false;
	}
	
	public void paint (Graphics g){
	if (neighbor != null) {
		// x, y is upper left corner
		// 10 and 40 give slight margins to sides
		int x = (row - 1) * 50 + 10;
		int y = (column - 1) * 50 + 40;
		g.drawLine(x + 5, y + 45, x + 45, y + 45);
		g.drawLine(x + 5, y + 45, x + 5, y + 5);
		g.drawLine(x + 45, y + 45, x + 45, y + 5);
		g.drawLine(x + 5, y + 35, x + 45, y + 35);
		g.drawLine(x + 5, y + 5, x + 15, y + 20);
		g.drawLine(x + 15, y + 20, x + 25, y + 5);
		g.drawLine(x + 25, y + 5, x + 35, y + 20);
		g.drawLine(x + 35, y + 20, x + 45, y + 5);
		g.drawOval(x + 20, y + 20, 10, 10);
		// then draw neighbor
		if (neighbor != null)
			neighbor.paint(g);
		}
	}

}
 