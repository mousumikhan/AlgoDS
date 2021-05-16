package com.ds.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintLongestcommonSubsequence {
	public static void main(String[] args) {
		List<Integer> a=new ArrayList<>(Arrays.asList(697,953,900,438,899,593,591,963,31,160,894,493,782,445,326,452,988,657,7,544,768,398,791,650,818,12,347,928,828,336,692,339,130,837,548,487,989,333,875,711,957,341,821,319,338,328,234,7,670,328,451,200,685,699,855,668,609,322,752,386,81,635,952,618,133,73,548,163,221,105,773,398,639,579,660,746,718,918,224,984,265,242,506,762,734,98,324,100,896,346,344,27,420,353,532,105,914,130,695));
		List<Integer> b=new ArrayList<>(Arrays.asList(438,591,768,160,777,894,782,398,445,306,326,282,452,607,241,513,185,7,544,12,347,828,336,83,924,143,692,339,130,515,837,466,989,875,711,957,338,266,305,480,328,28,7,670,328,699,849,668,609,979,100,322,283,386,655,263,826,169,635,952,618,73,238,897,221,863,34,372,732,398,579,666,545,660,794,746,526,718,918,403,615,946,224,822,242,506,734,324,100,55,346,704,24,650,678,532,914,130,423,998));
		//System.out.println(longestCommonSubsequence(a,b));
		int[] arr1= {1,2,3,4,1};
		int[] arr2= {3,4,1,2,1,3};
		int res[]=longestCommonSubsequence(arr1,arr2,5,6);
		for(int i=0;i<res.length;i++)
			System.out.print(arr1[i]+" ");
	}
	static int[] longestCommonSubsequence(int[] arr1,int[] arr2,int n,int m) {
        int[][] dp=new int[n+1][m+1];
        
        for(int i=0;i<n+1;i++) {
            for(int j=0;j<m+1;j++) {
                if(i==0 || j==0)
                    dp[i][j]=0;
            }
        }
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<m+1;j++) {
                if(arr1[i-1]==arr2[j-1])
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int count=dp[n][m];
        int []res=new int[count];
        int i=n;
        int j=m;
        while(i>0 && j>0) {
            if(arr1[i-1]==arr2[j-1]) {
                res[--count]=arr1[i-1];
                i--;
                j--;
            } else if(dp[i-1][j]>dp[i][j-1])
                i--;
            else
                j--;
                
        }
        return res;
    }
	/*
	public static List<Integer> longestCommonSubsequence(List<Integer> a, List<Integer> b) {
	    // Write your code here
	        List<Integer> res=new ArrayList<>();
	        int n=a.size();
	        int m=b.size();
	        int dp[][]=new int[n+1][m+1];
	        
	        for(int i=0;i<n+1;i++) {
	            for(int j=0;j<m+1;j++) {
	                if(i==0 || j==0)
	                    dp[i][j]=0;
	            }
	        }
	        for(int i=1;i<n+1;i++) {
	            for(int j=1;j<m+1;j++) {
	                if(a.get(i-1)==b.get(j-1))
	                    dp[i][j]=1+dp[i-1][j-1];
	                else 
	                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
	            }
	        }
	        int i=n, j=m;
	        while(i>0 && j>0) {
	            if(a.get(i-1)==b.get(j-1)) {
	                res.add(a.get(i-1));
	                i--;
	                j--;
	            } else {
	                if(dp[i-1][j]>dp[i][j-1])
	                    i--;
	                else
	                    j--;
	            }
	        }
	        Collections.reverse(res);
	        return res;
	}*/
}
