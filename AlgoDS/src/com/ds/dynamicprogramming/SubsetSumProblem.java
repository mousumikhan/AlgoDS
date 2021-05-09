package com.ds.dynamicprogramming;

public class SubsetSumProblem {
	
	public static void main(String[] args) {
		int B[]= {3, 34, 4, 12, 5, 2};
		System.out.println(solve(B,9));
	}
	// Tabulataion Method of DP
	public static int solve(int[] A, int B) {
        
        int n=A.length;
        boolean [][] dp=new boolean[n+1][B+1];
        
        for(int i=0;i<n+1;i++) {
            for(int j=0;j<B+1;j++) {
                if(i==0)
                    dp[i][j]=false;
                if(j==0)
                    dp[i][j]=true;
            }
        }
        
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<B+1;j++) {
                if(A[i-1]<=j)
                    dp[i][j]=dp[i-1][j-A[i-1]] || dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][B]?1:0;
    }
	
	/*
	 * Memorization Approach
	 */
	/*
	public int solve(int[] A, int B) {
        
        int n=A.length;
        int[][] dp=new int[n+1][B+1];
        
        for(int []temp: dp) {
            Arrays.fill(temp,-1);
        }
        knapsack(A,B,n,dp);
        return dp[n][B];
    }
    
    int knapsack(int[] A,int B,int n,int[][] dp) {
        if(B==0)
            return 1;
        if(n==0)
            return 0;
        if(dp[n][B]!=-1)
            return dp[n][B];
        if(A[n-1]<=B)
            dp[n][B]=knapsack(A,B-A[n-1],n-1,dp)==1?1: knapsack(A,B,n-1,dp)==1?1:0;
        else
            dp[n][B]=knapsack(A,B,n-1,dp)==1?1:0;
        return dp[n][B];
    }
    */
	
	/*
	 * Recursive Approach
	 */
    /*
	public static int solve(int[] A, int B) {
        if(knapsack(A,B,A.length))
            return 1;
        return 0;
    }
    
	static boolean knapsack(int[] A,int B,int n) {
        if(n==0)
            return false;
        if(B==0)
            return true;
        if(A[n-1]<=B)
            return knapsack(A,B-A[n-1],n-1) || knapsack(A,B,n-1);
        else
            return knapsack(A,B,n-1);
    }*/
}
