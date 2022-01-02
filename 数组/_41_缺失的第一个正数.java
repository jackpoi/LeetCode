package 数组;

/**
 * https://leetcode-cn.com/problems/first-missing-positive/
 */
public class _41_缺失的第一个正数 {
    public int firstMissingPositive(int[] nums) {
        // 计数排序，把数组放到对应值下标的新数组中，
        // 从前往后遍历新数组，如果有0的说明没这个值，这就是最小正整数
        // 如果遍历完都没有是0的，说明nums里正好是0~length的唯一值，那最小正整数就是length+1
        int[] sort = new int[nums.length + 1];
        for (int n : nums) {
            // 如果有大于length的值，就跳过，因为要求的是最小值
            if (n > 0 && n <= nums.length) {
                sort[n]++;
            }
        }
        for (int i = 1; i < sort.length; i++) {
            if (sort[i] == 0) {
                return i;
            }
        }
        return nums.length + 1;
    }
}
