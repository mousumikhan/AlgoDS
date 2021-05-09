package com.ds.dynamicprogramming;

public class EqualSumPartitionProblem {
	
	public static void main(String[] args) {
		int N = 4;
		int arr[] = {1, 5, 11, 5};
		System.out.println(equalPartition(N,arr));
	}
	// Tabulataion Method of DP
	static int equalPartition(int N, int arr[])
    {
        // code here
        
        int sum=0;
        for(int val: arr)
            sum+=val;
        if(sum%2!=0)
            return 0;
        sum/=2;
        boolean[][] dp=new boolean[N+1][sum+1];
        
        for(int i=0;i<N+1;i++) {
            for(int j=0;j<sum+1;j++) {
                if(i==0)
                    dp[i][j]=false;
                if(j==0)
                    dp[i][j]=true;
            }
        }
        
        for(int i=1;i<N+1;i++) {
            for(int j=1;j<sum+1;j++) {
                if(arr[i-1]<=j)
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        
        return dp[N][sum]?1:0;
    }
	
	/*
	 * Memorization Approach
	 */
	/*
	static int equalPartition(int N, int arr[])
    {
        // code here
        
        int sum=0;
        for(int val: arr)
            sum+=val;
        if(sum%2!=0)
            return 0;
            
        int[][] dp=new int[N+1][(sum/2)+1];
        for(int[] temp: dp)
            Arrays.fill(temp,-1);
        if(knapsack(arr,N,sum/2,dp)==1)
            return 1;
        else
            return 0;
    }
    
    static int knapsack(int[] arr,int N,int sum,int[][] dp) {
        if(sum==0)
            return 1;
        if(N==0)
            return 0;
        if(arr[N-1]<=sum)
            dp[N][sum]=knapsack(arr,N-1,sum-arr[N-1],dp)==1?1:knapsack(arr,N-1,sum,dp)==1?1:0;
        else
            dp[N][sum]=knapsack(arr,N-1,sum,dp);
        return dp[N][sum];
    }
    */
	/*
	 * Recursive Approach
	 */
	/*
	static int equalPartition(int N, int arr[])
    {
        // code here
        
        int sum=0;
        for(int val: arr)
            sum+=val;
        if(sum%2!=0)
            return 0;
        else if(knapsack(arr,N,sum/2))
            return 1;
        else
            return 0;
    }
    
    static boolean knapsack(int[] arr,int N,int sum) {
        if(sum==0)
            return true;
        if(N==0)
            return false;
        if(arr[N-1]<=sum)
            return knapsack(arr,N-1,sum-arr[N-1]) || knapsack(arr,N-1,sum);
        else
            return knapsack(arr,N-1,sum);
    }*/
}
