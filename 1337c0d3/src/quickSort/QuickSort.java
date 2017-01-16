package quickSort;   

import java.util.Random;

/**   
* Filename:    QuickSort.java   
* Copyright:   Copyright (c)2014  
* Company:   UWL
* @author: Han Chen
* @version:    1.0   
* @since:  JDK 1.7
* Create at:   Nov 2, 2014 11:26:42 PM   
* Description:
* 	Quick sort.  
*   Set first number of array to be key value without putting it in the middle of array.
*   Only keep switching the less one on left and the greater one on right.
* Modification History:   
* Date    Author      Version     Description   
* ----------------------------------------------------------------- 
* Nov 2, 2014 Han Chen      1.0     1.0 Version   
*/     
public class QuickSort {
	static Random r = new Random();
	static int length  = 10;
	static int lowerBound = 0;
	
	public static void main(String[] args){
		int[] arr = new int[length];
		for(int i = 0; i<arr.length; i++){
			arr[i] = r.nextInt(arr.length-lowerBound)+lowerBound;
		}
		printArr(arr);
		quickSort(arr,0,(arr.length-1));
		printArr(arr);
	}
	static void quickSort(int[] arr, int left, int right){
		
		if (left<right) {
			int key = arr[left], i = left, j = right;
			while (i != j) {
				while (arr[j] >= key && i < j)
					j--;
				while (arr[i] <= key && i < j)
					i++;
				if (i < j) {
					swap(arr, i, j);
					printArr(arr);
				}
			}
			swap(arr,left,i);
			printArr(arr);
			quickSort(arr, left, i - 1);
			quickSort(arr, i + 1, right);
		}
	}
	
	static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static void printArr(int[] arr){
		for(int i : arr)
			System.out.print(i+" ");
		System.out.println();
	}
}
 