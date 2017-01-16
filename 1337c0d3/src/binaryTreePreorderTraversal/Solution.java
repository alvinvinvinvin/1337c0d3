/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
 */
package binaryTreePreorderTraversal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import dataStructureHelper.TreeNode;
/**
 * @author alvin
 *
 */
public class Solution {
	//Recursive way. Runtime 1 ms
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
        return result;
    }
    
    public void preorder(TreeNode node, List<Integer> result){
        if(node == null){
            return;
        }
        result.add(node.val);
        preorder(node.left, result);
        preorder(node.right, result);
    }
    
    //Iterative way. Runtime 2 ms
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> preorder = new Stack<TreeNode>();
        preorder.push(root);
        while(!preorder.empty()){
            TreeNode visitor = preorder.pop();
            result.add(visitor.val);
            if(visitor.right != null) preorder.push(visitor.right);//Notice the order here. 
            //We push right child to stack first, therefore the left child will pop out first.
            if(visitor.left != null) preorder.push(visitor.left);
        }
        return result;
    }
}
