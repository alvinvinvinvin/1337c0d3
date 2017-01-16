/**
 * A Discrete Mathematics professor has a class of  students. 
 * Frustrated with their lack of discipline, he decides to cancel 
 * class if fewer than  students are present when class starts.

Given the arrival time of each student, determine if the class is canceled.

Input Format

The first line of input contains , the number of test cases.

Each test case consists of two lines. The first line has two 
space-separated integers,  (students in the class) and (the 
cancelation threshold). The second line contains  space-separated 
integers () describing the arrival times for each student.

Note: Non-positive arrival times () indicate the student arrived 
early or on time; positive arrival times () indicate the student arrived  minutes late.

Constraints

Output Format

For each test case, print the word YES if the class is canceled or NO if it is not.

Note 
If a student arrives exactly on time , the student is considered 
to have entered before the class started.

Sample Input

2
4 3
-1 -3 4 2
4 2
0 -1 2 1
Sample Output

YES
NO
Explanation

For the first test case, . The professor wants at least  students 
in attendance, but only  have arrived on time ( and ). Thus, the class is canceled.

For the second test case, . The professor wants at least  students
 in attendance, and there are  who have arrived on time ( and ). Thus, the class is not canceled.
 */
package Implementation.angryProfessor;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. 
        Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n_test = sc.nextInt();
        boolean[] res_array = new boolean[n_test];
        for(int i = 0; i<n_test; i++){
            res_array[i] = getResult(sc);
        }
        sc.close();
        return;
    }
    static boolean getResult(Scanner sc){
        int n_student = sc.nextInt();
        int n_threshold = sc.nextInt();
        int i = 0;
        int count = 0;
        boolean res = false;
        while(i<n_student){
            int t_arrive = sc.nextInt();
            if(t_arrive > 0){
                count++;
                if(count > n_student-n_threshold){
                    res = true;
                    //break;
                }
            } 
            i++;
        }
        String result = res?"YES":"NO";
        System.out.println(result);
        return res;
    }
}
