package com.ds.dynamicprogramming;

public class DiameterOfBinaryTree {
	public static void main(String[] args) {
		
		TreeNode root=new TreeNode(1,new TreeNode(2),new TreeNode(3));
		System.out.println(diameter(root));
	}
	
	static int res=0;
    static int diameter(TreeNode root) {
        // Your code here
        solve(root);
        return res;
    }
    static int solve(TreeNode root) {
        if(root==null)
            return 0;
        int left=solve(root.left);
        int right=solve(root.right);
        
        int temp=Math.max(left,right)+1;
        res=Math.max(res,1+left+right);
        return temp;
    }
}
