package com.ds.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {
	public static void main(String[] args) {
		
		int n=4,m=3;
		int S[] = {1,2,3};
		System.out.println(count(S,m,n));
	}
	
	/*
	 * Top Down Approach
	 */
	
	public static long count(int S[], int m, int n) 
    { 
        //code here.
        long[][] dp=new long[m+1][n+1];
        
        for(int i=0;i<m+1;i++) {
            for(int j=0;j<n+1;j++) {
                if(i==0)
                    dp[i][j]=0;
                if(j==0)
                    dp[i][j]=1;
            }
        }
        
        for(int i=1;i<m+1;i++) {
            for(int j=1;j<n+1;j++) {
                if(S[i-1]<=j)
                    dp[i][j]=dp[i][j-S[i-1]]+dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[m][n];
    } 
	
	/*
	 * Memorization Approach
	 */
	/*
	public static long count(int S[], int m, int n) 
    { 
        //code here.
        long[][] dp=new long[m+1][n+1];
        
        for(long[] temp: dp)
            Arrays.fill(temp,-1);
        
        return unboundedKnapsack(S,m,n,dp);
    } 
    public static long unboundedKnapsack(int S[], int m, int n,long[][] dp) {
        if(n==0)
            return 1;
        if(m==0)
            return 0;
        if(dp[m][n]!=-1)
            return dp[m][n];
        if(S[m-1]<=n) {
            dp[m][n]=unboundedKnapsack(S,m,n-S[m-1],dp)+unboundedKnapsack(S,m-1,n,dp);
        } else
            dp[m][n]=unboundedKnapsack(S,m-1,n,dp);
        return dp[m][n];
    }
	*/
	/*
	 * Recursive Approach
	 */
	/*
    public static long count(int S[], int m, int n) 
    { 
        //code here.
        
        return unboundedKnapsack(S,m,n);
    } 
    public static long unboundedKnapsack(int S[], int m, int n) {
        if(n==0)
            return 1;
        if(m==0)
            return 0;
        if(S[m-1]<=n) {
            return unboundedKnapsack(S,m,n-S[m-1])+unboundedKnapsack(S,m-1,n);
        } else
            return unboundedKnapsack(S,m-1,n);
    }
    */
}
