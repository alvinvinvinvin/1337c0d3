package _testPackage;
import java.util.*;
import java.math.*;
import dataStructureHelper.*;

public class Solution {
	public static void main(String... args){
		System.out.println("H,W!");
		test1();
		test2();
	}
	
	static void test1(){
		boolean[] bs = new boolean[5];
		for(boolean b: bs) System.out.println(b);
	}
	
	static void test2(){
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		res.add(Arrays.asList(1,2,3));
	}
	static void test3(List<List<Integer>> res){
		for (List<Integer> i : res) {
			for (Integer j : i) {
				System.out.println(j);
			}
		}
	}
}
