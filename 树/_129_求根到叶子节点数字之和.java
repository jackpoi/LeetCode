package 树;

/**
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 *
 * @author beastars
 */
public class _129_求根到叶子节点数字之和 {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        sumTwoNodes(root, 0);

        return sum;
    }

    /**
     * 递归，递归计算节点的两个子节点的和
     *
     * @param node  当前节点
     * @param carry 进位
     */
    private void sumTwoNodes(TreeNode node, int carry) {
        if (node == null)
            return;

        int value = carry * 10 + node.val; // 计算当前节点的值
        if (node.left == null && node.right == null) {
            // 到了叶子节点，计入总和
            sum += value;
            return;
        }

        // 递归子节点
        sumTwoNodes(node.left, value);
        sumTwoNodes(node.right, value);
    }
}
