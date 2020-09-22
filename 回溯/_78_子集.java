package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 *
 * @author beastars
 */
public class _78_子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(0, nums, lists, new ArrayList<>());
        return lists;
    }

    private void dfs(int index, int[] nums, List<List<Integer>> lists, List<Integer> list) {
        lists.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(i + 1, nums, lists, list);
            list.remove(list.size() - 1);
        }
    }
}
