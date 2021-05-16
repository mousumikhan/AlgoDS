package com.ds.dynamicprogramming;


public class NumberOfCoins {
	public static void main(String[] args) {
		
		int V=30,M=3;
		int coins[] = {25, 10, 5};
		System.out.println(minCoins(coins,M,V));
	}
	
	/*
	 * Top Down Approach
	 */
	
	public static int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    
	    int dp[][]=new int[M+1][V+1];
	    
	    for(int j=0;j<V+1;j++)
	        dp[0][j]=Integer.MAX_VALUE-1;
	    for(int i=1;i<M+1;i++)
	        dp[i][0]=0;
	    for(int i=1;i<M+1;i++) {
	        for(int j=1;j<V+1;j++) {
	            if(coins[i-1]<=j) {
	                dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
	            } else
	                dp[i][j]=dp[i-1][j];
	        }
	    }
	    
	    return dp[M][V]==Integer.MAX_VALUE-1?-1:dp[M][V];
	} 
}
