package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class Traversals {
	static int i = -1;
	public void inorder(BTNode root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	public void inorderUsingStack(BTNode root) {
		if(root == null) {
			return;
		}
		Stack<BTNode> stack = new Stack<>();
		stack.push(root);
		root = root.left;
		while(!stack.isEmpty() || root != null) {
			if(root == null) {
				root = stack.pop();
				System.out.print(root.data + " ");
				root = root.right;
			}
			else {
				stack.push(root);
				root = root.left;
			}
		}
	}
	public void morrisInorderTraversal(BTNode root) {
		BTNode curr = root;
		while(curr != null) {
			if(curr.left == null) {
				System.out.print(curr.data + " ");
				curr = curr.right;
			}
			else {
				BTNode predecessor = curr.left;
				while((predecessor.right != null) && (predecessor.right != curr)) {
					predecessor = predecessor.right;
				}
				if(predecessor.right == null) {
					predecessor.right = curr;
					curr = curr.left;
				}
				else {
					predecessor.right = null;
					System.out.print(curr.data + " ");
					curr = curr.right;
				}
			}
		}
	}
	
	
	public void preorder(BTNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}
	public void preorderUsingStack(BTNode root) {
		if(root == null) {
			return;
		}
		Stack<BTNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			root = stack.pop();
			System.out.print(root.data + " ");
			if(root.right != null) {
				stack.push(root.right);
			}
			if(root.left != null) {
				stack.push(root.left);
			}
		}
	}
	public void morrisPreorderTraversal(BTNode root) {
		BTNode curr = root;
		while(curr != null) {
			if(curr.left == null) {
				System.out.print(curr.data + " ");
				curr = curr.right;
			}
			else {
				BTNode predecessor = curr.left;
				while((predecessor.right != null) && (predecessor.right != curr)) {
					predecessor = predecessor.right;
				}
				if(predecessor.right == null) {
					predecessor.right = curr;
					System.out.print(curr.data + " ");
					curr = curr.left;
				}
				else {
					predecessor.right = null;
					curr = curr.right;
				}
			}
		}
	}
	
	
	public void postorder(BTNode root) {
		if(root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}
	public void postorderUsingOneStack(BTNode root) {
		Stack<BTNode> stack = new Stack<>();
		while(!stack.isEmpty() || root != null) {
			if(root != null) {
				stack.push(root);
				root = root.left;
			}
			else {
				BTNode temp = stack.peek().right;
				if(temp == null) {
					temp = stack.pop();
					System.out.print(temp.data + " ");
					while(!stack.isEmpty() && stack.peek().right == temp) {
						temp = stack.pop();
						System.out.print(temp.data + " ");
					}
				}
				else {
					root = temp;
				}
			}
		}
	}
	public void postorderUsingTwoStacks(BTNode root) {
		Stack<BTNode> s1 = new Stack<>();
		Stack<BTNode> s2 = new Stack<>();
		s1.push(root);
		while(!s1.isEmpty()) {
			root = s1.pop();
			if(root.left != null) {
				s1.push(root.left);
			}
			if(root.right != null) {
				s1.push(root.right);
			}
			s2.push(root);
		}
		while(!s2.isEmpty()) {
			System.out.print(s2.pop().data + " ");
		}
	}
	
	public void levelOrderTraversal(BTNode root) {
		if(root == null) {
			return;
		}
		Queue<BTNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BTNode curr = queue.remove();
			System.out.print(curr.data + " ");
			if(curr.left != null) {
				queue.add(curr.left);
			}
			if(curr.right != null) {
				queue.add(curr.right);
			}
		}
	}
	public void levelByLevelPrinting(BTNode root) {
		if(root == null) {
			return;
		}
		Queue<BTNode> queue = new LinkedList<>();
		queue.add(root);
		int count = 1, count2 = 0;
		while(!queue.isEmpty()) {
			BTNode curr = queue.remove();
			count--;
			System.out.print(curr.data + " ");
			if(curr.left != null) {
				queue.add(curr.left);
				count2++;
			}
			if(curr.right != null) {
				queue.add(curr.right);
				count2++;
			}
			if(count == 0) {
				System.out.println();
				count = count2;
				count2 = 0;
			}
		}
	}
	public void reverseLevelOrderTraversal(BTNode root) {
		if(root == null) {
			return;
		}
		Queue<BTNode> queue = new LinkedList<>();
		Stack<BTNode> stack = new Stack<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BTNode curr = queue.remove();
			stack.push(curr);
			if(curr.right != null) {
				queue.add(curr.right);
			}
			if(curr.left != null) {
				queue.add(curr.left);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop().data + " ");
		}
	}
	public void reverseLevelByLevelPrinting(BTNode root) {
		if(root == null) {
			return;
		}
		Queue<BTNode> queue = new LinkedList<>();
		Stack<BTNode> stack = new Stack<>();
		queue.add(root);
		int count = 1, count2 = 0;
		while(!queue.isEmpty()) {
			BTNode curr = queue.remove();
			count--;
			stack.push(curr);
			if(curr.right != null) {
				queue.add(curr.right);
				count2++;
			}
			if(curr.left != null) {
				queue.add(curr.left);
				count2++;
			}
			if(count == 0) {
				stack.push(null);
				count = count2;
				count2 = 0;
			}
		}
		while(!stack.isEmpty()) {
			if(stack.peek() == null) {
				System.out.println();
				stack.pop();
			}
			System.out.print(stack.pop().data + " ");
		}
	}
	
	public void postorderFromPreorderAndInorder(int[] preorder, int[] inorder, int start, int end) {
		i = i + 1;
		if(start > end) {
			return;
		}
		if(start == end) {
			System.out.print(inorder[start] + " ");
			return;
		}
		int mid = findRoot(inorder, start, end, preorder[i]);
		postorderFromPreorderAndInorder(preorder, inorder, start, mid-1);
		postorderFromPreorderAndInorder(preorder, inorder, mid+1, end);
		System.out.print(inorder[mid] + " ");
		
	}
	private int findRoot(int[] inorder, int start, int end, int value) {
		while(start <= end) {
			if(inorder[start] == value) {
				return start;
			}
			start++;
		}
		return start;
	}
	
	public void postorderTraversalFromPreorderOfBST(int[] preorder, int start, int end) {
		if(start > end) {
			return;
		}
		if(start == end) {
			System.out.print(preorder[start] + " ");
			return;
		}
		int mid = findMidPoint(preorder, start + 1, end, preorder[start]);
		postorderTraversalFromPreorderOfBST(preorder, start + 1, mid - 1);
		postorderTraversalFromPreorderOfBST(preorder, mid, end);
		System.out.print(preorder[start] + " ");
	}
	private int findMidPoint(int[] preorder, int start, int end, int value) {
		while(start <= end) {
			if(preorder[start] > value) {
				return start;
			}
			start++;
		}
		return 0;
	}
	
	public List<BTNode> replaceNodeWithSumOfInorderPredecessorAndSuccessor(BTNode root) {
		if(root == null) {
			return null;
		}
		List<BTNode> nodes = new ArrayList<>();
		Stack<BTNode> stack = new Stack<>();
		stack.push(root);
		root = root.left;
		while(!stack.isEmpty() || root != null) {
			if(root == null) {
				root = stack.pop();
				nodes.add(root);
				System.out.print(root.data + " ");
				root = root.right;
			}
			else {
				stack.push(root);
				root = root.left;
			}
		}
		if(nodes.size() == 1) {
			return nodes;
		}
		int temp = nodes.get(0).data;
		nodes.get(0).setData(nodes.get(1).data);
		int len = nodes.size() - 1;
		int i = 1;
		for(; i < len; i++) {
			int temp2 = nodes.get(i).data;
			nodes.get(i).setData(temp + nodes.get(i + 1).data);
			temp = temp2;
		}
		nodes.get(i).setData(temp);
		return nodes;
	}
	
	//TODO
	public void reverseTreePath(BTNode root, BTNode node) {
		if(root == node) {
			
		}
	}
	public void perfectBTSpecificLOT1(BTNode root) {
		if(root == null) {
			return;
		}
		if(root.left == null) {
			System.out.println(root.data);
			return;
		}
		Queue<BTNode> queue = new LinkedList<>();
		System.out.print(root.data + " ");
		queue.add(root.left);
		queue.add(root.right);
		while(!queue.isEmpty()) {
			BTNode n1 = queue.remove();
			System.out.print(n1.data + " ");
			BTNode n2 = queue.remove();
			System.out.print(n2.data + " ");
			if(n1.left == null) {
				continue;
			}
			queue.add(n1.left);
			queue.add(n2.right);
			queue.add(n1.right);
			queue.add(n2.left);
		}
	}
	public void perfectBTSpecificLOT2(BTNode root) {
		if(root == null) {
			return;
		}
		if(root.left == null) {
			System.out.println(root.data);
			return;
		}
		Queue<BTNode> queue = new LinkedList<>();
		Stack<BTNode> stack = new Stack<>();
		stack.push(root);
		queue.add(root.left);
		queue.add(root.right);
		while(!queue.isEmpty()) {
			BTNode n1 = queue.remove();
			BTNode n2 = queue.remove();
			stack.push(n2);
			stack.push(n1);
			if(n1.left == null) {
				continue;
			}
			queue.add(n1.right);
			queue.add(n2.left);
			queue.add(n1.left);
			queue.add(n2.right);
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop().data + " ");
		}
	}
	
	public void diagonalTraversalOfBT(BTNode root, int level, Map<Integer, Vector<Integer>> map) {
		if(root == null) {
			return;
		}
		Vector<Integer> values = map.get(level);
		if(values == null) {
			values = new Vector<>();
		}
		values.addElement(root.data);
		map.put(level, values);
		diagonalTraversalOfBT(root.left, level + 1, map);
		diagonalTraversalOfBT(root.right, level, map);
	}
	
	public void boundaryTraversal(BTNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		leftBoundary(root.left);
		printLeaves(root.left);
		printLeaves(root.right);
		rightBoundary(root.right);
	}
	private void leftBoundary(BTNode node) {
		if(node == null) {
			return;
		}
		if(node.left != null) {
			System.out.print(node.data + " ");
			leftBoundary(node.left);
		}
		else if(node.right != null) {
			System.out.print(node.data + " ");
			leftBoundary(node.right);
		}
	}
	private void printLeaves(BTNode node) {
		if(node == null) {
			return;
		}
		if(node.left == null && node.right == null) {
			System.out.print(node.data + " ");
			return;
		}
		printLeaves(node.left);
		printLeaves(node.right);
	}
	private void rightBoundary(BTNode node) {
		if(node == null) {
			return;
		}
		if(node.right != null) {
			rightBoundary(node.right);
			System.out.print(node.data + " ");
		}
		else if(node.left != null) {
			rightBoundary(node.left);
			System.out.print(node.data + " ");
		}
	}
}













