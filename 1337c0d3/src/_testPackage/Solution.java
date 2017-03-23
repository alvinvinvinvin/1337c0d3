package _testPackage;
import java.util.*;


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
}