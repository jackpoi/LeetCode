package 树;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author beastars
 */
public class _236_二叉树的最近公共祖先 {
    /**
     * 去以 root 为根节点的二叉树中查找 p、q 的最近共同祖先
     * 1. 如果 p、q 同时存在于这棵树中，就能成功返回最近共同祖先
     * 2. 如果 p、q 都不存在于这棵树中，返回 null
     * 3. 如果只有 p 存在于这棵树中，返回 p
     * 4. 如果只有 q 存在于这棵树中，返回 q
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        // 去以 root.left 为根节点的二叉树中查找 p、q 的最近共同祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 去以 root.right 为根节点的二叉树中查找 p、q 的最近共同祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果 right == null,说明右子树没有任何一个节点，两个节点都在左边，那么共同祖先也一定在左边
        // 如果 left == null,说明左子树没有任何一个节点，两个节点都在右边，那么共同祖先也在右边
        // 如果都不为 null，说明不在同一边，说明共同祖先就是根节点
        if (left != null && right != null) { // 不在同一边
            return root;
        }
        // 在同一边，必有一边的结果为 null
        // 如果 left 为 null，说明 left 中不存在这两个节点，right 就是共同祖先
        return left == null ? right : left;
    }
}
