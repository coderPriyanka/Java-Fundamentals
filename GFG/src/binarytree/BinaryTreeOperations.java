package binarytree;
import java.util.*;
public class BinaryTreeOperations {
	public static void main(String[] args) {
		BTNode root = new BTNode(1);
		root.left = new BTNode(2);
		root.left.left = new BTNode(4);
		root.left.left.right = new BTNode(5);
		root.left.left.right.left = new BTNode(6);
		root.left.right = new BTNode(7);
		root.left.right.right = new BTNode(8);
		root.right = new BTNode(3);
		root.right.left = new BTNode(9);
		root.right.right = new BTNode(10);
		root.right.right.right = new BTNode(12);
		System.out.println(minimumDepthOfBT(root));
	}
	public int oddEvenLevelSumDifference(BTNode root) {
		int oddSum = 0, evenSum = 0;
		int level = 0, count = 0, nodes = 0;
		Queue<BTNode> queue = new LinkedList<>();
		queue.add(root);
		count++;
		level++;
		while(!queue.isEmpty()) {
			BTNode curr = queue.remove();
			count--;
			if((level % 2) == 0) {
				evenSum+= curr.data;
			}
			else {
				oddSum+= curr.data;
			}
			if(curr.left != null) {
				queue.add(curr.left);
				nodes++;
			}
			if(curr.right != null) {
				queue.add(curr.right);
				nodes++;
			}
			if(count == 0) {
				count = nodes;
				nodes = 0;
				level++;
			}
		}
		return oddSum - evenSum;
	}
	
	public void printNodesAtDistance(BTNode root, int d) {
		if(root == null) {
			return;
		}
		if(d == 0) {
			System.out.println(root.data + " ");
			return;
		}
		printNodesAtDistance(root.left, d - 1);
		printNodesAtDistance(root.right, d - 1);
	}
	
	public int heightOfBinaryTree(BTNode root) {
		if(root == null) {
			return 0;
		}
		return Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right)) + 1;
	}
	
	public int numberOfNodesInBinaryTree(BTNode root) {
		if(root == null) {
			return 0;
		}
		return numberOfNodesInBinaryTree(root.left) + numberOfNodesInBinaryTree(root.right) + 1;
	}
	
	public boolean isIsomorphic(BTNode root1, BTNode root2) {
		if((root1 == null) && (root2 == null)) {
			return true;
		}
		if((root1 == null) || (root2 == null)) {
			return false;
		}
		if(root1.data != root2.data) {
			return false;
		}
		return (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right))
			  ||(isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left));
	}
	
	public int sumOfNodes(BTNode root) {
		if(root == null) {
			return 0;
		}
		return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
	}
	
	public boolean isSumTree(BTNode root) {
		if(root == null) {
			return false;
		}
		return (sum(root) == 2 * root.data) ? true : false;
	}
	
	public int sum(BTNode root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return root.data;
		}
		int val = sum(root.left) + sum(root.right);
		if(val == root.data) {
			return val + val;
		}
		return -1;
	}
	public BTNode LCA(BTNode root, BTNode n1, BTNode n2) {
		if(root == null) {
			return null;
		}
		if(root.data == n1.data || root.data == n2.data) {
			return root;
		}
		BTNode left = LCA(root.left, n1, n2);
		BTNode right = LCA(root.right, n1, n2);
		if(left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}
	public static int minimumDepthOfBT(BTNode root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 1;
		}
		int leftDepth = (root.left != null) ? 
				minimumDepthOfBT(root.left) : Integer.MAX_VALUE;
		int rightDepth = (root.right != null) ? 
				minimumDepthOfBT(root.right) : Integer.MAX_VALUE;
				
		return 1 + Math.min(leftDepth, rightDepth);
	}
}

