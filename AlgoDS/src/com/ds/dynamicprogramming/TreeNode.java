package com.ds.dynamicprogramming;

public class TreeNode
{
	int data;
	TreeNode left,right;
	
	TreeNode(int d)
	{
		data = d;
		left = right = null;		
	}
	
	TreeNode(int d,TreeNode l,TreeNode r)
	{
		data = d;
		left = l;		
		right=r;
	}
} 