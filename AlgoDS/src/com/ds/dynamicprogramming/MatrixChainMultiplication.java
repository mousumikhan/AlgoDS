package com.ds.dynamicprogramming;

import java.util.Arrays;

public class MatrixChainMultiplication {
	
	public static void main(String[] args) {
		int[] arr={40, 20, 30, 10, 30};
		System.out.println(matrixMultiplication(5,arr));
	}
	// Tabular Approach of DP 
	static int matrixMultiplication(int N, int arr[])
    {
        // code here
        
        int i=1,j=N-1;
        int[][] dp=new int[N+1][N+1];
        
        for(int[] temp: dp)
            Arrays.fill(temp,-1);
            
        return solve(arr,i,j,dp);
    }
    static int solve(int[] arr,int i,int j,int[][] dp) {
        
        if(i>=j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++) {
            int temp=solve(arr,i,k,dp)+solve(arr,k+1,j,dp)+arr[i-1]*arr[k]*arr[j];
            min=Math.min(min,temp);
        }
        dp[i][j]=min;
        return dp[i][j];
    }
}
