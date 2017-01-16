/*
 * Given an integer unordered array. Find
 * the max(i-j) where i<j & arr[i] < arr[j];
 * Try to give two ways to solve this problem.
 * One is minimum time complexity and another
 * is minimum space complexity
 */
package maxDiff;

public class Solution {
	public static void main(String args[]){
		int[] arr = {19, 2, 33, 44, 5, 16, 7, 8, 18, 0};
		int n = arr.length;
		int maxDiff_1 = inSpaceSolution(arr, n); 
		int maxDiff_2 = minimumTimeComplexitySolution(arr, n);
		System.out.println("maxDiff_1 = "+maxDiff_1+"\n"+"maxDiff_2 = "+maxDiff_2);
		
	}
	
	/**
	 * In-space way having minimum space complexity.
	 * Brutal way. Setting two pointer i and j, pointing
	 * to head and end respectively.
	 * 
	 * Time Complexity: O(n^2)
	 * @param arr
	 * @param n is the length of arr
	 * @return
	 */
	public static int inSpaceSolution(int[] arr, int n){
		int i,j = n-1;
		int maxDiff = -1;
		for(i = 0;i<n;++i){
			for(j = n-1;j>i;--j){
				if(arr[i] < arr[j] && maxDiff < (j-i)){
					maxDiff = j-i;
				}
			}
		}
		return maxDiff;
	}
	
	/**
	 * To solve this problem, we need to get two optimum indexes 
	 * of arr[]: left index i and right index j. 
	 * 
	 * For an element arr[i], we do not need to consider arr[i] 
	 * for left index if there is an element smaller than arr[i] 
	 * on left side of arr[i]. Similarly, if there is a greater 
	 * element on right side of arr[j] then we do not need to consider 
	 * this j for right index. So we construct two auxiliary arrays 
	 * LMin[] and RMax[] such that LMin[i] holds the smallest element 
	 * on left side of arr[i] including arr[i], and RMax[j] holds the 
	 * greatest element on right side of arr[j] including arr[j].
	 *  
	 * After constructing these two auxiliary arrays, we traverse both 
	 * of these arrays from left to right. While traversing LMin[] and 
	 * RMa[] if we see that LMin[i] is greater than RMax[j], then we 
	 * must move ahead in LMin[] (or do i++) because all elements on 
	 * left of LMin[i] are greater than or equal to LMin[i]. Otherwise 
	 * we must move ahead in RMax[j] to look for a greater j – i value.
	 * 
	 * Time Complexity: O(n) 
	 * Auxiliary Space: O(n)
	 * @param arr
	 * @param n
	 * @return
	 */
	public static int minimumTimeComplexitySolution(int[] arr, int n){
		
		
		int maxDiff = -1,i=0,j=0;
		int[] Lmin = new int[n];
		int[] Rmax = new int[n];
		
		/* Construct Lmin[] such that Lmin[i] stores the minimum value
        from (arr[0], arr[1], ... arr[i]) */
		Lmin[0] = arr[0];
		for(i=1;i<n;i++){
			Lmin[i] = min(arr[i], Lmin[i-1]);
		}
		
		/* Construct Rmax[] such that Rmax[j] stores the maximum value
        from (arr[j], arr[j+1], ..arr[n-1]) */
		Rmax[n-1] = arr[n-1];
		for(j=n-2;j>=0;j--){
			Rmax[j] = max(arr[j], Rmax[j+1]);
		}
				
		/* Traverse both arrays from left to right to find optimum j - i
        This process is similar to merge() of MergeSort */
		i=0;j=0;
		while(i<n && j<n){
			if(Lmin[i] < Rmax[j]){
				maxDiff = max(maxDiff, j-i);
				j++;
			}else
				i++;
		}
		return maxDiff;
	}
	
	static int min(int x, int y){
		return x<y?x:y;
	}
	
	static int max(int x, int y){
		return x>y?x:y;
	}
	
	
}
