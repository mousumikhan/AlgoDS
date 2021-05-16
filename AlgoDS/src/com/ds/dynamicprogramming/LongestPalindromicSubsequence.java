package com.ds.dynamicprogramming;

public class LongestPalindromicSubsequence {
	
	public static void main(String[] args) {
		String S = "bbabcbcab";
		System.out.println(longestPalinSubseq(S));
	}
	// Tabulataion Method of DP
	public static int longestPalinSubseq(String S)
    {
        //code here
        
        String S2=new String(new StringBuilder(S).reverse());
        
        int n=S.length();
        
        int dp[][]=new int[n+1][n+1];
        
        for(int i=0;i<n+1;i++) {
            for(int j=0;j<n+1;j++) {
                if(i==0 || j==0)
                    dp[i][j]=0;
            }
        }
        
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<n+1;j++) {
                if(S.charAt(i-1)==S2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return dp[n][n];
    }
}
