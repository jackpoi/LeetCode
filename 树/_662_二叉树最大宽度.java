package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 *
 * @author beastars
 */
public class _662_二叉树最大宽度 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1); // 存入的是节点的坐标
        queue.offer(root);
        int width = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                Integer index = list.removeFirst();
                if (node.left != null) {
                    queue.offer(node.left);
                    list.add(index * 2);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    list.add(index * 2 + 1);
                }
            }
            if (list.size() > 1) {
                width = Math.max(width, list.getLast() - list.getFirst() + 1);
            }
        }
        return width;
    }
}
