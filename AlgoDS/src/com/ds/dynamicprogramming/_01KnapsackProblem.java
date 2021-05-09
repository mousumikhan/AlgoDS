package com.ds.dynamicprogramming;

public class _01KnapsackProblem {
	
	public static void main(String[] args) {
		int N = 3,W = 4;
		int values[] = {1,2,3};
		int weight[] = {4,5,1};
		System.out.println(knapSack(W,weight,values,N));
	}
	// Tabulataion Method of DP
	static int knapSack(int W, int wt[], int val[], int n) {
		int dp[][]=new int[n+1][W+1];
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<W+1;j++) {
				if(i==0 || j==0 )
					dp[i][j]=0;
			}
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<W+1;j++) {
				if(wt[i-1]<=j) {
					dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
				} else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[n][W];
	}
	
	// Memorization Approach of DP
	/*
	static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here
         int[][] dp=new int[n+1][W+1];
         for(int[] temp: dp) {
             Arrays.fill(temp,-1);
         }
         for(int i=0;i<n+1;i++) {
             for(int j=0;j<W+1;j++) {
                 if(i==0 || j==0)
                    dp[i][j]=0;
             }
         }
         return knapSack(W,wt,val,n,dp);
         
         // Recursive Approach
         /*
         if(n==0 || W==0)
            return 0;
         if(wt[n-1]<=W) {
             return Math.max(val[n-1]+knapSack(W-wt[n-1],wt,val,n-1),
                            knapSack(W,wt,val,n-1));
         } else {
             return knapSack(W,wt,val,n-1);
         }*/
         
	/* } 
    static int knapSack(int W, int wt[], int val[], int n,int[][] dp) {
        if(dp[n][W]!=-1)
            return dp[n][W];
        if(wt[n-1]<=W) {
            dp[n][W]=Math.max(val[n-1]+knapSack(W-wt[n-1],wt,val,n-1,dp),
                        knapSack(W,wt,val,n-1,dp));
        } else {
            dp[n][W]=knapSack(W,wt,val,n-1,dp);
        }
        return dp[n][W];
    } */
}
