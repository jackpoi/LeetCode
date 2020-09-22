package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * @author beastars
 */
public class _40_组合总和II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates.length - 1, target, candidates, new ArrayList<>(), lists);
        return lists;
    }

    private void dfs(int index, int remain, int[] candidates, List<Integer> list, List<List<Integer>> lists) {
        if (remain == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }

        if (remain < candidates[0])
            return;

        for (int i = index; i >= 0; i--) {
            if (remain < candidates[i])
                continue;
            if (i < index && candidates[i] == candidates[i + 1])
                continue;
            list.add(candidates[i]);
            dfs(i - 1, remain - candidates[i], candidates, list, lists);
            list.remove(list.size() - 1);
        }
    }
}
