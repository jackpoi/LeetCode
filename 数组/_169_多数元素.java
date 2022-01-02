package 数组;

/**
 * https://leetcode-cn.com/problems/majority-element/
 */
public class _169_多数元素 {
    public int majorityElement(int[] nums) {
        // 摩尔投票法
        // 每次从序列里选择两个不相同的数字删除掉（或称为“抵消”），
        // 最后剩下一个数字或几个相同的数字，就是出现次数大于总数一半的那个。
        if (nums.length < 3)
            return nums[0];

        int count = 0;
        int cur = nums[0];

        for (int n : nums) {
            if (cur == n) {
                count++;
            } else if (count-- == 0) {
                cur = n;
                count = 1;
            }
        }

        return cur;
    }
}
