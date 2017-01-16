package object_Oriented_nQueen;   

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**   
* Filename:    QueenSolver.java   
* Copyright:   Copyright (c)2014  
* Company:   UWL
* @author: Han Chen
* @version:    1.0   
* @since:  JDK 1.7
* Create at:   Nov 3, 2014 2:09:25 PM   
* Description:  
*   
* Modification History:   
* Date    Author      Version     Description   
* ----------------------------------------------------------------- 
* Nov 3, 2014 Han Chen      1.0     1.0 Version   
*/     
@SuppressWarnings("serial")
public class QueenSolver extends JFrame {
	static int numOfQueen = 8;
	private Queen lastQueen = null;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		QueenSolver qs = new QueenSolver();
		qs.show();
	}
	
	public QueenSolver(){
		setTitle("8 Queens");
		setSize(600, 500);
		for(int i = 0; i<numOfQueen;i++){
			lastQueen = new Queen(i, lastQueen);
			lastQueen.findSolution();
		}
		addMouseListener(new MouseKeeper());
		addWindowListener(new CloseQuit());
	}
	public void paint(Graphics g) {
		super.paint(g);
		// draw board
		for (int i = 0; i <= numOfQueen; i++) {
			g.drawLine(50 * i + 10, 40, 50 * i + 10, 440);
			g.drawLine(10, 50 * i + 40, 410, 50 * i + 40);
		}
		g.drawString("Click Mouse for Next Solution", 20, 470);
		// draw queens
		lastQueen.paint(g);		
	}
	
	private class MouseKeeper extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			lastQueen.advance();
			repaint();
		}
	}
	
	private class CloseQuit extends WindowAdapter{
		@SuppressWarnings("unused")
		public void windowClose(WindowEvent e){
			System.exit(0);
		}
	}
}
 