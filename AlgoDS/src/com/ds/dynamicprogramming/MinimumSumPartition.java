package com.ds.dynamicprogramming;

public class MinimumSumPartition {
	public static void main(String[] args) {
		int[] arr=new int[] {1, 6, 11, 5};
		System.out.println(minDiffernce(arr,4));
	}
	public static int minDiffernce(int arr[], int n) 
	{ 
	    // Your code goes here
	    
	    int range=0;
	    for(int val: arr)
	        range+=val;
	    boolean[][] dp=new boolean[n+1][range+1];
	    
	    for(int i=0;i<n+1;i++) {
	        for(int j=0;j<range+1;j++) {
	            if(i==0)
	                dp[i][j]=false;
	            if(j==0)
	                dp[i][j]=true;
	        }
	    }
	    
	    for(int i=1;i<n+1;i++) {
	        for(int j=1;j<range+1;j++) {
	            if(arr[i-1]<=j) {
	                dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
	            } else {
	                dp[i][j]=dp[i-1][j];
	            }
	        }
	    }
	    
	    int min=Integer.MAX_VALUE;
	    
	    for(int j=range/2;j>=0;j--) {
	        if(dp[n][j]) {
	            min=range-2*j;
	            break;
	        }
	    }
	    return min;
	}
}
