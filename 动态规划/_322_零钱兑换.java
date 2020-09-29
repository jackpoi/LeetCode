package 动态规划;

/**
 * https://leetcode-cn.com/problems/coin-change/
 *
 * @author beastars
 */
public class _322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins == null || coins.length < 1)
            return -1;
        if (amount == 0)
            return 0;

        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin)
                    continue;
                int count = dp[i - coin];
                if (count < 0 || count >= min)
                    continue;
                min = count;
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }

        return dp[amount];
    }
}
