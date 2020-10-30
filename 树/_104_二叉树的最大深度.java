package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author beastars
 */
public class _104_二叉树的最大深度 {
    /*
    * 节点的深度（depth）：从根节点到当前节点的唯一路径上的节点总数

      节点的高度（height）：从当前节点到最远叶子节点的路径上的节点总数
    * */

    /**
     * 迭代
     */
    public int maxDepth(TreeNode root) {
        // 二叉树的深度和高度相同，因此求二叉树深度只需求出二叉树的高度即可
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        int depth = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            size--;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (size == 0) {
                size = queue.size();
                depth++;
            }
        }

        return depth;
    }

    /**
     * 递归
     */
    public int maxDepth1(TreeNode root) {
        // 二叉树的高度是子树的高度加一
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));
    }
}
