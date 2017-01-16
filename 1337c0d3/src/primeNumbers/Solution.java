package primeNumbers;   

import java.util.Scanner;

/**   
* Filename:    Solution.java   
* Copyright:   Copyright (c)2014  
* Company:   UWL
* @author: Han Chen
* @version:    1.0   
* @since:  JDK 1.7
* Create at:   Nov 1, 2014 11:37:24 PM   
* Description:  
*   Input a number then the program will show all of prime numbers less than the number you input.
*   (the number you input is not included).
*   Sieve of Eratosthenes algorithm.
* Modification History:   
* Date    Author      Version     Description   
* ----------------------------------------------------------------- 
* Nov 1, 2014 Han Chen      1.0     1.0 Version   
*/   
public class Solution {
	public static void main(String[] args){
		System.out.println("please input a number:");
		Scanner scan = new Scanner(System.in);
		long input = scan.nextLong();
		scan.close();
		primeNumber(input);
	}
	
	public static void primeNumber(long input){
		boolean[] isPrime = new boolean[(int)input+1];
		for(long i = 2; i<isPrime.length; i++){
			isPrime[(int)i] = true;
		}
		
		for(long divisor = 2; divisor*divisor<=input;divisor++){
			if(isPrime[(int)divisor]){
				for(long i = divisor*2; i<input; i = i + divisor){
					isPrime[(int)i] = false;
				}
			}
		}
		for(long i =2; i<input; i++){
			if(isPrime[(int)i])
			System.out.println(i);
		}
	}
}
 