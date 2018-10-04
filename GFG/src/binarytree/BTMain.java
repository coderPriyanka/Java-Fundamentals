package binarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class BTMain {
	
	private static Traversals obj = new Traversals();

	public static void main(String[] args) {
		
		BTNode root = null;
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i < n; i++) {
			int data = in.nextInt();
			root = insertIntoBst(root, data);
		}
		System.out.println();
		inorder(root);
		System.out.println();
		preorder(root);
		System.out.println();
		postorder(root);
		System.out.println();
		levelOrderTraversal(root);
		System.out.println();
		int[] inorder = {4, 2, 5, 1, 3, 6};
		int[] preorder = {1, 2, 4, 5, 3, 6};
		int start = 0, end = inorder.length - 1;
		System.out.println("Postorder traversal from given inorder and preorder traversals is : ");
		postorderFromInorderAndPreorder(preorder, inorder, start, end);
		System.out.println();
		int[] preorderBST = {40, 30, 32, 35, 80, 90, 100, 120};
		end = preorderBST.length - 1;
		System.out.println("Postorder traversal from given preorder traversal of a BST : ");
		postorderFromPreorderOfBST(preorderBST, start, end);
		System.out.println();
		System.out.println("Boundary Traversal of the given BST : ");
		obj.boundaryTraversal(root);
		System.out.println();
		System.out.println("Diagonal traversal of BT : ");
		diagonalTraversal(root);
		System.out.println();
		
		//The Perfect Binary Tree (Tree 2)
		BTNode root2 = createTree2();
		
		System.out.println();
		System.out.println("The normal level order traversal of the perfect BT : ");
		levelOrderTraversal(root2);
		System.out.println();
		System.out.println("Specific Level order traversal of the perfect BT : ");
		obj.perfectBTSpecificLOT1(root2);
		System.out.println();
		System.out.println("Specific Level order trversal of perfect BT in reverse order : ");
		obj.perfectBTSpecificLOT2(root2);
		System.out.println();
		System.out.println("Boundary Traversal of the given BT : ");
		obj.boundaryTraversal(root2);
		System.out.println();
		System.out.println("Diagonal traversal of the Perfect BT : ");
		diagonalTraversal(root2);
		System.out.println();
		
		
		BTNode root3 = createTree3();
		System.out.println("Boundary Traversal of the given BT : ");
		obj.boundaryTraversal(root3);
		System.out.println();
		System.out.println("Diagonal traversal of the given BT : ");
		diagonalTraversal(root3);
		System.out.println();
		in.close();
	}

	private static void postorderFromPreorderOfBST(int[] preorderBST, int start, int end) {
		obj.postorderTraversalFromPreorderOfBST(preorderBST, start, end);
	}

	private static void postorderFromInorderAndPreorder(int[] preorder, int[] inorder, int start, int end) {
		obj.postorderFromPreorderAndInorder(preorder, inorder, start, end);
	}

	private static void levelOrderTraversal(BTNode root) {
		
		System.out.println("Level Order Traversal : ");
		obj.levelOrderTraversal(root);
		System.out.println();
		
		System.out.println("Level By Level Printig ");
		obj.levelByLevelPrinting(root);
		System.out.println();
		
		System.out.println("Reverse level order traversal : ");
		obj.reverseLevelOrderTraversal(root);
		System.out.println();
		
		System.out.print("Reverse Level By Level Printing : ");
		obj.reverseLevelByLevelPrinting(root);
		System.out.println();
		
	}

	private static void postorder(BTNode root) {
		
		System.out.println("Postorder using recursion : ");
		obj.postorder(root);
		System.out.println();
		
		System.out.println("Postorder using one stack : ");
		obj.postorderUsingOneStack(root);
		System.out.println();
		
		System.out.println("Postorder using two stack : ");
		obj.postorderUsingTwoStacks(root);
		System.out.println();
		
	}

	private static void preorder(BTNode root) {
		
		System.out.println("Preorder using recursion : ");
		obj.preorder(root);
		System.out.println();
		
		System.out.println("Preorder using stack : ");
		obj.preorderUsingStack(root);
		System.out.println();
		
		System.out.println("Preorder without stack and recursion : ");
		obj.morrisPreorderTraversal(root);
		System.out.println();
		
	}

	private static void inorder(BTNode root) {
		
		System.out.println("Inorder using recursion : ");
		obj.inorder(root);
		System.out.println();
		
		System.out.println("Inorder using stack : ");
		obj.inorderUsingStack(root);
		System.out.println();
		
		System.out.println("Inorder without stack and recursion : ");
		obj.morrisInorderTraversal(root);
		System.out.println();
		
	}
	


	private static void diagonalTraversal(BTNode root) {
		Map<Integer, Vector<Integer>> map = new HashMap<>();
		obj.diagonalTraversalOfBT(root, 0, map);
		Set<Integer> keys = map.keySet();
		Vector<Integer> list = null;
		for(Integer key : keys) {
			list = map.get(key);
			for(Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	private static BTNode insertIntoBst(BTNode root, int data) {
		InsertIntoBST obj = new InsertIntoBST();
		return obj.insert(root, data);
	}
	private static BTNode createTree2() {
		
		BTNode root2 = new BTNode(1);
		
		root2.left = new BTNode(2);
		root2.right = new BTNode(3);
		
		root2.left.left = new BTNode(4);
		root2.left.right = new BTNode(5);
		root2.right.left = new BTNode(6);
		root2.right.right = new BTNode(7);
		
		root2.left.left.left = new BTNode(8);
		root2.left.left.right = new BTNode(9);
		root2.left.right.left = new BTNode(10);
		root2.left.right.right = new BTNode(11);
		root2.right.left.left = new BTNode(12);
		root2.right.left.right = new BTNode(13);
		root2.right.right.left = new BTNode(14);
		root2.right.right.right = new BTNode(15);
		
		root2.left.left.left.left = new BTNode(16);
		root2.left.left.left.right = new BTNode(17);
		root2.left.left.right.left = new BTNode(18);
		root2.left.left.right.right = new BTNode(19);
		root2.left.right.left.left = new BTNode(20);
		root2.left.right.left.right = new BTNode(21);
		root2.left.right.right.left = new BTNode(22);
		root2.left.right.right.right = new BTNode(23);
		root2.right.left.left.left = new BTNode(24);
		root2.right.left.left.right = new BTNode(25);
		root2.right.left.right.left = new BTNode(26);
		root2.right.left.right.right = new BTNode(27);
		root2.right.right.left.left = new BTNode(28);
		root2.right.right.left.right = new BTNode(29);
		root2.right.right.right.left = new BTNode(30);
		root2.right.right.right.right = new BTNode(31);
		return root2;
	}
	

	private static BTNode createTree3() {
		
		BTNode root = new BTNode(20);
		
		root.left = new BTNode(8);
		root.right = new BTNode(22);
		
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(12);
		root.right.right = new BTNode(25);
		
		root.left.right.left = new BTNode(10);
		root.left.right.right = new BTNode(14);
		
		return root;
	}
}
