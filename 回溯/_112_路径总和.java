package 回溯;

/**
 * https://leetcode-cn.com/problems/path-sum/
 *
 * @author beastars
 */
public class _112_路径总和 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        return dfs(root, sum);
    }

    /**
     * @param node   当前节点
     * @param remain 剩余大小
     */
    private boolean dfs(TreeNode node, int remain) {
        if (node == null)
            return false;
        remain -= node.val;
        if (node.left == null && node.right == null) {
            // 如果是叶子节点，并且剩余为0，也就是说该条路径的值等于sum
            if (remain == 0) {
                return true;
            }
        }
        return dfs(node.left, remain) || dfs(node.right, remain);
    }
}
