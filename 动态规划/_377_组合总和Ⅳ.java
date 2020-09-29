package 动态规划;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/combination-sum-iv/
 *
 * @author beastars
 */
public class _377_组合总和Ⅳ {
    /**
     * 背包问题
     *
     * 背包问题具备的特征：
     *      给定一个target，target可以是数字也可以是字符串，再给定一个数组nums，
     *      nums中装的可能是数字，也可能是字符串，
     *      问：能否使用nums中的元素做各种排列组合得到target。
     *
     * 常见的背包问题有1、组合问题。2、True、False问题。3、最大最小问题。
     *
     * 组合问题公式
     *      dp[i] += dp[i-num]
     *
     * True、False问题公式
     *      dp[i] = dp[i] or dp[i-num]
     *
     * 最大最小问题公式
     *      dp[i] = min(dp[i], dp[i-num]+1)或者dp[i] = max(dp[i], dp[i-num]+1)
     *
     * 背包问题技巧：
     * 1.如果是0-1背包，即数组中的元素不可重复使用，nums放在外循环，target在内循环，且内循环倒序；
     * for num in nums:
     *     for i in range(target, nums-1, -1):
     *
     * 2.如果是完全背包，即数组中的元素可重复使用，nums放在外循环，target在内循环。且内循环正序。
     * for num in nums:
     *     for i in range(nums, target+1):
     *
     * 3.如果组合问题需考虑元素之间的顺序，需将target放在外循环，将nums放在内循环。
     * for i in range(1, target+1):
     *     for num in nums:
     */
    public int combinationSum4(int[] nums, int target) {
        if (target <= 0)
            return 0;

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] = dp[i - num] + dp[i];
                }
            }
        }

        return dp[target];
    }
}
