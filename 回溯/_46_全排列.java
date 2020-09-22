package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 *
 * @author beastars
 */
public class _46_全排列 {
    private List<List<Integer>> lists;
    private int[] nums;
    private int[] result; // 存储每一次的组合
    private boolean[] used; // 判断当前数字有没有被遍历过

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null)
            return null;

        lists = new ArrayList<>();

        if (nums.length == 0)
            return lists;

        this.nums = nums;
        result = new int[nums.length];
        used = new boolean[nums.length];
        dfs(0);
        return lists;
    }

    private void dfs(int index) {
        if (index == result.length) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i : result) {
                list.add(i);
            }
            lists.add(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            result[index] = nums[i];
            used[i] = true;

            dfs(index + 1);

            // 还原现场
            used[i] = false;
        }
    }
}
