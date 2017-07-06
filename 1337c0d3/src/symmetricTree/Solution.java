/**
 * 
 */
package symmetricTree;
import dataStructureHelper.*;
/**
 * @author e007777
 *
 */
public class Solution {
	public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode node1, TreeNode node2){
        // if both trees are empty, then they are mirror image
        if (node1 == null && node2 == null)
            return true;
  
        // For two trees to be mirror images, the following three
        // conditions must be true
        // 1 - Their root node's key must be same
        // 2 - left subtree of left tree and right subtree
        //      of right tree have to be mirror images
        // 3 - right subtree of left tree and left subtree
        //      of right tree have to be mirror images
        if(node1 != null && node2 != null && node1.val == node2.val){
            return helper(node1.left, node2.right) && helper(node1.right, node2.left);
        }
        return false;
    }
}
