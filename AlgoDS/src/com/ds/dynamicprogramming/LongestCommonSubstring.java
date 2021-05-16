package com.ds.dynamicprogramming;

public class LongestCommonSubstring {
	
	public static void main(String[] args) {
		int x=6,y=6;
		String str1="ABCDGH", str2="ACDGHR";
		System.out.println(longestCommonSubstr(str1,str2,x,y));
	}
	// Tabular Approach of DP 
	static int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        int dp[][]=new int[n+1][m+1];
        int maxCount=0;
        for(int i=0;i<n+1;i++) {
            for(int j=0;j<m+1;j++) {
                if(i==0 ||j==0) 
                    dp[i][j]=0;
            }
        }
        for(int i=1;i<n+1;i++) {
           for(int j=1;j<m+1;j++) {
               if(S1.charAt(i-1)==S2.charAt(j-1)) {
                    dp[i][j]=1+dp[i-1][j-1];
                    maxCount=Math.max(maxCount,dp[i][j]);
               } else
                    dp[i][j]=0;
           } 
        }
        return maxCount;
    }
	
	/*
	 * Recursive Approach
	 */
	/*
	static int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        
        int count=0;
        return longestCommonSubstr(S1,S2,n,m,count);
    }
	static int longestCommonSubstr(String S1, String S2, int n, int m, int count){
        if(n==0 || m==0)
            return 0;
        if(S1.charAt(n-1)==S2.charAt(m-1))
            count=longestCommonSubstr(S1,S2,n-1,m-1,count+1);
        else
            count=Math.max(count,Math.max(longestCommonSubstr(S1,S2,n-1,m,0),
            longestCommonSubstr(S1,S2,n,m-1,0)));
        return count;
    }*/
}
