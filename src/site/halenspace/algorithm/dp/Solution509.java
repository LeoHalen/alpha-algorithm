package site.halenspace.algorithm.dp;

/**
 * Leetcode 509. 斐波那契数
 * @Author Zg.Li · 2020/12/19
 */
public class Solution509 {

    /**
     * 普通递归
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 递归（备忘录模式）
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if (n < 1) return 0;

        int[] memo = new int[n + 1];

        return helper(memo, n);
    }

    public static int helper(int[] memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    /**
     * 自底向上的推算（dp方式）
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) return 1;
        int[] dp = new int[n + 1];
        // base case
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static int fib3(int n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) return 1;
        // base case
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }

        return curr;
    }

    public static void main(String[] args) {
        int result = fib3(30);
        System.out.println(result);
    }
}
