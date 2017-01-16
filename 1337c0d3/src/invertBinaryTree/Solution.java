package invertBinaryTree;

import dataStructureHelper.TreeNode;

/**
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew),
 but you can'n invert a binary tree on a whiteboard so fuck off.
 */


public class Solution {
	public TreeNode invertBinaryTree(TreeNode root){
		if(root != null){
			TreeNode tempNode = root.left;
			root.left = root.right;
			root.right = tempNode;
			invertBinaryTree(root.left);
			invertBinaryTree(root.right);
		}
		return root;
	}
}
