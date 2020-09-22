package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-iii/
 *
 * @author beastars
 */
public class _216_组合总和III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(1, k, n, new ArrayList<>(), lists);
        return lists;
    }

    private void dfs(int index, int k, int remain, List<Integer> list, List<List<Integer>> lists) {
        if (remain == 0 && k == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < 10; i++) {
            if (remain < i)
                return;
            list.add(i);
            dfs(i + 1, k - 1, remain - i, list, lists);
            list.remove(list.size() - 1);
        }
    }
}
