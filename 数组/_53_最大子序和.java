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

    /**
     * 暴力法优化
     * 执行用时：143 ms, 在所有 Java 提交中击败了5.01%的用户
     * 空间复杂度：O(1)，时间复杂度：O(n2)
     */
    public int maxSubArray2_2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int max = Integer.MIN_VALUE;

        for (int begin = 0; begin < nums.length; begin++) {
            int sum = 0;
            for (int end = begin; end < nums.length; end++) {
                sum += nums[end];
                max = Math.max(sum, max);
            }
        }

        return max;
    }

    /**
     * 暴力法
     * 超时
     * 空间复杂度：O(1)，时间复杂度：O(n3)
     */
    public int maxSubArray2_1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int max = Integer.MIN_VALUE;

        for (int begin = 0; begin < nums.length; begin++) {
            for (int end = begin; end < nums.length; end++) {
                int sum = 0;
                for (int i = begin; i <= end; i++) {
                    sum += nums[i];
                }
                max = Math.max(sum, max);
            }
        }

        return max;
    }
}
