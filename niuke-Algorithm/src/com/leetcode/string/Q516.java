package com.leetcode.string;

import java.util.*;
import java.util.stream.Collectors;

public class Q516 {
    int maxLength = 0;

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n-1; i >=0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i+1; j < n; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n-1];
    }

    public void dfs(String s) {

    }

    public static void main(String[] args) {
        Q516 q516 = new Q516();
//        System.out.println(q516.longestPalindromeSubseq("bbbab"));
//        System.out.println("1".charAt(5));
        System.out.println(q516.longestPalindromeSubseq("bbabb"));
//        System.out.println("5423".substring(1,4));
//        char[] chars = "155555".toCharArray();
//        List<Character> list = "List.of(chars)".chars().mapToObj(c -> (char)c).collect(Collectors.toList());
//        System.out.println(list.contains());
//        System.out.println(list.get(0)[1]);
    }


}
