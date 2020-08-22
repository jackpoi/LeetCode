package 数组;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author beastars
 */
public class _1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // 存储元素的值和索引
        map.put(nums[0], 0); // 第一个前面没有元素，直接添加
        for (int i = 1; i < nums.length; i++) { // 遍历数组，判断map中有没有值和target减去遍历的值相等的
            Integer index = map.get(target - nums[i]);

            if (index != null) // 如果不为null，说明存在，说明之前遍历的有相加为target的
                return new int[]{index, i};
            // 如果不存在，加入到map中
            map.put(nums[i], i);
        }
        // 如果都没有。说明不存在
        return new int[0];
    }
}
