package site.halenspace.algorithm.dp;

/**
 * Leetcode 322. 凑零钱
 * @Author Zg.Li · ${DATE}
 */
public class Solution322 {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = coinChange(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }

            min = Math.min(min, subProblem + 1);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {

    }
}
