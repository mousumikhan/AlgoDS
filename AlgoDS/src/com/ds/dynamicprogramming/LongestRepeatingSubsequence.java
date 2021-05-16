package com.ds.dynamicprogramming;

public class LongestRepeatingSubsequence {
	public static void main(String[] args) {
		System.out.println(longestRepeatingSubsequence("AABEBCDD"));
	}
	static int longestRepeatingSubsequence(String str)
    {
        // code here
        
        int n=str.length();
        
        int dp[][]=new int[n+1][n+1];
        
        for(int i=0;i<n+1;i++) {
            for(int j=0;j<n+1;j++) {
                if(i==0 || j==0)
                    dp[i][j]=0;
            }
        }
        
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<n+1;j++) {
                if(str.charAt(i-1)==str.charAt(j-1) && i!=j)
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][n];
    }
}
