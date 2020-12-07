package 剑指Offer;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 * @author beastars
 */
public class _03_数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        // 前提：所有数字都在 0～n-1 的范围内
        int[] tmp = new int[nums.length];

        for (int num : nums) {
            tmp[num]++;
            if (tmp[num] > 1) {
                return num;
            }
        }
        return -1;
    }
}
