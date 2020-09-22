package 数组;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author beastars
 */
public class _53_最大子序和_2 {
    /**
     * 分治
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        return maxSubArray(nums, 0, nums.length);
    }

    /**
     * 求解[begin, end)中最大连续子序列的和
     */
    private int maxSubArray(int[] nums, int begin, int end) {
        if (end - begin < 2)
            return nums[begin];
        int mid = (begin + end) >> 1;
        int leftMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = mid - 1; i >= begin; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }

        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for (int i = mid; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }

        return Math.max(leftMax + rightMax,
                Math.max(
                        maxSubArray(nums, begin, mid),
                        maxSubArray(nums, mid, end)
                )
        );
    }
}
