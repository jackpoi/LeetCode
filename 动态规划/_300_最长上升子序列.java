package 动态规划;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @author beastars
 */
public class _300_最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length <= 1)
            return nums.length;

        int[] dp = new int[nums.length];
        dp[0] = 1; // 默认自身为一个长度为1的升序列
        int res = 1;

        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            res = Math.max(res, max);
        }

        return res;
    }
}
