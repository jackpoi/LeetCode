package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author beastars
 */
public class _226_翻转二叉树 {
    /*
    * 只需要将二叉树进行遍历，每次遍历交换左右节点，即可完成二叉树的翻转
    *        4
           /   \
          2     7
         / \   / \
        1   3 6   9

    *        4
           /   \
          7     2
         / \   / \
        9   6 3   1
    * */

    /**
     * 层序遍历
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return root;
    }

    /**
     * 前序遍历
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null)
            return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree1(root.left);
        invertTree1(root.right);

        return root;
    }

    /**
     * 中序遍历
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null)
            return null;

        invertTree2(root.left);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 由于是先反转左子树，因此现在的右子树其实已经被原来的左子树翻转，即现在的左子树就是原先的右子树
        invertTree2(root.left);

        return root;
    }

    /**
     * 后序遍历
     */
    public TreeNode invertTree3(TreeNode root) {
        if (root == null)
            return null;

        invertTree3(root.left);
        invertTree3(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }
}
