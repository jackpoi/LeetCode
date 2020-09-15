package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/coin-change/
 *
 * @author beastars
 */
public class _322_零钱兑换 {
    int min = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins, amount, 0, coins.length - 1);
        if (min == Integer.MAX_VALUE)
            return -1;
        return min;
    }

    private void dfs(int[] coins, int amount, int count, int index) {
        if (index < 0)
            return;
        int i = amount / coins[index];
        int remain = amount - i * coins[index];
        int sum = count + i;
        if (remain == 0) {
            min = Math.min(min, sum);
            return;
        }
        if (sum + 1 >= min) {
            return;
        }
        dfs(coins, remain, sum, index - 1);
    }
}
