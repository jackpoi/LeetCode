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
        for (int i = amount / coins[index]; i >= 0; i--) {
            int remain = amount - i * coins[index];
            int sum = count + i;
            if (remain == 0) { // 如果为0，说明找到了，比较和之前最小数量的值进行比较
                min = Math.min(min, sum);
                return;
            }
            if (sum + 1 >= min) {
                // 如果当前数量余额不为0，且该算法是将硬币从大到小遍历，因此至少还需要一个硬币才能余额为0，
                // 如果加上这个的数量还比最小值要大，说明该结果不是最小的，直接跳过即可
                return;
            }
            dfs(coins, remain, sum, index - 1);
        }
    }
}
