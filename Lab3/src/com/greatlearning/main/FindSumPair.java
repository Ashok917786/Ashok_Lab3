package com.greatlearning.main;

import java.util.HashSet;
import java.util.Set;

public class FindSumPair {

	class Node {
		private Node left;
		private Node right;
		private int data;

		Node(int key) {
			left = right = null;
			data = key;
		}

	}

	public Node insert(Node root, int key) {
		if (root == null)
			return new Node(key);

		if (key < root.data) {
			root.left = insert(root.left, key);
		} else {
			root.right = insert(root.right, key);
		}
		return root;
	}

	public static boolean findPair(Node current, int sum, Set<Integer> set) {
		if (current == null)
			return false;
		else {
			boolean isPresent = findPair(current.left, sum, set);
			if (isPresent) {
				return isPresent;
			}
			if (set.contains(sum - current.data)) {
				System.out.println("The pair exists with Pair of " + (sum - current.data) + "," + current.data);
				return true;
			} else {
				set.add(current.data);
			}
			return findPair(current.right, sum, set);
		}
	}

	public static void findPairWithGivenSum(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		boolean isPresent = findPair(root, sum, set);
		if (!isPresent) {
			System.out.println("Nodes are not found with the given sum");
		}
	}

	public static void main(String[] args) {

		Node root = null;
		FindSumPair findSumPair = new FindSumPair();
		root = findSumPair.insert(root, 40);
		root = findSumPair.insert(root, 20);
		root = findSumPair.insert(root, 60);
		root = findSumPair.insert(root, 10);
		root = findSumPair.insert(root, 30);
		root = findSumPair.insert(root, 50);
		root = findSumPair.insert(root, 70);
		findPairWithGivenSum(root, 100);// Here 100 is sum value for which it will check for pairs in tree

	}

}
