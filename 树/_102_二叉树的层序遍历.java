package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @author beastars
 */
public class _102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return lists;
        queue.offer(root);
        // 每遍历完一层，队列中的元素就是下一层的所有元素，也就是队列的长度，为0时，代表该层遍历完毕，添加到lists
        int size = 1; // 根节点只有一个，初始化为1
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            size--;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (size == 0) {
                size = queue.size();
                lists.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return lists;
    }
}
