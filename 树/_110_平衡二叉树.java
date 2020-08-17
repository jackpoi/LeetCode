package 树;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * @author beastars
 */
public class _110_平衡二叉树 {
    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        inorderTraversal(root);
        return flag;
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // 遍历
    private void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            flag = false;
            return;
        }
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        if (root.right != null) {
            inorderTraversal(root.right);
        }
    }
}
