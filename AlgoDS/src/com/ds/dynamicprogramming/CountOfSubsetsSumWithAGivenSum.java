package com.ds.dynamicprogramming;

import java.util.Arrays;

public class CountOfSubsetsSumWithAGivenSum {
	public static void main(String[] args) {
		int[] arr=new int[] {2, 3, 5, 6, 8, 10};
		System.out.println(perfectSum(arr,6,10));
	}
	final static int mod=1000000000+7;
	
	/*
	 * Top Down Approach
	 */
	public static int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int[][] dp=new int[n+1][sum+1];
	    
	    for(int i=0;i<n+1;i++) {
	        for(int j=0;j<sum+1;j++) {
	            if(i==0)
	                dp[i][j]=0;
	            if(j==0)
	                dp[i][j]=1;
	        }
	    }
	    
	    for(int i=1;i<n+1;i++) {
	        for(int j=1;j<sum+1;j++) {
	            if(arr[i-1]<=j) {
	                dp[i][j]=(dp[i-1][j-arr[i-1]]%mod+dp[i-1][j]%mod)%mod;
	            } else
	                dp[i][j]=dp[i-1][j]%mod;
	        }
	    }
	    return dp[n][sum]%mod;
	}
	/*
	 * Memorization Approach
	 */
	/*
	public static int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int[][] dp=new int[n+1][sum+1];
	    
	    for(int[] temp: dp)
	        Arrays.fill(temp,-1);
	        
	    knapsack(arr,n,sum,dp);
	    
	    return dp[n][sum]%mod;
	} 
	static int knapsack(int[] arr,int n,int sum,int[][] dp) {
	    if(sum==0)
	        return 1;
	    if(n==0)
	        return 0;
	    if(dp[n][sum]!=-1)
	        return dp[n][sum];
	    if(arr[n-1]<=sum)
	        dp[n][sum]=((knapsack(arr,n-1,sum-arr[n-1],dp)%mod)+(knapsack(arr,n-1,sum,dp)%mod))%mod;
	    else
	        dp[n][sum]=knapsack(arr,n-1,sum,dp)%mod;
	    return dp[n][sum];
	}
	*/
	/*
	 * Recursive Approach
	 */
	/*
	public static int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    
	    return knapsack(arr,n,sum)%mod;
	} 
	static int knapsack(int[] arr,int n,int sum) {
	    if(sum==0)
	        return 1;
	    if(n==0)
	        return 0;
	    if(arr[n-1]<=sum)
	        return ((knapsack(arr,n-1,sum-arr[n-1])%mod)+(knapsack(arr,n-1,sum)%mod))%mod;
	    else
	        return knapsack(arr,n-1,sum)%mod;
	}*/
}
