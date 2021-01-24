package 数组;

/**
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 *
 * @author beastars
 */
public class _674_最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        int max = 1; // 最长的递增序列的长度
        int count = 1; // 递增序列的长度计数器

        /*
        遍历数组，如果是递增的，计算递增序列的长度，和最大值比较，取最大的；
        如果递增数组中断了，即后面的数字 ≤ 前面的，就比较最大值，重置计数器，接着找下一个递增数列
         */
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }

        // 如果最后一个递增数列是最长的，则是直接跳出了循环，没有比较最大值，需要再次进行一次比较
        return Math.max(max, count);
    }
}
