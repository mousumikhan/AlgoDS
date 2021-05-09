package com.ds.dynamicprogramming;

public class TargetSum {
	
	public static void main(String[] args) {
		int nums[] = {1,1,1,1,1};
		int target=3;
		System.out.println(findTargetSumWays(nums,target));
	}
	// Tabulataion Method of DP
	public static int findTargetSumWays(int[] nums, int target) {
        
        int range=0;
        int zeros=0;
        for(int val: nums) {
            range+=val;
            if(val==0)
                zeros++;
        }
        if((range+target)%2!=0)
            return 0;
        int S1=(range+target)/2;
        
        int n=nums.length;
        
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
                if(nums[i-1]==0 || nums[i-1]>j)
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j];
            }
        }
        return dp[n][S1]*(int)Math.pow(2,zeros);
    }
}
