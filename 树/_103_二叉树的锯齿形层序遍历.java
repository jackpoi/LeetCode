package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * @author beastars
 */
public class _103_二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isReverse = false; // 是否反转遍历该层
        while (!queue.isEmpty()) {
            int size = queue.size(); // 标识每一层的节点个数
            List<Integer> list = new LinkedList<>();
            while (size-- > 0) { // 遍历该层的节点
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (isReverse) // 如果需要反转，就添加到头部
                    list.add(0, node.val);
                else
                    list.add(node.val);
            }

            lists.add(list);
            isReverse = !isReverse;
        }

        return lists;
    }
}
