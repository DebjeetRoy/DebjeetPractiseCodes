package com.dev.binaryTree;

import java.util.ArrayList;

import java.util.ArrayList;

class Node {
	int data;
	Node left;
	Node right;
	
	public Node(int val) {
		this.data = val;
		this.left = this.right = null;
	}
}

/*
 * Inserting into BST
 */
public class BinarySearchTree {
	public static Node buildBST(Node root, int val) {
		if(root == null) {
			root = new Node(val);
			return root;
		}
		if(root.data > val) {
			root.left = buildBST(root.left, val);
		} else if(root.data < val) {
			root.right = buildBST(root.right, val);
		}
		return root;
	}	
	
	public static void inorder(Node root) {
		if(null == root) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data+" ");
	    inorder(root.right);
	}
	
	public static boolean search(Node root, int key) { // TC = O(H)
		if(null == root) {
			return false;
		}
		if(root.data == key) {
			return true;
		}
		
		if(key < root.data) {
			return search(root.left, key);
		} else {
			return search(root.right, key);
		}
		
	}
	
	/*
	 * Function to delete Node
	 */
	public static Node delete(Node root, int val) {
		if(val > root.data) {
			root.right = delete(root.right, val);
		} else if(val < root.data) {
			root.left = delete(root.left, val);
		} else {
			// Case-1 For leaf nodes
			if(root.left == null && root.right == null) {
				return null;
			}
			
			// Case-2 Node having one child
			if(root.left == null) {
				return root.right;
			}
			else if(root.right == null) {
				return root.left;
			}
			
			Node IS = findInorderSuccessor(root.right); //Left most node in right subtree.
			root.data = IS.data;
			
			root.right = delete(root.right, IS.data);
		}
		return root;
	}
	
	public static void printInRange(Node root, int k1, int k2) {
		if(root == null) {
			return;
		}
		if(root.data >= k1 && root.data <= k2) {
			printInRange(root.left, k1, k2);
			System.out.print(root.data+" ");
			printInRange(root.right, k1, k2);
		} else if(root.data < k1) {
			printInRange(root.left, k1, k2);
		} else {
			printInRange(root.right, k1, k2);
		}
	}
	
	private static Node findInorderSuccessor(Node root) {
		while(root.left != null) {
			root = root.left;
		}
		return root;
	}
	
	/*
	 * Function to print all nodes path from root to leaf possible using Backtrack mechanism.
	 */
	public static void printToLeaf(Node root, ArrayList<Integer> path) {
		if(null == root) {
			return;
		}
		/*
		 * Preorder
		 */
		path.add(root.data);
		
		if(root.left == null && root.right == null) {
			printPath(path);
		}
		
		printToLeaf(root.left, path);
		printToLeaf(root.right, path);
		path.remove(path.size()-1);
	}

	/*
	 * Printing path for tracking the path from root to leaf
	 */
	private static void printPath(ArrayList<Integer> path) {
		for(int i=0; i<path.size(); i++) {
			System.out.print(path.get(i) + " -> ");
		}
		System.out.println("NULL"); // At the end of the path it will point to NULL
	}
	
	/*
	 * Validating whether the given BST is correct or not
	 */
	public static boolean isBst(Node root, Node min, Node max) {
		if(root == null) {
			return true;
		}
		
		if(min != null && root.data < min.data) {
			return false;
		}
		else if(max != null && root.data > max.data) {
			return false;
		} 	
		return isBst(root.left, min, root) && isBst(root.right, root, max);
	}
	
	public static Node mirrorBST(Node root) { //O(n)
		if(root == null) {
			return null;
		}
		Node leftMirror = mirrorBST(root.left);
		Node rightMirror = mirrorBST(root.right);
		
		root.right = leftMirror;
		root.left = rightMirror;
		
		return root;
	}

	private static void preorder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}

	public static void main(String[] args) { // TC = O(ht of tree) generally its O(log n) except
		//for skew its O(n)
		
		//int[] values = {5,1,3,4,2,7};
		//int[] values = {8,5,3,1,4,6,10,11,14}; // Specially taken for Deleting a node
		int[] values = {5,1,3,4,2,7};
		Node root = null;
		
		System.out.println("Inserting into BST -> ");
		for(int i=0; i<values.length; i++) {
			root = buildBST(root, values[i]);
		}
		
		System.out.println("Validating data");
		inorder(root);
//		
//		System.out.println(" ");
//		if(search(root, 7)) {
//			System.out.println("Node found !!");
//		} else {
//			System.out.println("Node not found !!");
//		}
//		
//		int nodeToDelete = 6;
//		System.out.println();
//		System.out.println("Deleting node "+nodeToDelete);
//		//root = delete(root, nodeToDelete);
//		//inorder(root);
//		
//		System.out.println();
//		int range1 = 5;
//		int range2 = 12;
//		
//		System.out.println("Node data between "+range1+" and "+range2+" is ->");
//		printInRange(root, range1, range2);
//		
//		System.out.println();
//		System.out.println("Paths between root till leaf nodes -> ");
//		printToLeaf(root, new ArrayList<>());
		
		System.out.println();
		
		/*
		 *       8
		 *      / \
		 *     5  10
		 *    / \   \
		 *   3   6   11
		 * 
		 */
		Node root1 = new Node(8);
		root1.left = new Node(5);
		root1.left.left = new Node(3);
		root1.left.right = new Node(6);
		root1.right = new Node(10);
		root1.right.right = new Node(11);
		
		System.out.println();
		System.out.println("Validating BST -> ");
		if(isBst(root1, null, null)) {
			System.out.println("Valid BST");
		} else {
			System.out.println("Not a valid BST");
		}
		
		/*
		 *       8
		 *      / \
		 *     10  5
		 *    /   / \
		 *   11  6   3
		 * 
		 * 
		 */
		System.out.println("Mirror BST -> ");
		mirrorBST(root1);
		preorder(root1);
	}
}
