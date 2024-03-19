package com.dev.dsa.BST;

public class DeleteInBST {
	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

	static Node deleteInBST(Node root, int key) {
		if (root == null)
			return null;

		if (key < root.data) {
			root.left = deleteInBST(root.left, key);
		} else if (key > root.data) {
			root.right = deleteInBST(root.right, key);
		} else {
			// Case:1 Node with single child and leaf node(node with no child)
			if (root.left == null) {
				return root.right;
			}
			if (root.right == null) {
				return root.left;
			}

			// Case: 2 Node with 2 children
			Node inorderSuccessor = findSmallest(root.right);
			root.data = inorderSuccessor.data;
			root.right = deleteInBST(root.right, inorderSuccessor.data);
		}
		return root;
	}

	// Finding inorder successor of root node which is minimum in right subtree
	static Node findSmallest(Node root) {
		Node temp = root;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}

	public static void main(String[] args) {
		Node n1 = new Node(8);
		Node n2 = new Node(3);
		Node n3 = new Node(10);
		Node n4 = new Node(1);
		Node n5 = new Node(6);
		Node n6 = new Node(14);
		Node n7 = new Node(4);
		Node n8 = new Node(7);

		Node root = n1;
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n6;
		n5.left = n7;
		n5.right = n8;

		System.out.println("Original BST :-");
		printInorder(root);
		int nodeToBeDeleted = 3;

		System.out.println();
		System.out.println("Modified BST after deleting " + nodeToBeDeleted + " is => ");
		deleteInBST(root, nodeToBeDeleted);
		printInorder(root);
	}
}
