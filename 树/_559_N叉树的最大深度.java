package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 *
 * @author beastars
 */
public class _559_N叉树的最大深度 {
    // 迭代
    public int maxDepth(Node root) {
        if (root == null)
            return 0;

        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (!node.children.isEmpty()) {
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            depth++;
        }

        return depth;
    }

    // 递归
    public int maxDepth2(Node root) {
        if (root == null)
            return 0;

        int max = 1;
        if (!root.children.isEmpty()) {
            for (Node child : root.children) {
                int depth = maxDepth(child) + 1;
                if (depth > max)
                    max = depth;
            }
        }
        return max;
    }
}
