package binarytree;

public class BTNode {
	
	int data;
	BTNode left;
	BTNode right;
	
	public BTNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public int getData() {
		return this.data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public BTNode getLeftChild() {
		return this.left;
	}
	
	public void setLeftChild(BTNode left) {
		this.left = left;
	}
	
	public BTNode getRightChild() {
		return this.right;
	}
	
	public void setRightChild(BTNode right) {
		this.right = right;
	}
}
