package com.ds.dynamicprogramming;

import java.util.Arrays;

public class RodCutting {
	public static void main(String[] args) {
		
		int N = 8;
	    int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println(cutRod(price,N));
	}
	
	/*
	 * Top Down Approach
	 */
	public static int cutRod(int price[], int n) {
        int dp[][]=new int[n+1][n+1];
        
        for(int i=0;i<n+1;i++) {
            for(int j=0;j<n+1;j++)
                if(i==0 || j==0)
                    dp[i][j]=0;
        }
        
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<n+1;j++) {
                if(i<=j) {
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-i],dp[i-1][j]);
                } else
                    dp[i][j]=dp[i-1][j];
            }
        }
        
        return dp[n][n];
    }
	
	/*
	 * Memorization Approach
	 */
	/*
	public static int cutRod(int price[], int n) {
        int dp[][]=new int[n+1][n+1];
        
        for(int[] temp: dp)
            Arrays.fill(temp,-1);
        return unboundedKnapsack(price,n,n,dp);
    }
    
    static int unboundedKnapsack(int[] price,int cur,int totalLeft,int[][] dp) {
        
        if(cur==0 || totalLeft==0)
            return 0;
        if(dp[cur][totalLeft]!=-1)
            return dp[cur][totalLeft];
        if(cur<=totalLeft)
            dp[cur][totalLeft]=Math.max(price[cur-1]+unboundedKnapsack(price,cur,totalLeft-cur,dp),
                unboundedKnapsack(price,cur-1,totalLeft,dp));
        else
            dp[cur][totalLeft]=unboundedKnapsack(price,cur-1,totalLeft,dp);
        return dp[cur][totalLeft];
    }
    */
	/*
	 * Recursive Approach
	 */
	/*
	public static int cutRod(int price[], int n) {
        return unboundedKnapsack(price,n,n);
    }
    
    static int unboundedKnapsack(int[] price,int cur,int totalLeft) {
        
        if(cur==0 || totalLeft==0)
            return 0;
        if(cur<=totalLeft)
            return Math.max(price[cur-1]+unboundedKnapsack(price,cur,totalLeft-cur),
                unboundedKnapsack(price,cur-1,totalLeft));
        else
            return unboundedKnapsack(price,cur-1,totalLeft);
    }*/
}
