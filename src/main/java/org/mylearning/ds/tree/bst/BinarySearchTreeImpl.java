package org.mylearning.ds.tree.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTreeImpl {

	private static int level = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int rootData = getNextElement(scanner);
		
		BinarySearchTree rootNode = new BinarySearchTree();
		rootNode.data = rootData;
		
		int newData = getNextElement(scanner);
		while(newData != -1) {
			insertBSTElement(newData, rootNode);
			newData = getNextElement(scanner);
		}
		System.out.print("Levelorder: ");
		levelorderTraversalBST(rootNode);
		
		System.out.println("\nPreorder: ");
		preorderTraversalBST(rootNode);
		System.out.println("Inorder: ");
		inorderTraversalBST(rootNode);
//		printTree(rootNode);
		System.out.println("Postorder: ");
//		System.out.println(level);
		postorderTraversalBST(rootNode);
	}

	private static BinarySearchTree insertBSTElement(int newData, BinarySearchTree rootNode) {

		if (rootNode == null) {
			rootNode = new BinarySearchTree();
			rootNode.data = newData;
			level++;
		} else if (rootNode.data > newData) {
			rootNode.leftNode = insertBSTElement(newData, rootNode.leftNode);
		} else if (rootNode.data < newData) {
			rootNode.rightNode = insertBSTElement(newData, rootNode.rightNode);
		} else {
			System.out.println("BAD DATA: Duplicates are not allowed in the Binary Search Tree: " + newData);
		}
		return rootNode;
	}

	private static int getNextElement(Scanner scanner) {
		while (!scanner.hasNextInt()) {
			scanner.next();
		}
		return scanner.nextInt();
	}

	private static void preorderTraversalBST(BinarySearchTree node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preorderTraversalBST(node.leftNode);
		preorderTraversalBST(node.rightNode);
	}

	private static void inorderTraversalBST(BinarySearchTree node) {
		if (node == null)
			return;
		inorderTraversalBST(node.leftNode);
		System.out.print(node.data + " ");
		inorderTraversalBST(node.rightNode);
	}

	private static void postorderTraversalBST(BinarySearchTree node) {
		if (node == null)
			return;
		postorderTraversalBST(node.leftNode);
		postorderTraversalBST(node.rightNode);
		System.out.print(node.data + " ");
	}

	private static void levelorderTraversalBST(BinarySearchTree node) {
		if (node == null)
			return;
		Queue<BinarySearchTree> q = new LinkedList<BinarySearchTree>();

		System.out.print(node.data + " ");
		q.add(node);
		while (!q.isEmpty()) {
			BinarySearchTree n = q.poll();
			BinarySearchTree leftNode = n.leftNode;
			if (leftNode != null) {
				System.out.print(leftNode.data + " ");
				q.add(leftNode);
			}
			BinarySearchTree rightNode = n.rightNode;
			if (rightNode != null) {
				System.out.print(rightNode.data + " ");
				q.add(rightNode);
			}
		}

	}

	private static void printTree(BinarySearchTree node) {
		if (node == null)
			return;
		Queue<BinarySearchTree> q = new LinkedList<BinarySearchTree>();
		int temp = level;
		for (int i = 0; i < temp; i++)
			System.out.print("\t");
		System.out.println(node.data + " ");
		temp--;
		q.add(node);
		while (!q.isEmpty()) {
			BinarySearchTree n = q.poll();
			BinarySearchTree leftNode = n.leftNode;
			for (int i = 0; i < temp; i++)
				System.out.print("\t");
			if (leftNode != null) {
				System.out.print(leftNode.data + " ");
				q.add(leftNode);
			}
			BinarySearchTree rightNode = n.rightNode;
			if (rightNode != null) {
				System.out.print(rightNode.data + " ");
				q.add(rightNode);
			}
			System.out.println();
			temp--;
		}

	}
}
