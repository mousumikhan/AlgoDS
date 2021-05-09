package com.ds.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {
	public static void main(String[] args) {
		System.out.println(isScramble("great","rgeat"));
	}
	static Map<String,Integer> map=new HashMap<>();
    public static int isScramble(final String A, final String B) {
        if(A.length()!=B.length())
            return 0;
        int n=A.length();
        if(n==0)
            return 1;
        if(A.equals(B))
            return 1;
        String key=A+","+B;
        if(map.containsKey(key))
            return map.get(key);
        for(int i=1;i<n;i++) {
            if(isScramble(A.substring(0,i),B.substring(0,i))==1 && isScramble(A.substring(i,n),B.substring(i,n))==1) {
                map.put(key,1);
                return map.get(key);
            }
            if(isScramble(A.substring(0,i),B.substring(n-i,n))==1 && isScramble(A.substring(i,n),B.substring(0,n-i))==1) {
                map.put(key,1);
                return map.get(key);   
            }
        }
        map.put(key,0);
        return map.get(key);
    }
	/*
	 * Recursive Approach
	 */
	/*
	public static int isScramble(final String A, final String B) {
        if(A.length()!=B.length())
            return 0;
        int n=A.length();
        if(n==0)
            return 1;
        if(A.equals(B))
            return 1;
        for(int i=1;i<n;i++) {
            if(isScramble(A.substring(0,i),B.substring(0,i))==1 && isScramble(A.substring(i,n),B.substring(i,n))==1)
                return 1;
            if(isScramble(A.substring(0,i),B.substring(n-i,n))==1 && isScramble(A.substring(i,n),B.substring(0,n-i))==1)
                return 1;    
        }
        return 0;
    }*/
}
