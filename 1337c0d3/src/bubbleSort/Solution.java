package bubbleSort;

public class Solution {
	public static void main(String args[]){
		int[] array = new int[]{2,4,5,3,5,7,3,8,5,9,1,23,56,4};
		int length = array.length;
		bubbleSort(array, length);
		for(int i:array){
			System.out.print(i+", ");
		}
	}
	
	public static void bubbleSort(int[] arr, int last){
		int i = 0,j = i+1;
		if(last == 2) return;
		for(; j<last; i++,j++){
			if(arr[i] > arr[j]) swap(arr, i, j);
		}
		bubbleSort(arr, last-1);
	}
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
