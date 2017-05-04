/**
 * 
 */
package binaryTreeTilt;
import dataStructureHelper.*;
/**
 * @author han.chen
 *
 */
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
	
	static int res = 0;
    static int sum = 0;
    public static int findTilt(TreeNode root) {
        if(root == null) return 0;
        int sum_left = getSum(root.left);
        sum = 0;
        int sum_right = getSum(root.right);
        sum = 0;
        res += Math.abs(sum_left - sum_right);
        findTilt(root.left);
        findTilt(root.right);
        return res;
    }
    
    public static int getSum(TreeNode root){
        if(root == null) return 0;
        sum += root.val;
        getSum(root.left);
        getSum(root.right);
        return sum;
    }
    
    public static int findTilt1(TreeNode root){
    	if(root == null) return 0;
    	helper(root);
    	return res;
    }
	
    public static int helper(TreeNode root){
    	if(root == null) return 0;
    	int left = helper(root.left);
    	int right = helper(root.right);
    	res += Math.abs(left - right);
    	return left+right+root.val;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,3,4,5,6,-1,10};
		TreeNode root2 = new TreeNode().create(input, 0);
		root2.inorder(root2);
		System.out.println("\n=======inorder=========");
		root2.preorder(root2);
		System.out.println("\n=======preorder=========");
		root2.postorder(root2);
		System.out.println("\n=======postorder=========");
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(getSum(root2));
		System.out.println(findTilt1(root2));
	}

}
