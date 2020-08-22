package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/two-sum/submissions/
 *
 * @author beastars
 */
public class _15_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null)
            return null;

        List<List<Integer>> lists = new ArrayList<>();

        if (nums.length < 3)
            return lists;

        Arrays.sort(nums); // 先排好序

        int midIdx = nums.length - 3; // 指向三元组的第二个元素
        int lastIdx = nums.length - 1; // 指向三元组的最后一个元素
        for (int i = 0; i <= midIdx; i++) { // i指向三元组第一个元素
            if (i > 0 && nums[i - 1] == nums[i]) // 如果前一个元素和当前元素相同，跳过，去重
                continue;
            int left = i + 1;
            int right = lastIdx;
            int remain = -nums[i];
            while (left < right) {
                int sumLR = nums[left] + nums[right];
                if (sumLR == remain) { // 找到了符合条件的三元组
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 跳过相同的值（去重）
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    // 往中间逼近
                    left++;
                    right--;
                } else if (sumLR < remain) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return lists;
    }
}
