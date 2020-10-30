package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 *
 * @author beastars
 */
public class _47_全排列II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null)
            return null;

        List<List<Integer>> lists = new ArrayList<>();

        if (nums.length == 0)
            return lists;

        dfs(nums, lists, 0);
        return lists;
    }

    private void dfs(int[] nums, List<List<Integer>> lists, int index) {
        if (index == nums.length) {
            List<Integer> result = new ArrayList<>();
            for (int num : nums) {
                result.add(num);
            }
            lists.add(result);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (isRepeat(nums, index, i)) // 保证相同的数字在一个index位置上只会出现一次
                continue;
            swap(nums, index, i);
            dfs(nums, lists, index + 1);
            swap(nums, index, i);
        }
    }

    private boolean isRepeat(int[] nums, int index, int i) {
        for (int j = index; j < i; j++) {
            if (nums[i] == nums[j])
                return true;
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
