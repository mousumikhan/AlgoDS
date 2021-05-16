package com.ds.dynamicprogramming;

public class LongestCommonSubsequence {
	
	public static void main(String[] args) {
		int x=6,y=6;
		String str1="ABCDGH", str2="AEDFHR";
		System.out.println(lcs(x,y,str1,str2));
	}
	// Tabular Approach of DP 
	static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int dp[][]=new int[x+1][y+1];
        
        for(int i=0;i<x+1;i++) {
            for(int j=0;j<y+1;j++) {
                if(i==0 || j==0)
                    dp[i][j]=0;
            }
        }
        for(int i=1;i<x+1;i++) {
            for(int j=1;j<y+1;j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j]=1+dp[i-1][j-1];
                } else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[x][y];
    }
	// Memorization Approach of DP
	/*
	static int lcs(int x, int y, String s1, String s2)
    {
        int dp[][]=new int[x+1][y+1];
        
        for(int[] val: dp) {
            Arrays.fill(val,-1);
        }
        
        return lcs_dp(x,y,s1,s2,dp);
    }
    static int lcs_dp(int x,int y,String s1,String s2,int[][] dp) {
        if(x==0 || y==0)
            return 0;
        if(dp[x][y]!=-1)
            return dp[x][y];
        if(s1.charAt(x-1)==s2.charAt(y-1))
            dp[x][y]=1+lcs_dp(x-1,y-1,s1,s2,dp);
        else 
            dp[x][y]=Math.max(lcs_dp(x,y-1,s1,s2,dp),lcs_dp(x-1,y,s1,s2,dp));
        return dp[x][y];
    }*/
	
	/*
	 *Recursive Approach  
	 */
	/*
	static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        if(x==0 || y==0)
            return 0;
        if(s1.charAt(x-1)==s2.charAt(y-1))
            return 1+lcs(x-1,y-1,s1,s2);
        else 
            return Math.max(lcs(x-1,y,s1,s2),lcs(x,y-1,s1,s2));
    }*/
}
