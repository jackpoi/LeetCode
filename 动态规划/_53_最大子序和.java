package 动态规划;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author beastars
 */
public class _53_最大子序和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i]; // 如果小于等于0，即使加上当前数也没有当前数本身大，舍弃掉前面的
            } else {
                dp[i] = dp[i - 1] + nums[i]; // 如果大于0，以当前数为结尾的值再加上之前数，肯定大于本身
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
