package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * <p>
 * 回溯（dfs）
 * result = []
 * def backtrack(路径, 选择列表):
 * if 满足结束条件:
 * result.add(路径)
 * return
 * <p>
 * for 选择 in 选择列表:
 * 做选择
 * backtrack(路径, 选择列表)
 * 撤销选择
 *
 * @author beastars
 */
public class _46_全排列_2 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null)
            return null;

        List<List<Integer>> lists = new ArrayList<>();

        if (nums.length == 0)
            return lists;

        dfs(0, nums, lists);

        return lists;
    }

    private void dfs(int index, int[] nums, List<List<Integer>> lists) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            lists.add(list);
            return;
        }

        // 枚举这一层所有可以做出的选择
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            dfs(index + 1, nums, lists);
            swap(nums, index, i); // 恢复现场
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
