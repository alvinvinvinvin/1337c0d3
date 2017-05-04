package dataStructureHelper;
/**   
* Filename:    TreeNode.java   
* Copyright:   Copyright (c)2014  
* Company:   UWL
* @author: Han Chen
* @version:    1.0   
* @since:  JDK 1.7
* Create at:   Oct 31, 2014 2:38:29 PM   
* Description:  
*   The definition of TreeNode.
* Modification History:   
* Date    Author      Version     Description   
* ----------------------------------------------------------------- 
* Oct 31, 2014 Han Chen      1.0     1.0 Version   
*/   
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode (int x){ this.val = x; }
	public TreeNode(){}
	public TreeNode create(int[] input, int index){
		if(index > input.length-1 || input[index] < 0){
			return null;
		}
		TreeNode tmp = new TreeNode(input[index]);
		tmp.left = create(input, 2*index+1);
		tmp.right = create(input, 2*index+2);
		return tmp;
	}
	
	
	public void inorder(TreeNode root){
		if(root == null){
			System.out.print("null ");
			return;
		}
		inorder(root.left);
		System.out.print(root.val+" ");
		inorder(root.right);
	}
	
	public void preorder(TreeNode root){
		if(root == null){
			System.out.print("null ");
			return;
		}
		System.out.print(root.val+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public void postorder(TreeNode root){
		if(root == null){
			System.out.print("null ");
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.val+" ");
	}
	
}
 