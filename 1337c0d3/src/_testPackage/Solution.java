package _testPackage;
import java.util.*;
import dataStructureHelper.*;


/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
    	System.out.println('a'-'Z');
    	System.out.println("git test");
    	boolean[] test = new boolean[4];
    	for(boolean t:test) System.out.println(t);
    	
    	int[] arr = new int[10];
    	for(int i:arr) System.out.println(i);
    	
    	String a = "abcde";
    	System.out.println(a.substring(0, a.length()));
    	int[] a_a = {1,2,3};
    	int[] a_b = {3};
    	System.out.println(findContentChildren(a_a,a_b));
    	long[] f = factorial();
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i<= 100000; i++){
    		sb.append(f[i]);
    		sb.append("\n");
    	}
    	System.out.println(sb.toString());
    	
    	int num1 = 16,num2 = 15,num3 = 8;
    	System.out.print(isPowerOf4(num1)+","+ isPowerOf4(num2)+","+ isPowerOf4(num3));
    	
    }
    
    public static int findContentChildren(int[] g, int[] s) {
        int c = 0;
        for(int i : g){
            for(int j : s){
                if(i <= j){
                  c++;
                  break;
                }
            }
        }
        return c;
    }
    
    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
    
    public static long[] factorial(){
        long m = 1000000007;
		int n = 100000;
        long[] f = new long[n+1];
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;
        for(int i = 3; i <= n; i++){
            f[i] = (f[i-1] * i)%m;
        }
        return f;
    }
    
    public static boolean isPowerOf4(int num){
    	return num == 1 || (num>0 && Integer.highestOneBit(num) == num && Integer.numberOfTrailingZeros(num) % 2 == 0);
    }

}