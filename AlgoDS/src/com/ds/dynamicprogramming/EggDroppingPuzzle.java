package com.ds.dynamicprogramming;

import java.util.Arrays;

public class EggDroppingPuzzle {
	public static void main(String[] args) {
		System.out.println(eggDrop(2,10));
	}
	
	/*
	 * Memorization Approach
	 */
	static int eggDrop(int e, int f) 
	{
	    // Your code here
	    int[][] dp=new int[e+1][f+1];
	    for(int val[]: dp)
	        Arrays.fill(val,-1);
	    return solve(e,f,dp);
	    
	}
	static int solve(int e,int f,int[][] dp) {
	    if(e==1)
	        return f;
	    if(f==0 || f==1)
	        return f;
	    if(dp[e][f]!=-1)
	        return dp[e][f];
	    int min=Integer.MAX_VALUE;
	    int low=0,high=0;
	    for(int k=1;k<=f;k++) {
	        
	        if(dp[e-1][k-1]!=-1)
	            low=dp[e-1][k-1];
	        else
	            low=solve(e-1,k-1,dp);
	        if(dp[e][f-k]!=-1)
	            high=dp[e][f-k];
	        else
	            high=solve(e,f-k,dp);
	        
	        int temp=1+Math.max(low,high);
	        
	        min=Math.min(min,temp);
	    }
	    dp[e][f]=min;
	    return min;
	}
	
	/*
	 * Recursive Approach
	 */
	/*
	static int eggDrop(int e, int f) 
	{
	    // Your code here
	    
	    if(e==1)
	        return f;
	    if(f==0 || f==1)
	        return f;
	    int min=Integer.MAX_VALUE;
	    for(int k=1;k<=f;k++) {
	        int temp=1+Math.max(eggDrop(e-1,k-1),eggDrop(e,f-k));
	        min=Math.min(min,temp);
	    }
	    return min;
	}
	*/
}
