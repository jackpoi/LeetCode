package 数组;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @author beastars
 */
public class _300_最长上升子序列 {
    /**
     * 扑克牌做法 + 二分搜索
     * 空间复杂度：O(n)
     * 时间复杂度：O(nlogn)
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] top = new int[nums.length];
        top[0] = nums[0];
        int len = 1;

        for (int i = 1; i < nums.length; i++) {
            int index = search(top, nums[i], len);
            top[index] = nums[i];
            if (index == len)
                len++;
        }

        return len;
    }

    /**
     * 二分搜索，返回对应的索引
     *
     * @param nums  目标数组
     * @param n     元素
     * @param end   搜索的结束索引, begin 搜索的起始索引 [begin, end)
     * @return 第一个大于等于元素 n 的元素索引
     */
    private int search(int[] nums, int n, int end) {
        int begin = 0;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (n <= nums[mid]) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }
}
