package binarytree;

public class InsertIntoBST {
	public BTNode insert(BTNode root, int data) {
		if(root == null) {
			root = new BTNode(data);
			return root;
		}
		if(root.data < data) {
			root.right = insert(root.right, data);
		}
		else if(root.data > data) {
			root.left = insert(root.left, data);
		}
		return root;
	}
}
