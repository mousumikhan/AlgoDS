package com.ds.dynamicprogramming;

import java.util.concurrent.atomic.AtomicInteger;

public class MaximumPathSumBetweenTwoLeafNodes {
	public static void main(String[] args) {
		
		TreeNode root=new TreeNode(3,new TreeNode(4,new TreeNode(-10),new TreeNode(4)),new TreeNode(5));
		System.out.println(maxPathSum(root));
	}
	static int maxPathSum(TreeNode root)
    { 
        // code here 
        AtomicInteger max_sum = new AtomicInteger(Integer.MIN_VALUE);
        solve(root,max_sum);
        return max_sum.get();
    } 
	static int solve(TreeNode node,AtomicInteger max_sum) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return node.data;
 
        int ls = solve(node.left, max_sum);
        int rs = solve(node.right, max_sum);
 
        if(node.left==null)
            return node.data+rs;
        if(node.right==null)
            return node.data+ls;
            
        int cur_sum=ls + rs + node.data;
        
        max_sum.set(Math.max(max_sum.get(),cur_sum));
 
        return Math.max(ls, rs) + node.data;
    }
}
