/**
 * You are given an array of n integers (n>=2), a1, a2, ..., an and an integer k.
 * At the beginning, List L = []. For every combination of ai and aj (i<j),
 * min(ai, aj) is added to L. So there are n*(n-1)/2 numbers in L.
 * Please find the k-th largest value of L.
 * (If possible, can you solve it with O(n) time complexity?)
 * 
 */
package kthLargestAfterCompare;

import java.util.*;

/**
 * @author e007777
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,2,3,4};
		int k = 1;
		int k_i = quickSelect(arr, 0, arr.length-1, k);
		int res = kth(arr, k);
		print("k_i:"+k_i);
		print("res:"+res);
	}
	
	public static int kth(int[] arr, int k){
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i:arr) updateMap(map, i);
		int k_i_arr = quickSelect(arr, 0, arr.length-1, k);
		print("kiarr:"+k_i_arr);
		print("map_kiarr:"+map.get(arr[k_i_arr]));
		res = k_i_arr - 1 + map.get(arr[k_i_arr]);
		
		return res;
	}
	
	static int quickSelect(int[] arr, int lo, int hi, int k){
		int i = lo, j = hi, pivot = arr[hi];
		
		while(i<j){
			if(arr[i++] > pivot) swap(arr, --i, --j);
		}
		swap(arr, i, hi);
		
		int m = i - lo + 1;
		
		if(m == k) return i;
		else if (m > k) return quickSelect(arr, lo, i-1, k);
		else return quickSelect(arr, i+1, hi, k-m);
		
	}
	
	static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static void updateMap(HashMap<Integer, Integer> map, int i){
		if(map.containsKey(i)){
			map.put(i, map.get(i)+1);
		}else{
			map.put(i, 1);
		}
	}
	
	static void print(Object o){
		System.out.println(o.toString());
	}
	

}
