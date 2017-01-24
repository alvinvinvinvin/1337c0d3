/**
 * 
 */
package temperatures;

import java.util.Scanner;

/**
 * @author han.chen
 *Your program must read the data from the 
 *standard input and write the result on the standard output.
 *
Input
Line 1: N, the number of temperatures to analyze

Line 2: A string with the N temperatures 
expressed as integers ranging from -273 to 5526

Output
Display 0 (zero) if no temperatures are provided. 
Otherwise, display the temperature closest to 0.

Constraints
0 ≤ N < 10000
 */
/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        in.nextLine();
        String temps = in.nextLine(); // the n temperatures expressed as integers ranging from -273 to 5526
        in.close();
        String[] temp_set = temps.split(" ");
        int min_g0 = Integer.MAX_VALUE;
        int max_l0 = Integer.MIN_VALUE+1;
        int res = 0;
        if(n==0 || temps.isEmpty() || temp_set.length ==0) {
            System.out.println(res);
            return;
        }
        boolean f_g0 = true;
        boolean f_l0 = true;
        for(int i = 0; i<n;i++){
            int temp = Integer.parseInt(temp_set[i]);
            
            if(temp >0){
                if(f_g0){
                    min_g0 = temp;
                    f_g0 = false;
                    continue;
                }
                min_g0 = Math.min(min_g0, temp);
            }else if(temp<0){
                if(f_l0){
                    max_l0 = temp;
                    f_l0 = false;
                    continue;
                }
                max_l0 = Math.max(max_l0, temp);
            }else{
                System.out.println(res);
                return;
            }
        }
        
        if(min_g0 == -max_l0) res = min_g0;
        else res = min_g0 > -max_l0?max_l0:min_g0;

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(res);
    }
}
