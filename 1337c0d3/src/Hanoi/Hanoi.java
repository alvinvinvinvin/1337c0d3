package Hanoi;   

import java.util.Scanner;

/**   
* Filename:    Hanoi.java   
* Copyright:   Copyright (c)2014  
* Company:   UWL
* @author: Han Chen
* @version:    1.0   
* @since:  JDK 1.7
* Create at:   Oct 31, 2014 2:58:06 PM   
* Description:  
*   Hanoi game. Moving plates from pillar A to pillar C using pillar B.
* Modification History:   
* Date    Author      Version     Description   
* ----------------------------------------------------------------- 
* Oct 31, 2014 Han Chen      1.0     1.0 Version   
*/     
public class Hanoi {
	static long counter = 0;
	public static void main(String[] args){
		System.out.println("please input the number of plates (more than 0):");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.close();
		move(num,'A','B','C');
		System.out.println("Total number of steps is "+counter);
	}
	
	private static void move(int num, char a, char b, char c){
		if(num == 1){
			counter++;
			if(counter <=200)
			System.out.println("step "+counter+": move number "+num+" plate from "+a+" to "+c);
			else{
				if(counter % 10000000 == 0){
					System.out.println("step "+counter+": move number "+num+" plate from "+a+" to "+c);
				}
			}
		}
		else{
			move(num-1,a,c,b);
			counter ++;
			if(counter <=200)
			System.out.println("step "+counter+": move number "+num+" plate from "+a+" to "+c);
			else{
				if(counter % 10000000 == 0){
					System.out.println("step "+counter+": move number "+num+" plate from "+a+" to "+c);
				}
			}
			move(num-1,b,a,c);
		}
	}
}
 