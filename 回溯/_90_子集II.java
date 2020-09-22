package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 *
 * @author beastars
 */
public class _90_子集II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<>(), lists);
        return lists;
    }

    private void dfs(int index, int[] nums, List<Integer> list, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            dfs(i + 1, nums, list, lists);
            list.remove(list.size() - 1);
        }
    }
}
