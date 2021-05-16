package com.ds.dynamicprogramming;

public class MaximumPathSum {
	public static void main(String[] args) {
		
		TreeNode root=new TreeNode(1,new TreeNode(2),new TreeNode(3));
		System.out.println(maxPathSum(root));
	}
	static int res=Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        solve(root);
        return res;
    }
    static int solve(TreeNode root) {
        if(root==null)
            return 0;
        int left=solve(root.left);
        int right=solve(root.right);
        
        int temp=Math.max(Math.max(left,right)+root.data,root.data);
        int ans=Math.max(temp,left+right+root.data);
        res=Math.max(res,ans);
        
        return temp;
    }
}
