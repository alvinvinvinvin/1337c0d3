/**
 * Here's a humerus joke:

Why did Papyrus the skeleton go to the store by himself? 
Because he had no body to go with him!
Did you like it? Don't worry, I've got a ton more. A skele-ton.

Once upon a time, Papyrus the skeleton went to buy some pasta 
from the store. The store's inventory is bare-bones and they 
only sell one thing — boxes of uncooked spaghetti! The store 
always stocks exactly  boxes of pasta, and each box is numbered 
sequentially from  to . This box number also corresponds to the 
number of sticks of spaghetti in the box, meaning the first box 
contains  stick, the second box contains  sticks, the third box 
contains  sticks, …, and the  box contains  sticks. Because they 
only stock one box of each kind, the store has a tendon-cy to sell out of spaghetti.

During each trip to the store, Papyrus likes to buy exactly  
sticks of spaghetti by purchasing exactly  boxes (no more, no less). 
Not sure which boxes to purchase, Papyrus calls Sherlock Bones for 
help but he's also stumped! Do you have the guts to solve this puzzle?

Given the values of , , and  for  trips to the store, determine which 
boxes Papyrus must purchase during each trip. For each trip, print a 
single line of  distinct space-separated integers denoting the box 
number for each box of spaghetti Papyrus purchases (recall that the 
store only has one box of each kind). If it's not possible to buy 
sticks of spaghetti by purchasing  boxes, print -1 instead.

Input Format

The first line contains a single integer, , denoting the number of trips to the store. 
Each of the  subsequent lines describes a trip to the store in 
the form of three space-separated integers describing the respective 
values of  (the number of sticks to buy),  (the number of boxes the 
store has for sale), and  (the number of boxes to buy) for that trip to the store.

Constraints

Output Format

For each trip to the store:

If there is no solution, print -1 on a new line.
Otherwise, print a single line of  distinct space-separated integers 
where each integer denotes the box number (i.e., the number of spaghetti 
sticks in the box) that Papyrus must purchase.
If there are multiple possible solutions, you can print any one of them. 
Do not print any leading or trailing spaces.

Sample Input

4
12 8 3
10 3 3
9 10 2
9 10 2
Sample Output

2 3 7
-1
5 4
1 8
Explanation

Papyrus makes the following trips to the store:

He wants to buy exactly  boxes of spaghetti and have a total number of  
sticks. During this trip, the store has  boxes of spaghetti sticks where 
the first box has  stick, the second box has  sticks, the third box has  
sticks, and so on. One possible solution would be the following: 
Homemade noodles are the best!
BUT I JUST BUY STORE-BRAND! THEY'RE THE CHEAPEST!!! NGAHHHHHHHHHHHHHHHHHHH!!!
Papyrus can buy the -stick, -stick, and -stick boxes for the total of  sticks. 
Note that this is not the only valid solution; other valid solutions are acceptable.
He wants to buy exactly  boxes of spaghetti and have a total number of  sticks. 
Because the store only has three boxes in stock containing , , and  sticks of 
spaghetti, it's not possible for Papyrus to buy sticks of spaghetti as buying 
all three boxes would only yield  sticks (which is less than the that he wanted 
to purchase). Thus, we print -1 on a new line.
The third and fourth trips to the store both contain the same values (, , ); 
this is simply to illustrate that there may be multiple solutions for any given 
trip to the store and any valid solution is acceptable.
 */
package Implementation.bonetrousle;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. 
        Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String res ="";
        for(int i = 0; i< t;i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int b = sc.nextInt();
            //TO DO
        }
        System.out.println(res);
    }
    
    static String calculate(int n, int k, int b){
        String res = "";
        int total =(1+k)*k/2;
        
        return res;
    }
}
