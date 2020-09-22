package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * @author beastars
 */
public class _39_组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(0, candidates, target, new ArrayList<>(), lists);
        return lists;
    }

    private void dfs(int index, int[] candidates, int remain, List<Integer> list, List<List<Integer>> lists) {
        if (remain == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }

        if (remain < candidates[0])
            return;

        for (int i = index; i < candidates.length && candidates[i] <= remain; i++) {
            list.add(candidates[i]); // 将选择的数字放入
            dfs(i, candidates, remain - candidates[i], list, lists);
            // 每次只选择一个数字，该数字一定是添加到最后一个，选择完毕之后，再将其删除，还原现场
            list.remove(list.size() - 1);
        }
    }
}
