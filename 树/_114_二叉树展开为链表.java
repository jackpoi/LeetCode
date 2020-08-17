package 树;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * @author beastars
 */
public class _114_二叉树展开为链表 {
    // 迭代
    public void flatten(TreeNode root) {
        // 先把右子树转到左子树的最右节点上，再将左子树转到左子树，挨个遍历
        while (root != null) {
            if (root.left != null) {
                TreeNode node = root.left;
                while (node.right != null) {
                    node = node.right;
                }
                node.right = root.right;
                root.right = root.left;
                root.left = null; // 转过去之后，将左子树置空
            }
            root = root.right;
        }
    }

    // 递归
    TreeNode pre = null;
    public void flatten2(TreeNode root) {
        if (root == null)
            return;
        flatten2(root.right);
        flatten2(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
