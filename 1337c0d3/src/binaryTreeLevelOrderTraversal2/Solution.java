/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */

package binaryTreeLevelOrderTraversal2;
import dataStructureHelper.*;
import java.util.*;
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root == null) return res;
        
        queue.offer(root);
        while(!queue.isEmpty()){
        	int level = queue.size();
        	List<Integer> sub_list = new LinkedList<Integer>();
        	for(int i = 0; i<level;i++){
        		if(queue.peek().left != null) queue.offer(queue.peek().left);
        		if(queue.peek().right != null) queue.offer(queue.peek().right);
        		sub_list.add(queue.poll().val);
        	}
        	res.add(0,sub_list);
        }
        
        return res;
    }
}
