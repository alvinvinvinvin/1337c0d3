/**
 * 
 */
package chapterOne;


/**
 * @author e007777
 *
 */
public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {31, 41, 59, 26, 41, 58};
		int[] B = {31, 41, 59, 26, 41, 58};
		int[] C = {31, 41, 59, 26, 41, 58};
		printArr(A);
		insertionSort_increasing(A);
		printArr(A);
		
		
		printArr(B);
		insertionSort_decreasing(B);
		printArr(B);

		
		linearSearchForV(C, 41);
		linearSearchForV(C, 8);
		linearSearchForV(C, 31);
	}
	
	//2.1-1
	static void insertionSort_increasing(int[] arr){
		for(int j = 1; j<arr.length; j++){
			int key = arr[j];
			int i = j-1;
			//If arr[i] is greater than key
			while(i >= 0 && arr[i] > key){
				arr[i+1] = arr[i];
				i--;
			}
			arr[i+1] = key;
		}
	}
	//2.1-2
	static void insertionSort_decreasing(int[] arr){
		for(int j = 1; j<arr.length; j++){
			int key = arr[j];
			int i = j-1;
			//If arr[i] is less than key
			while(i >= 0 && arr[i] < key){
				arr[i+1] = arr[i];
				i--;
			}
			arr[i+1] = key;
		}
	}
	
	//2.1-3
	static void linearSearchForV(int[] arr, int v){
		String result = "NIL";
		for(int i = 0; i< arr.length; i++){
			if(arr[i] == v){
				result = ""+i;
				break;
			}
		}
		System.out.println(result);
	}
	
	static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static void print(Object o){
		System.out.println(o.toString());
	}
	
	static void printArr(int[] A){
		for(int i : A)System.out.print(i+" ");
		System.out.println();
	}

}
