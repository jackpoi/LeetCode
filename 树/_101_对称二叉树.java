package 树;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author beastars
 */
public class _101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return false;
        return judge(root.left, root.right);
    }

    public boolean judge(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val == right.val)
            return judge(left.left, right.right) && judge(right.left, left.right);
        return false;
    }
}
