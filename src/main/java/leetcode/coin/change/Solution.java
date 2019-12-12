package leetcode.coin.change;

import java.util.Arrays;

/**
 * Created by wuzhsh on 12/4/2019.
 */
public class Solution {

    // dp，自底向上来求解
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] >= 0) {
                    if (dp[i] == -1) { // 为-1时，说明还没有找到其他的兑换方式，所以只要找到一个就设置为该值
                        dp[i] = dp[i - coin] + 1;
                    } else { // dp[i]存放了遍历过的其他coin的最小值
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.coinChange(new int[]{5, 2, 1}, 10));
        System.out.println(s.coinChange(new int[]{1, 2, 5}, 100));
        System.out.println(s.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}
