/**
 * 
 */
package happyNumber;

import java.util.*;

/**
 * @author han.chen
 *
 */
public class Solution {
	
	public static void main(String[] args){
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<Integer>();
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < 500000; i++){
			sb.append(i+": "+isHappy2(i)+"\n");
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(sb.toString());
		System.out.println(totalTime);
		//for(Integer i: list) System.out.print(i+" ");
	}
	
	public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while(set.add(n)){
            int sum = 0;
            while(n>0){
                int tmp = n%10;
                sum += tmp*tmp;
                n /= 10;
            }
            if(sum == 1) return true;
            else n = sum;
        }
        return false;
    }
	
	public static boolean isHappy2(int n){
		int slow = n,fast = n;
		do{
			slow = calculate(slow);
			fast = calculate(fast);
			fast = calculate(fast);
		}while(slow != fast);
		if(slow == 1) return true;
		else return false;
	}
	
	public static int calculate(int n){
		int sum = 0;
		while(n>0){
            int tmp = n%10;
            sum += tmp*tmp;
            n /= 10;
        }
		return sum;
	}
	
}
