/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */
package binaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import dataStructureHelper.TreeNode;

/**
 * @author alvin
 *
 */
public class Solution {
	
	//Recursive way
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        addNode(result, root);
        return result;
    }
	public void addNode(List<Integer> list, TreeNode node){
		if(node == null){
			return;
		}
		addNode(list, node.left);//Add left child first
		list.add(node.val);//Then root value;
		addNode(list, node.right);//Last, add right child
	}
	
	//Iterative way
	public List<Integer> inorderTraversal2(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root != null){
			stack.push(root);
			root = root.left;//push left node to stack. Push the root first.
			while(root == null){//If it reaches the bottom
				if(stack.isEmpty()) return result;
				root = stack.pop();
				result.add(root.val);
				root = root.right;//if right child is null, stack will keep popping higher level left child. OW, this right child will be pushed to stack.
			}
		}
		return result;
	}
}
