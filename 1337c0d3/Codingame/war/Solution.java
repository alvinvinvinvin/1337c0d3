/**
 *  	The Goal

Let's go back to basics with this simple card game: war!

Your goal is to write a program which finds out which player 
is the winner for a given card distribution of the "war" game.
 	Rules

War is a card game played between two players. Each player 
gets a variable number of cards of the beginning of the game: 
that's the player's deck. Cards are placed face down on top of each deck.
 
Step 1 : the fight
At each game round, in unison, each player reveals the top 
card of their deck – this is a "battle" – and the player with 
the higher card takes both the cards played and moves them to 
the bottom of their stack. The cards are ordered by value as follows, from weakest to strongest:
2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A.
 
Step 2 : war
If the two cards played are of equal value, then there is a 
"war". First, both players place the three next cards of their 
pile face down. Then they go back to step 1 to decide who is 
going to win the war (several "wars" can be chained). As soon 
as a player wins a "war", the winner adds all the cards from the "war" to their deck.
 
Special cases:
If a player runs out of cards during a "war" (when giving up 
the three cards or when doing the battle), then the game ends 
and both players are placed equally first.
The test cases provided in this puzzle are built in such a way 
that a game always ends (you do not have to deal with infinite games)
Each card is represented by its value followed by its suit: 
D, H, C, S. For example: 4H, 8C, AS.

When a player wins a battle, they put back the cards at the bottom 
of their deck in a precise order. First the cards from the first 
player, then the one from the second player (for a "war", all the 
cards from the first player then all the cards from the second player).

For example, if the card distribution is the following:
Player 1 : 10D 9S 8D KH 7D 5H 6S
Player 2 : 10H 7H 5C QC 2C 4H 6D
Then after one game turn, it will be:
Player 1 : 5H 6S 10D 9S 8D KH 7D 10H 7H 5C QC 2C
Player 2 : 4H 6D
 
Victory Conditions
A player wins when the other player no longer has cards in their deck.
 	Game Input

Input
Line 1: the number N of cards for player one.

N next lines: the cards of player one.

Next line: the number M of cards for player two.

M next lines: the cards of player two.

Output
If players are equally first: PAT
Otherwise, the player number (1 or 2) followed by the number of 
game rounds separated by a space character. A war or a succession 
of wars count as one game round.
Constraints
0 < N, M < 1000
Example
Input
3
AD
KC
QC
3
KH
QS
JC
Output
1 3
 */
package war;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author han.chen
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		ConcurrentLinkedQueue<Integer> que_cardp1 = new ConcurrentLinkedQueue<Integer>();
		ConcurrentLinkedQueue<Integer> que_cardp2 = new ConcurrentLinkedQueue<Integer>();
        int n = in.nextInt(); // the number of cards for player 1
        for (int i = 0; i < n; i++) {
            String cardp1 = in.next(); // the n cards of player 1
            String temp = cardp1.substring(0,cardp1.length()-1);
            que_cardp1.add(convert(temp));
        }
        int m = in.nextInt(); // the number of cards for player 2
        for (int i = 0; i < m; i++) {
            String cardp2 = in.next(); // the m cards of player 2
            String temp = cardp2.substring(0,cardp2.length()-1);
            que_cardp2.add(convert(temp));
        }
        in.close();
        int count = 0;
        ConcurrentLinkedQueue<Integer> war_list1 = new ConcurrentLinkedQueue<Integer>();
        ConcurrentLinkedQueue<Integer> war_list2 = new ConcurrentLinkedQueue<Integer>();
        boolean flag_war = false;
        while(!que_cardp1.isEmpty() && !que_cardp2.isEmpty()){
        	int cardp1 = que_cardp1.poll();
        	int cardp2 = que_cardp2.poll();
        	if(cardp1>cardp2){
        		count++;
        		if(flag_war){
        			//a war just happened
        			que_cardp1.addAll(war_list1);
        			que_cardp1.add(cardp1);
        			que_cardp1.addAll(war_list2);
        			que_cardp1.add(cardp2);
        			//war ends
        			war_list1.clear();
        			war_list2.clear();
        			flag_war = false;
        		}else{
        			que_cardp1.add(cardp1);
            		que_cardp1.add(cardp2);
        		}
        		
        	}
        	else if(cardp1<cardp2){
        		count++;
        		if(flag_war){
        			//a war just happened
        			que_cardp2.addAll(war_list1);
        			que_cardp2.add(cardp1);
        			que_cardp2.addAll(war_list2);
        			que_cardp2.add(cardp2);
        			//war ends
        			war_list1.clear();
        			war_list2.clear();
        			flag_war = false;
        		}else{
            		que_cardp2.add(cardp1);
            		que_cardp2.add(cardp2);
        		}

        	}
        	else if(cardp1 == cardp2){
        		
        		if(que_cardp1.size()<3 || que_cardp2.size()<3){
        			System.out.println("PAT");
        			return;
        		}
        		
        		//war
        		flag_war = true;
        		war_list1.add(cardp1);
        		war_list1.add(que_cardp1.poll());
        		war_list1.add(que_cardp1.poll());
        		war_list1.add(que_cardp1.poll());
        		
        		war_list2.add(cardp2);
        		war_list2.add(que_cardp2.poll());
        		war_list2.add(que_cardp2.poll());
        		war_list2.add(que_cardp2.poll());
        	}
        	else{
        		System.err.println("it should not be 1..");
        	}
        }

        if(que_cardp1.isEmpty() && !que_cardp2.isEmpty()){
        	System.out.println("2 "+count);
        }else if(que_cardp2.isEmpty() && !que_cardp1.isEmpty()){
        	System.out.println("1 "+count);
        }else if(que_cardp2.isEmpty() && que_cardp1.isEmpty()){
        	System.err.println("it should not be 2..");
        }else{
        	System.err.println("it should not be 3..");
        }
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
    }
	
	static int convert(String input){
		switch(input){
		case "2":
			return 2;
		case "3":
			return 3;
		case "4":
			return 4;
		case "5":
			return 5;
		case "6":
			return 6;
		case "7":
			return 7;
		case "8":
			return 8;
		case "9":
			return 9;
		case "10":
			return 10;
		case "J":
			return 11;
		case "Q":
			return 12;
		case "K":
			return 13;
		case "A":
			return 14;
			default:
				return 15;
		}
	}

}
