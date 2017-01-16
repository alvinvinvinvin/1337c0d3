package MaximumDepthOfBinaryTree;
import dataStructureHelper.TreeNode;

/**   
* Filename:    Solution.java   
* Copyright:   Copyright (c)2014  
* Company:   UWL
* @author: Han Chen
* @version:    1.0   
* @since:  JDK 1.7
* Create at:   Oct 31, 2014 2:26:13 PM   
* Description:  
*   Find the maximum depth of a binary tree.
* Modification History:   
* Date    Author      Version     Description   
* ----------------------------------------------------------------- 
* Oct 31, 2014 Han Chen      1.0     1.0 Version   
*/     
public class Solution {
	
	public static void main(String[] args){}
	
	public static int maxDepth(TreeNode root){
		if(root == null) return 0;
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		if(leftDepth>=rightDepth) return leftDepth+1;
		else return rightDepth+1;
	}

}
 