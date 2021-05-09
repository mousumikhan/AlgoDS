package com.ds.dynamicprogramming;

public class CheckForSubsequence {
	public static void main(String[] args) {
		System.out.println(isSubSequence("AXY","YADXCP"));
	}
	static boolean isSubSequence(String A, String B){
        
        int n1=A.length();
        int n2=B.length();
        
        int dp[][]=new int[n1+1][n2+1];
        
        for(int i=0;i<n1+1;i++) {
            for(int j=0;j<n2+1;j++) {
                if(i==0 || j==0)
                    dp[i][j]=0;
            }
        }
        
        for(int i=1;i<n1+1;i++) {
            for(int j=1;j<n2+1;j++) {
                if(A.charAt(i-1)==B.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return dp[n1][n2]==Math.min(n1,n2);
    }
}
