package com.ds.dynamicprogramming;

import java.util.Arrays;

public class BooleanParenthesization {
	public static void main(String[] args) {
		
		String str="T|T&F^T";
		int n=7;
		System.out.println(countWays(n,str));
	}
	/*
	 * Memorization Approach
	 */
	static final int mod=1003;
    static int countWays(int N, String S){
        // code here
        int[][][] dp=new int[N+1][N+1][2];
        
        for(int [][]row: dp) {
            for(int[] col: row) {
                Arrays.fill(col,-1);
            }
        }
        
        return solve(S,0,N-1,1,dp);
    }
    static int solve(String S,int i,int j,int isTrue,int[][][] dp) {
        if(i>j)
            return 0;
        if(i==j) {
            if(isTrue==1)
                return S.charAt(i)=='T'?1:0;
            else
                return S.charAt(i)=='F'?1:0;
        }
        
        if(dp[i][j][isTrue]!=-1)
            return dp[i][j][isTrue];
        int temp_ans=0;
        
        int lt=0,rt=0,lf=0,rf=0;
        
        for(int k=i+1;k<=j-1;k+=2) {
            
            if(dp[i][k-1][1]!=-1)
                lt=dp[i][k-1][1];
            else
                lt=solve(S,i,k-1,1,dp)%mod;
                
            if(dp[i][k-1][0]!=-1)
                lf=dp[i][k-1][0];
            else
                lf=solve(S,i,k-1,0,dp)%mod;
                
            if(dp[k+1][j][1]!=-1)
                rt=dp[k+1][j][1];
            else
                rt=solve(S,k+1,j,1,dp)%mod;
                
            if(dp[k+1][j][0]!=-1)
                rf=dp[k+1][j][0];
            else
                rf=solve(S,k+1,j,0,dp)%mod;
            
            if(S.charAt(k)=='&') {
                
                if(isTrue==1)
                    temp_ans=temp_ans+((lt*rt)%mod);
                else
                    temp_ans=temp_ans+(lt*rf)%mod+(lf*rt)%mod+(lf*rf)%mod;
            
                
            } else if(S.charAt(k)=='|') {
                
                if(isTrue==1)
                    temp_ans=temp_ans+(lt*rt)%mod+(lt*rf)%mod+(lf*rt)%mod;
                else
                    temp_ans=temp_ans+(lf*rf)%mod;
            } else {
                
                if(isTrue==1)
                    temp_ans=temp_ans+(lf*rt)%mod+(lt*rf)%mod;
                else
                    temp_ans=temp_ans+(lf*rf)%mod+(lt*rt)%mod;
                
            }
        }
        dp[i][j][isTrue]=temp_ans%mod;
        return dp[i][j][isTrue];
    }
	/*
	 * Recursive Approach
	 */
	/*
	static int countWays(int N, String S){
        // code here
        
        return solve(S,0,N-1,1);
    }
    static int solve(String S,int i,int j,int isTrue) {
        if(i>j)
            return 0;
        if(i==j) {
            if(isTrue==1)
                return S.charAt(i)=='T'?1:0;
            else
                return S.charAt(i)=='F'?1:0;
        }
        
        int temp_ans=0;
        
        int lt=0,rt=0,lf=0,rf=0;
        
        for(int k=i+1;k<=j-1;k+=2) {
            lt=solve(S,i,k-1,1);
            lf=solve(S,i,k-1,0);
            rt=solve(S,k+1,j,1);
            rf=solve(S,k+1,j,0);
            
            if(S.charAt(k)=='&') {
                
                if(isTrue==1)
                    temp_ans=temp_ans+lt*rt;
                else
                    temp_ans=temp_ans+lt*rf+lf*rt+lf*rf;
            
                
            } else if(S.charAt(k)=='|') {
                
                if(isTrue==1)
                    temp_ans=temp_ans+lt*rt+lt*rf+lf*rt;
                else
                    temp_ans=temp_ans+lf*rf;
            } else {
                
                if(isTrue==1)
                    temp_ans=temp_ans+lf*rt+lt*rf;
                else
                    temp_ans=temp_ans+lf*rf+lt*rt;
                
            }
        }
        return temp_ans;
    }*/
}
