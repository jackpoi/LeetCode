package 数组;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author beastars
 */
public class _53_最大子序和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int sum = 0;
        int res = nums[0];

        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }

        return res;
    }
}
