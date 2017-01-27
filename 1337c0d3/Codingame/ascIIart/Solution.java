/**
 * 
 */
package ascIIart;

/**
 * @author han.chen
 * 	The Goal
 *	In stations and airports you often see this type of screen:

Have you ever asked yourself how it might be possible 
to simulate this display on a good old terminal? We have: with ASCII art!
 	Rules

ASCII art allows you to represent forms by using characters. 
To be precise, in our case, these forms are words. 
For example, the word "MANHATTAN" could be displayed as follows in ASCII art:

 
# #  #  ### # #  #  ### ###  #  ###
### # # # # # # # #  #   #  # # # #
### ### # # ### ###  #   #  ### # #
# # # # # # # # # #  #   #  # # # #
# # # # # # # # # #  #   #  # # # #
 
​Your mission is to write a program that can display a 
line of text in ASCII art in a style you are given as input.

 	Game Input

Input
Line 1: the width L of a letter represented in ASCII art. All letters are the same width.

Line 2: the height H of a letter represented in ASCII art. All letters are the same height.

Line 3: The line of text T, composed of N ASCII characters.

Following lines: the string of characters 
ABCDEFGHIJKLMNOPQRSTUVWXYZ? Represented in ASCII art.

Output
The text T in ASCII art.
The characters a to z are shown in ASCII art by their equivalent in upper case.
The characters that are not in the intervals [a-z] or [A-Z] 
will be shown as a question mark in ASCII art.
Constraints
0 < L < 30
0 < H < 30
0 < N < 200
Example 1
Input
4
5 
E
 #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ### ### 
# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #   # 
### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   ## 
# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #       
# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###  #  
Output
### 
#   
##  
#   
### 
Example 2
Input
4
5
MANHATTAN
 #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ### ### 
# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #   # 
### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   ## 
# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #       
# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###  #  
Output
# #  #  ### # #  #  ### ###  #  ###  
### # # # # # # # #  #   #  # # # #  
### ### # # ### ###  #   #  ### # #  
# # # # # # # # # #  #   #  # # # #  
# # # # # # # # # #  #   #  # # # # 
 */
import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine();
        
        //Map from letter to ASCII letter
        //ASCII letter is defined by:
        //1) up left corner coordination
        //2) L
        //3) H
        
        //List to store ASCII characters
        String[] all_str = new String[H];
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            all_str[i] = ROW;
        }
        
        in.close();
        T = T.toLowerCase();
        int[] coord = new int[T.length()];
        for(int i=0;i<T.length();i++) coord[i] = getCoordinationStart(T.charAt(i),L);
        String res = "";

        res = getMatchingStr(coord, all_str, L);
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(res);
    }
    
    static int getCoordinationStart(char c, int L){
    	int res = 0;
    	res = c-'a';
    	if(res<0 || res >25) res = 26*L;
    	else res *= L;
    	return res;
    }
    
    static String getMatchingStr(int[] coord, String[] all_str,int L){
    	String res = "";
    	for(String s:all_str){
    		for(int i:coord){
    			res += s.substring(i, i+L);
    		}
    		res += "\n";
    	}
    	return res;
    }
    
}