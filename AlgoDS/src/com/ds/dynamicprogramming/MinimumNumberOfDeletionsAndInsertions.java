package com.ds.dynamicprogramming;

public class MinimumNumberOfDeletionsAndInsertions {
	public static void main(String[] args) {
		System.out.println(minOperations("heap","pea"));
	}
	public static int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    
	    int n1=str1.length();
	    int n2=str2.length();
	    
	    int dp[][]=new int[n1+1][n2+1];
	    
	    for(int i=0;i<n1+1;i++) {
	        for(int j=0;j<n2+1;j++) {
	            if(i==0 || j==0)
	                dp[i][j]=0;
	        }
	    }
	    
	    for(int i=1;i<n1+1;i++) {
	        for(int j=1;j<n2+1;j++) {
	            if(str1.charAt(i-1)==str2.charAt(j-1))
	                dp[i][j]=1+dp[i-1][j-1];
	            else
	                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
	        }
	    }
	    return (n1-dp[n1][n2])+(n2-dp[n1][n2]);
 	} 
}
