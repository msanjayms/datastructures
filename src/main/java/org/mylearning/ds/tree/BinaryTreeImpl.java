package org.mylearning.ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeImpl {

	private BinaryTree rootNode;
	private Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
	static Scanner scanner = new Scanner(System.in);

	/*
	 * public static void main(String[] args) { int i = scanForInput();
	 * 
	 * System.out.println(i); }
	 */

	public static void main(String[] args) {

		BinaryTreeImpl btImpl = new BinaryTreeImpl();

		// boolean hasNextInt = scanner.hasNextInt();

		System.out.print("Please add root Node element: ");
		int i = scanForInput();
		if (i > 0) {
			btImpl.rootNode = new BinaryTree();
			btImpl.rootNode.data = i;
			// rootNode.data = i;
			btImpl.queue.add(btImpl.rootNode);
		}
		btImpl.processBinaryTree();

		System.out.println("Printing Pre-Order Tranvesal:");
		preorderTraversalBT(btImpl.rootNode);
		System.out.println();
		System.out.println("Printing In-Order Tranvesal:");
		inorderTraversalBT(btImpl.rootNode);
		System.out.println();
		System.out.println("Printing Post-Order Tranvesal:");
		postorderTraversalBT(btImpl.rootNode);
		System.out.println();
	}

	private static void preorderTraversalBT(BinaryTree node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preorderTraversalBT(node.leftNode);
		preorderTraversalBT(node.rightNode);
	}
	
	private static void inorderTraversalBT(BinaryTree node) {
		if (node == null)
			return;
		inorderTraversalBT(node.leftNode);
		System.out.print(node.data + " ");
		inorderTraversalBT(node.rightNode);
	}
	
	private static void postorderTraversalBT(BinaryTree node) {
		if (node == null)
			return;
		postorderTraversalBT(node.leftNode);
		postorderTraversalBT(node.rightNode);
		System.out.print(node.data + " ");
	}

	private void processBinaryTree() {

		while (!queue.isEmpty()) {
			BinaryTree node = queue.poll();

			// Prompt for left node;
			System.out.print(String.format("Add Left Node element for %d : ", node.data));
			int i = scanForInput();
			if (i > 0) {

				BinaryTree leftNode = new BinaryTree();
				leftNode.data = i;
				node.leftNode = leftNode;
				queue.add(leftNode);
			}

			// Prompt for left node;
			System.out.print(String.format("Add Right Node element for %d : ", node.data));
			i = scanForInput();
			if (i > 0) {
				BinaryTree rightNode = new BinaryTree();
				rightNode.data = i;
				node.rightNode = rightNode;
				queue.add(rightNode);
			}
			processBinaryTree();
		}
	}

	private static int scanForInput() {
		int i = -1;
		while (!scanner.hasNextInt()) {
			scanner.next();
		}
		i = scanner.nextInt();
		return i;
	}
}
