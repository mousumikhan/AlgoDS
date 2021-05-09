package com.ds.dynamicprogramming;

public class CountTheNumberOfSubsetWithAGivenDifference {
	public static void main(String[] args) {
		int[] arr=new int[] {1,1,2,3};
		int diff=1;
		System.out.println(numberOfSubset(arr,diff));
	}
	static int numberOfSubset(int[] arr,int diff){
        
        int range=0;
        for(int val: arr)
        	range+=val;
        
        int S1=(range+diff)/2;
        int n=arr.length;
        
        int dp[][]=new int[n+1][S1+1];
        
        for(int i=0;i<n+1;i++) {
        	for(int j=0;j<S1+1;j++) {
        		if(i==0)
        			dp[i][j]=0;
        		if(j==0)
        			dp[i][j]=1;
        	}
        }
        
        for(int i=1;i<n+1;i++) {
        	for(int j=1;j<S1+1;j++) {
        		if(arr[i-1]<=j)
        			dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j];
        		else
        			dp[i][j]=dp[i-1][j];
        	}
        }
        return dp[n][S1];
    }
}
