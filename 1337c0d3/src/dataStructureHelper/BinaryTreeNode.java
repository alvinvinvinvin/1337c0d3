package dataStructureHelper;

public class BinaryTreeNode {
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	private int value;
	
	public BinaryTreeNode(BinaryTreeNode left, BinaryTreeNode right, int value){
		this.left = left;
		this.right = right;
		this.value = value;
	}
	
	public BinaryTreeNode getLeft(){
		return this.left;
	}
	public BinaryTreeNode getRight(){
		return this.right;
	}
	public int getValue(){
		return this.value;
	}
	
	public BinaryTreeNode findNode(BinaryTreeNode root, int value){
		while(root != null){
			int currentValue = root.getValue();
			if(currentValue == value) break;
			if(currentValue < value) root = root.getRight();
			if(currentValue > value) root = root.getLeft();
		}
		return root;
	}
	
	public BinaryTreeNode findNodeRecursively(BinaryTreeNode root, int value){
		if(root == null) return root;
		int currentValue = root.getValue();
		if(currentValue == value) return root;
		if(currentValue < value) return findNodeRecursively(root.getRight(), value);
		if(currentValue > value) return findNodeRecursively(root.getLeft(), value);
		return root;
	}
}
