package com.gl.gradedproject2.dsa.gradedassignment;

import java.util.Scanner;

public class BSTSkewedTree 
{
     
	public static Node node;
    static Node prevNode = null;
    static Node headNode = null;
    
	static class Node 
	{
		int key;
		Node left;
		Node right;
	}
	
	 static Node newNode(int data) 
	{
		Node temp=new Node();
		
		temp.key=data;
		temp.left=null;
		temp.right=null;
		
		return temp;	
	}
	
	 Node insertNode(Node root,int key) 
	 {
		 Node newNode=newNode(key);
		 Node x=root;
		 Node current_parent=null;
		 
		 while(x!=null) 
		 {
			 current_parent=x;
			 if(key<x.key)
				 x=x.left;
			 else if (key>x.key)
				 x=x.right;
			 
			 else 
			 {
				 System.out.println("Value exists already");
				 return newNode;
			 }
			 
		 }
		 if (current_parent==null)
		 {
			 current_parent=newNode;
		 }
		 
		 else if(key<current_parent.key) 
		 {
			 current_parent.left=newNode;
		 }
		 else
		 {
			 current_parent.right=newNode;
		 }
		 
		 return current_parent;
	 }
	 
//	 void Inorder(Node root) 
//	 {
//
//		 if (root == null)
//		 return;
//		 
//		 else 
//		 {
//	     Inorder(root.left);
//		 System.out.print(root.key + " ");
//		 Inorder(root.right);
//		 }
//		 System.out.println("\n");
//	  }
	    
	    
	 static void skewedBinaryTree(Node root)
		{
		
		// When root is null
		if(root == null)
		{
		return;
		}
		
		skewedBinaryTree(root.left);
		
		Node rightNode = root.right;
		//Node leftNode = root.left;
		
		
		if(headNode == null)
		{
		headNode = root;
		root.left = null;
		prevNode = root;
		}
		else
		{
		prevNode.right = root;
		root.left = null;
		prevNode = root;
		}

			skewedBinaryTree(rightNode);
		
		}
	    
	  
	     static void traverseRightSkewed(Node root)
	     {
	         if(root == null)
	         {
	             return;
	         }
	         System.out.print(root.key + " ");
	         traverseRightSkewed(root.right);       
	     }
	
		
	public static void main(String[] args) 
	{
		Node root=null;
		int size,key;
		BSTSkewedTree bst =new BSTSkewedTree();
		System.out.println("Enter size of tree");
		Scanner sc=new Scanner(System.in);
		size=sc.nextInt();
		int[] tree_values=new int[size];
		System.out.println("Enter values to create BST:");
		
		for(int i=0;i<size;i++) 
		{
			tree_values[i]=sc.nextInt();
		}
		
		System.out.println("Print input array for Binary tree:");
		
		for(int i=0;i<size;i++) 
		{
			System.out.print(tree_values[i]+" ");
		}
		System.out.println("\n");
		for(int i=0;i<tree_values.length;i++) 
		{
			key=tree_values[i];
			if(root==null) 
			{
				root=bst.insertNode(root,key);
			}
			else 
			{
				bst.insertNode(root,key);
			}
			
		}
		//System.out.println("Inorder Printing");
		//bst.Inorder(root);
		BSTSkewedTree.skewedBinaryTree(root);
		
		System.out.println("Skewed tree Printing");
		BSTSkewedTree.traverseRightSkewed(headNode);
		
		sc.close();
			
	}
	
 }
