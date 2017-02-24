/**
 * Your virus has caused a backdoor to open on the Skynet network 
 * enabling you to send new instructions in real time.

You decide to take action by stopping Skynet from communicating 
on its own internal network.

Skynet's network is divided into several smaller networks, in each 
sub-network is a Skynet agent tasked with transferring information 
by moving from node to node along links and accessing gateways leading to other sub-networks.

Your mission is to reprogram the virus so it will sever links in 
such a way that the Skynet Agent is unable to access another 
sub-network thus preventing information concerning the presence 
of our virus to reach Skynet's central hub.
 	Rules

For each test you are given:
A map of the network.
The position of the exit gateways.
The starting position of the Skynet agent.
>>> Nodes can only be connected to up to a single gateway. <<<

Each game turn:
First off, you sever one of the given links in the network.
Then the Skynet agent moves from one Node to another accessible Node.

Skynet agent

Gateway
 
Victory Conditions
The Skynet agent cannot reach an exit gateway
 
Lose Conditions
The Skynet agent has reached a gateway
 	Example

4 4 1
0 1
0 2
1 3
2 3
3
Initialization input
 
Text representation of the network used in this example. 
There are 4 nodes, 4 links and 1 gateway. The next 4 lines 
describe the links. The last integer is the index of the exit node.

Turn 1
The Skynet agent starts at node 0 (SI = 0). Our virus cut 
the link between the nodes 1 and 3.

Turn 2
The Skynet agent moves to node 2 (SI = 2). Our virus cut the 
link between the nodes 2 and 3.

Turn 3
The Skynet agent has been cut off from the exit, you have won !
 	Note

The tests provided are similar to the validation tests used 
to compute the final score but remain different.
 	Game Input

The program must first read the initialization data from 
standard input. Then, within an infinite loop, read the data 
from the standard input related to the current state of the 
Skynet agent and provide to the standard output the next instruction.
Initialization input
Line 1: 3 integers N L E
- N, the total number of nodes in the level, including the gateways.
- L, the number of links in the level.
- E, the number of exit gateways in the level.

Next L lines: 2 integers per line (N1, N2), indicating a link 
between the nodes indexed N1 and N2 in the network.

Next E lines: 1 integer EI representing the index of a gateway node.

Input for one game turn
Line 1: 1 integer SI, which is the index of the node on which 
the Skynet agent is positioned this turn.
Output for one game turn
A single line comprised of two integers C1 and C2 separated by 
a space. C1 and C2 are the indices of the nodes you wish to sever the link between.
Constraints
2 ≤ N ≤ 500
1 ≤ L ≤ 1000
1 ≤ E ≤ 20
0 ≤ N1, N2 < N
0 ≤ SI < N
0 ≤ C1, C2 < N
Response time per turn ≤ 150ms
SKYNET FINALE - LEVEL 1

Los Angeles 2029 - Resistance HQ - Review of facts:

Last Saturday, hundreds of brave fighters risked their lives to destroy Skynet. STOP

Using contaminated Moto-Terminators, they managed to inoculate a lethal virus to Skynet. STOP

Problem: Skynet is fighting back. STOP

John, once more, we need your help. STOP
 */
package skynetRevolutionEpisode1;

/**
 * @author han.chen
 *
 */

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        int[] arr_ns = new int[L*2];
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            arr_ns[i] = N1;
            arr_ns[i+L] = N2;
        }
        Set<Integer> set_ei = new HashSet<Integer>();
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            set_ei.add(EI);
        }
        Stack<Integer> stack_gate = new Stack<Integer>();
        for(int i = 0; i<L*2; i++){
        	if(set_ei.contains(arr_ns[i])){
        		if(i < L){
        			stack_gate.push(arr_ns[i]);
        			stack_gate.push(arr_ns[i+L]);
        		}else{
        			stack_gate.push(arr_ns[i]);
        			stack_gate.push(arr_ns[i-L]);
        		}
        	}
        }
        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn
            find(SI, arr_ns, set_ei, L, stack_gate);
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // Example: 0 1 are the indices of the nodes you wish to sever the link between
        }
    }
	
	static void find(int SI, int[] arr_ns, Set<Integer> set_ei, int L, Stack<Integer> stack_gate){
		for(int i = 0; i<L*2;i++){
			if(arr_ns[i] == SI){
				if(i<L){
					if(set_ei.contains(arr_ns[i+L])){
						System.out.println(SI+" "+arr_ns[i+L]);
						return;
					}else{
						continue;
					}	
				}else{
					if(set_ei.contains(arr_ns[i-L])){
						System.out.println(arr_ns[i-L]+" "+SI);
						return;
					}else{
						continue;
					}
				}
			}
		}
		if(!stack_gate.isEmpty())
		System.out.println(stack_gate.pop()+" "+stack_gate.pop());
				
	}

}
