package Implementation.strangeCounter;

/**
 * Bob has a strange counter. At the first second, ,
 *  it displays the number . At each subsequent second, 
 *  the number displayed by the counter decrements by .

The counter counts down in cycles. In the second after 
the counter counts down to , the number becomes  the 
initial number for that countdown cycle and then continues 
counting down from the new initial number in a new cycle. 
The diagram below shows the counter values for each time  in the first three cycles:

strange(1).png

Given a time, , find and print the value displayed by the counter at time .

Input Format

A single integer denoting the value of .

Constraints

Subtask

 for  of the maximum score.
Output Format

Print the value displayed by the strange counter at the given time .

Sample Input

4
Sample Output

6
Explanation

Time  marks the beginning of the second cycle in which the 
counter displays a number that is double the initial number 
displayed at the beginning of the previous cycle (i.e., ). 
This is also shown in the diagram in the Problem Statement above.
 */

import java.util.*;


public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        in.close();
        if(t==1){
            System.out.println(3);
            return;
        }
        if(t==2){
            System.out.println(2);
            return;
        }
        if(t==3){
            System.out.println(1);
            return;
        }
        long index = t;
        long num_of_counts_in_one_section = 3;
        long total = 3;
        while(true){
            if(index-total > 0){//The input index still not reaching the correct section.
            	/*
            	 * The way of how number of counts in one section and
            	 * total number of counts increase.
            	 */
                num_of_counts_in_one_section *= 2;
                total = total+num_of_counts_in_one_section;
            }else if(index == total){//It's the end of one section, it's 1.
                System.out.println(1);
                return;
            }
            else{//If the index reaches the correct section.
                break;
            }
        }
        //Get corresponding count of the correct inner index of that section.
        //Counting from bottom to top.
        long res = total - index + 1;
        System.out.println(res);    
    }
}