
/**
 * @author Bikash Mohanty
 * @Since 28th Nov 2019
 * @version: 1.1
 * 
 * purpose: Given N nodes, each having unique value ranging from [1, N], 
 * 			how many different binary search tree can be created using all of them.
 */

package com.bridgelabz.datastructure;

import com.bridgelabz.utility.InputUtility;
import com.bridgelabz.utility.Utility;

public class BinarySearchTree 
{
	class Node
	{
		int key;
		Node leftNode, rightNode;
		
		public Node(int newNode)
		{
			key = newNode;
			leftNode = rightNode = null;
		}
	}
	
	Node root;
	
	public BinarySearchTree() 
	{
		root = null;
	}
	
	void insert(int key)
	{
		root = insertNode(root, key);
	}
	
	/**
	 * 
	 * @param root --> Node class type
	 * @param key --> integer type
	 * @return --> Node class type
	 */

	private Node insertNode(Node root, int key) 
	{
		if(root == null)
		{
			root = new Node(key);
			return root;
		}
		
		/**
		 * checking the key value is less than the left root node or right root node
		 * so that the new node can be placed accordingly
		 */
		
		if(key < root.key)
		{
			root.leftNode = insertNode(root.leftNode,key);
			System.out.print(" -> left ->"+root.leftNode.key);
		}
		else if(key > root.key)
		{
			root.rightNode = insertNode(root.rightNode, key);
			System.out.print(" -> right ->"+root.rightNode.key);
		}
		return root;
	}
	
	void inorder()
	{
		traverseInorder(root);
	}

	/**
	 * 
	 * @param rootNode --> Node class type
	 */

	private void traverseInorder(Node rootNode) 
	{
		if(rootNode != null)
		{
			traverseInorder(rootNode.leftNode);
			System.out.print(rootNode.key+" ");
			traverseInorder(rootNode.rightNode);
		}
	}
	
	/**
	 * 
	 * @param numbersOfNode --> integer type
	 * @return integer value
	 * 
	 * purpose: To find the Catalan number that is to be formed from the given number of nodes.
	 * 			i.e How many Numbers of Binary Search Tree will be formed from the given Numbers of Node
	 * 			will be calculate in the following Method. 
	 */
	
	private static int catalanNumber(int numbersOfNode) 
	{
		return Utility.factorial(2 * numbersOfNode)/(Utility.factorial(numbersOfNode + 1) * Utility.factorial(numbersOfNode));
	}

	public static void main(String[] args) 
	{
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		System.out.println("Enter How many Nodes you want to insert : ");
		int totalNode = InputUtility.inputInteger();
		System.out.print("\nEnter Node Data: ");
		for (int i = 0; i < totalNode; i++) 
		{
			binarySearchTree.insert(InputUtility.inputInteger());
		}
		System.out.println("\nInroder: \n");
		binarySearchTree.inorder();
		
		System.out.println("\n"+catalanNumber(totalNode)+" Numbers of BST can be created from "+totalNode+" numbers of Node");
		
		
	}

	

}
