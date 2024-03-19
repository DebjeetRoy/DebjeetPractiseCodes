package com.dev.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTree { //TC = O(n)
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	static class BinaryTreeStruct {
		static int idx = -1;
		public static Node buildTree(int[] nodes) {
			idx++;
			
			if(nodes[idx] == -1) {
				return null;
			}
			Node newNode = new Node(nodes[idx]);
			newNode.left  = buildTree(nodes);
			newNode.right = buildTree(nodes);
			return newNode;
		}
	}
	
	public static void preorder(Node root){ //O(n)
		//base case
		if(null == root) {
			return;
		} 
		System.out.print(root.data+" ");
		preorder(root.left); //left subtree
		preorder(root.right); //right subtree
	}
	
	public static void inorder(Node root){ //O(n)
		//base case
		if(null == root) {
			return;
		} 
		inorder(root.left); //left subtree
		System.out.print(root.data+" ");
		inorder(root.right); //right subtree
	}
	
	public static void postorder(Node root){ //O(n)
		//base case
		if(null == root) {
			return;
		} 
		postorder(root.left); //left subtree
		postorder(root.right); //right subtree
		System.out.print(root.data+" ");
	}
	
	/*
	 * Level order Traversal
	 */
	public static void levelorder(Node root){ //O(n)
		//base case
		if(null == root) {
			return;
		} 
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node currNode = q.remove();
			
			if(currNode == null) {
				System.out.println();
				if(q.isEmpty()) {
					break;
				} else {
					q.add(null);
				}
			} else {
				System.out.print(currNode.data+" ");
				
				if(null != currNode.left) {
					q.add(currNode.left);
				}
				if(null != currNode.right) {
					q.add(currNode.right);
				}
			}
		}
	}
	
	/*
	 * height of a binary tree
	 */
	public static int height(Node root){
		//base case
		if(null == root) {
			return 0;
		}
		int lh = height(root.left);
		int rh = height(root.right);
		
		return Math.max(lh, rh)+1;	
	}
	
	/*
	 * Counting nodes of a binary tree
	 */
	public static int countNodes(Node root) {
		//base case
		if(null == root) {
			return 0;
		}
		int ln = countNodes(root.left);
		int rn = countNodes(root.right);
		
		return ln+rn+1;
	}
	
	/*
	 * Sum of nodes of a binary tree
	 */
	public static int sumNodes(Node root) {
		//base case
		if(null == root) {
			return 0;
		}
		
		int ln = sumNodes(root.left);
		int rn = sumNodes(root.right);
		
		return ln+rn+root.data;
	}
	
	/*
	 * Diameter of root
	 */
	public static int diameter(Node root) { //TC = O(n^2)
		//Base case
		if(null == root) {
			return 0;
		}
		
		int leftDiameter  = diameter(root.left);
		int leftHeight    = height(root.left);
		int rightDiameter = diameter(root.right);
		int rightHeight   = height(root.right);
		int selfDiameter  = leftHeight+rightHeight+1;
		
		int finalHeight = Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
		
		return finalHeight;
	}
	
	static class Info {
		int dia;
		int ht;
		public Info(int dia, int ht) {
			this.dia = dia;
			this.ht = ht;
		}
	}
	
	/*
	 * Storing topview data for horizontal data of a node
	 */
	static class InfoTopView {
		Node node;
		int  horizontalDist;
		
		public InfoTopView(Node n, int hd) {
			this.node = n;
			this.horizontalDist = hd;
		}
	}
	
	/*
	 * Finding Diameter of a tree with O(n) time complexity
	 */
	public static Info diameter1(Node root) { //TC = O(n)
		//Base case
		if(null == root) {
			return new Info(0, 0);
		}
		
		Info rightInfo = diameter1(root.right);
		Info leftInfo = diameter1(root.left);
		
		int dia = Math.max(Math.max(rightInfo.dia, leftInfo.dia), rightInfo.ht+leftInfo.ht+1);
		int ht  = Math.max(rightInfo.ht, leftInfo.ht)+1;
		
		return new Info(dia, ht);
	}
	
	/*
	 * Checking whether subtree is a part of a tree or not.
	 */
	public static boolean isSubtree(Node root, Node subroot) {
		if(root == null) {
			return false;
		}
		
		if(root.data == subroot.data) {
			if(isIdentical(root, subroot)) {
				return true;
			}
		}
		
		return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
	}
	
	/*
	 * Checking whether the subtree is identical or not.
	 */
	private static boolean isIdentical(Node root, Node subroot) {
		if(root == null && subroot == null) {
			return true;
		} else if(root == null || subroot == null || root.data != subroot.data) {
			return false;
		}
		
		if(!isIdentical(root.left, subroot.left)) {
			return false;
		}
		if(!isIdentical(root.right, subroot.right)) {
			return false;
		}
		
		return true;
	}
	
	/*
	 * Top view of a Binary Tree business logic
	 */
	public static void topView(Node root) {
		//Level order
		Queue<InfoTopView> q = new LinkedList<>();
		Map<Integer, Node> map = new HashMap<>();
		
		int min = 0, max = 0;
		q.add(new InfoTopView(root, 0));
		q.add(null);
		
		while(!q.isEmpty()) {
			InfoTopView curr = q.remove();
			if(curr == null) {
				if(q.isEmpty()) {
					break;
				} else {
					q.add(null);
				}
			} else {
				if(!map.containsKey(curr.horizontalDist)) { //first time any HD is occuring
					map.put(curr.horizontalDist, curr.node);
				}
				
				if(curr.node.left != null) {
					q.add(new InfoTopView(curr.node.left, curr.horizontalDist-1));
					min = Math.min(min, curr.horizontalDist-1);
				}
				if(curr.node.right != null) {
					q.add(new InfoTopView(curr.node.right, curr.horizontalDist+1));
					max = Math.max(max, curr.horizontalDist+1);
				}
			}
		}
		
		for(int i=min; i<=max; i++) {
			System.out.print(map.get(i).data+" ");
		}
		System.out.println();
	}
	
	/*
	 * Kth level data with preorder recursion process.
	 */
	public static void kLevel(Node root, int level, int k) { //TC = O(n) as all nodes are touched once
		if(null == root) {
			return;
		}
		if(level == k) {
			System.out.print(root.data+" ");
			return;
		}
		
		kLevel(root.left, level+1, k);
		kLevel(root.right, level+1, k);
	}
	
	/*
	 * FInding node in subtrees
	 */
	public static boolean getPath(Node root, int n, List<Node> path) {
		if(root == null) {
			return false;
		}
		
		path.add(root);
		
		if(root.data == n) {
			return true;
		}
		
		boolean foundLeft = getPath(root.left, n, path);
		boolean foundRight = getPath(root.right, n, path);
		
		if(foundLeft || foundRight) {
			return true;
		}
		
		path.remove(path.size()-1);
		return false;
	}
	
	/*
	 * To find Lowest Common Ancestor.
	 */
	public static Node lca(Node root, int n1, int n2) { //TC = O(n), SC = O(n)
		List<Node> path1 = new ArrayList<>();
		List<Node> path2 = new ArrayList<>();
		
		getPath(root, n1, path1);
		getPath(root, n2, path2);
		
		//last common ancestor
		int i=0;
		for(; i<path1.size() && i<path2.size(); i++) {
			if(path1.get(i) != path2.get(i)){
				break;
			}
		}
		//last equal node is at n-1 position
		Node lca = path1.get(i-1);
		return lca;
 	}

	/*
	 * Optimized solution to calcualate Lowest Common ancestor to reduce Space complexity to O(1)
	 */
	public static Node lcaOptimized(Node root, int n1, int n2) { //TC = O(n), SC = O(1)
		
		if(null == root || root.data == n1 || root.data == n2) {
			return root;
		}
		
		Node leftLca = lcaOptimized(root.left, n1, n2);
		Node rightLca = lcaOptimized(root.right, n1, n2);
		
		if(rightLca == null) {
			return leftLca;
		}
		if(leftLca == null) {
			return rightLca;
		}
		
		return root;
	}
	
	/*
	 * Finding min distance between 2 nodes
	 */
	public static int minDist(Node root, int n1, int n2) {
		if(null == root) {
			return -1;
		}
		
		Node lca = lca(root, n1, n2);
		int dist1 = lcaDist(lca,n1);
		int dist2 = lcaDist(lca,n2);
		
		return dist1+dist2;
	}

	/*
	 * Find distance from LCA to node 1 and node 2
	 */
	public static int lcaDist(Node root, int n) {
		if(null == root) {
			return -1;
		}
		if(root.data == n) {
			return 0;
		}
		
		int leftDist = lcaDist(root.left,n);
		int rightDist = lcaDist(root.right,n);
		
		if(leftDist == -1 && rightDist == -1) {
			return -1;
		} else if(leftDist == -1) {
			return rightDist+1;
		}else {
			return leftDist+1;
		}
	}
	
	/*
	 * Find Kth Ancestor 
	 */
	public static int KAncestor(Node root, int n, int k) {
		if(root == null) {
			return -1;
		}
		if(root.data == n) {
			return 0;
		}
		
		int leftDist  = KAncestor(root.left, n, k);
		int rightDist = KAncestor(root.right, n, k);
		
		if(leftDist == -1 && rightDist == -1) {
			return -1;
		}
		
		int max = Math.max(leftDist, rightDist);
		if(max+1==k) {
			System.out.print(root.data);
		}
		return max+1;
	}
	
	public static int sumTree(Node root) {
		if(root == null) {
			return 0;
		}
		int leftChild  = sumTree(root.left);
		int rightChild = sumTree(root.right);
		
		int data = root.data;
		
		int newLeft = null != root.left ? root.left.data : 0;
		int newRight = null != root.right ? root.right.data : 0;
		root.data = newLeft + leftChild + newRight + rightChild;
		
		return data;
	}

	public static void main(String[] args) {
		int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		//BinaryTreeStruct binaryTree = new BinaryTreeStruct();
		
		Node root = BinaryTreeStruct.buildTree(nodes);
		System.out.println("Preorder Traversal -> ");
		//preorder(root);
		
		System.out.println();
		System.out.println("Inorder Traversal -> ");
		//inorder(root);
		
		System.out.println();
		System.out.println("Postorder Traversal -> ");
		//postorder(root);
		
		System.out.println();
		System.out.println("Levelorder Traversal -> ");
		//levelorder(root);
		//System.out.println("Root node data is -> "+root.data);
		
		/*
		 *       1
		 *      / \
		 *     2   3
		 *    / \ / \
		 *   4  5 6  7
		 */
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);
		root1.right.left = new Node(6);
		root1.right.right = new Node(7);
		
		System.out.println();
		System.out.println("Height of the binary tree is -> ");
		//System.out.print(height(root1));
		
		System.out.println();
		System.out.println("Count of nodes of given binary tree is -> ");
		//System.out.println(countNodes(root1));
		
		System.out.println();
		System.out.println("Sum of nodes data of given binary tree is -> ");
		//System.out.println(sumNodes(root1));
		
		System.out.println();
		System.out.println("Diameter of root of given binary tree with O(n^2) TC -> ");
		System.out.println(diameter(root1));
		
		System.out.println();
		System.out.println("Diameter of root of given binary tree with O(n) TC -> ");
		System.out.println(diameter1(root1).dia);
		System.out.println("Height of a given binary tree is : "+diameter1(root1).ht);
		
		/*
		 *     2  
		 *    / \ 
		 *   4   5 
		 *   
		 */
		System.out.println();
		Node subroot = new Node(2);
		subroot.left = new Node(4);
		subroot.right = new Node(5);
		System.out.println("Subtree Finder Result -> ");
		System.out.println(isSubtree(root1, subroot));
		
		System.out.println();
		System.out.println("Top view of current binary tree is :- ");
		topView(root1);
		
		System.out.println();
		int k=3;
		System.out.println("Kth level node values are :- ");
		kLevel(root1,1,k);
		
		System.out.println();
		System.out.println("Lowest Common Ancestor is :- ");
		
		int n1=4, n2=6;
		System.out.println(lca(root1, n1, n2).data);
		
		System.out.println("Optimized Lowest Common Ancestor is :- ");
		System.out.println(lcaOptimized(root1, n1, n2).data);
		
		System.out.println("Min distance between "+n1+" and "+n2+" is -> ");
		System.out.println(minDist(root1, n1, n2));
		
		int k1=1;
		System.out.println(k1+"th ancestor of a given nodes is :-");
		KAncestor(root1, n1, k1);
		
		/*
		 * Transform to sumtree
		 * 
		 * 		27
		 *     /  \
		 *    9    13
		 *   / \   / \
		 *  0  0  0   0  for root1
		 */
		System.out.println();
		System.out.println("SumTree Transformation -> ");
		sumTree(root1);
	    preorder(root1);
	}
}
