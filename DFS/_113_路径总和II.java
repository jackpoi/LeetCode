package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @author beastars
 */
public class _113_路径总和II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();

        if (root == null)
            return lists;

        dfs(root, sum, new ArrayList<>(), lists);
        return lists;
    }

    private void dfs(TreeNode node, int remain,
                     List<Integer> result, List<List<Integer>> lists) {
        if (node == null)
            return;

        remain -= node.val;
        result.add(node.val);
        if (node.left == null && node.right == null) {
            if (remain == 0) {
                lists.add(new ArrayList<>(result));
            }
        } else {
            dfs(node.left, remain, result, lists);
            dfs(node.right, remain, result, lists);
        }

        // 还原现场，退回上一个节点
        result.remove(result.size() - 1);
    }
}
