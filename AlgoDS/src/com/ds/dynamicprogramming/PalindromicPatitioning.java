package com.ds.dynamicprogramming;

import java.util.Arrays;

public class PalindromicPatitioning {
	
	public static void main(String[] args) {
		System.out.println(palindromicPartition("ababbbabbababa"));
	}
	// Memorization Method of DP
	static int palindromicPartition(String str)
    {
        // code here
        int n=str.length();
        
        int i=0,j=n-1;
        int dp[][]=new int[n+1][n+1];
        for(int[] temp: dp) {
            Arrays.fill(temp,-1);
        }
        return solve(str,i,j,dp);
    }
    static int solve(String str,int i,int j,int[][] dp) {
        if(i>=j)
            return 0;
        if(isPalindrome(str,i,j))
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int min=Integer.MAX_VALUE;
        
        for(int k=i;k<j;k++) {
            
            int left=0,right=0;
            if(dp[i][k]!=-1)
                left=dp[i][k];
            else
                left=solve(str,i,k,dp);
            
            if(dp[k+1][j]!=-1)
                right=dp[k+1][j];
            else
                right=solve(str,k+1,j,dp);
            
            int temp=1+left+right;
            min=Math.min(min,temp);
        }
        dp[i][j]=min;
        return dp[i][j];   
    }
    static boolean isPalindrome(String str,int start,int end) {
        while(start<=end) {
            if(str.charAt(start)!=str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    
    /*
     * Recursive Approach
    static int palindromicPartition(String str)
    {
        // code here
        int n=str.length();
        
        int i=0,j=n-1;
        return solve(str,i,j);
    }
    
    static int solve(String str,int i,int j) {
        if(i>=j)
            return 0;
        if(isPalindrome(str,i,j))
            return 0;
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++) {
            int temp=solve(str,i,k)+solve(str,k+1,j)+1;
            min=Math.min(min,temp);
        }
        return min;   
    }*/
}
