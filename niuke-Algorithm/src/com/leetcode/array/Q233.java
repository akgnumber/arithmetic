package com.leetcode.array;

import java.util.HashMap;
import java.util.Set;

public class Q233 {
    int count;
    int[][] dp = new int[10][10];

    /**
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i *= 10) {
            ans += n / (i * 10) * i + Math.min(Math.max(n % (i * 10) -i + 1,0 ),i);
        }
        return ans;
    }

    /**
     * @param n
     * @return
     */
    public int countDigitOne2(int n) {
        int ans = 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i % 10] + dp[i / 10];
            ans += dp[i];
        }
        return ans;
    }

    public int countDigitOne1(int n) {
        String s = n + "";
        int[] dp = new int[s.length()];
        dfs(s, 0, dp);
        return dp[0];
    }

    private void dfs(String s, int index, int[] dp) {
        if (index >= s.length()) {
            return;
        }
        if (index < s.length() - 1) {
            //todo
            dp[index] = 0;
            dfs(s, ++index, dp);
        }

        if (index == s.length() - 1) {

        }
    }


    public static void main(String[] args) {


        System.out.println(new Q233().countDigitOne(113));
    }
}
