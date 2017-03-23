/**
 * Given a binary search tree with non-negative values, 
 * find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the 
difference between 2 and 1 (or between 2 and 3).
Note: There are at least two nodes in this BST.
 */
package minimumAbsoluteDifferenceInBST;

import dataStructureHelper.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int res = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        getMini(root);
        return res;
    }
    
    public void getMini(TreeNode root){
        if(root == null) return;
        getMini(root.left);
        if(prev != null){
            res = Math.min(res, (root.val-prev.val));
        }
        prev = root;
        getMini(root.right);
    }
}