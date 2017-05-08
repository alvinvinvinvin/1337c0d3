/**
 * Given two non-empty binary trees s and t, 
 * check whether tree t has exactly the same 
 * structure and node values with a subtree of s. 
 * A subtree of s is a tree consists of a node in 
 * s and all of this node's descendants. 
 * The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure 
and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
 */
package subTreeOfAnotherTree;
import dataStructureHelper.*;
/**
 * @author han.chen
 *
 */
public class Solution {

	public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if(t == null) return true;
        if(areIdentical(s,t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean areIdentical(TreeNode a, TreeNode b){
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        return a.val == b.val 
        		&& areIdentical(a.left, b.left) 
        		&& areIdentical(a.right, b.right);
    }

}
