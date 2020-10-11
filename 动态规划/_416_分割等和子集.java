package 动态规划;

/**
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 * @author beastars
 */
public class _416_分割等和子集 {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0)
            return false;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) // 如果为奇数 1001...1 & 1 = 1
            return false;

        int target = sum >> 1;
        // dp[i][j] ： 从数组的[0, i]这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于j。
        boolean[][] dp = new boolean[nums.length][target + 1];

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][target];
    }
}
