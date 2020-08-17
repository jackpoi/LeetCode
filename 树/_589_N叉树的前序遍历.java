package 树;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 *
 * @author beastars
 */
public class _589_N叉树的前序遍历 {
    List<Integer> list = new LinkedList<>();

    public List<Integer> preorder(Node root) {
        /*recursivePreorder(root);
        return list;*/

        return iterativePreorder(root);
    }

    /**
     * 递归
     */
    public void recursivePreorder(Node root) {
        if (root == null)
            return;
        list.add(root.val);
        if (!root.children.isEmpty()) {
            for (Node child : root.children) {
                recursivePreorder(child);
            }
        }
    }

    /**
     * 迭代
     */
    public List<Integer> iterativePreorder(Node root) {
        if (root == null)
            return list;
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.poll();
            list.add(node.val);
            if (!node.children.isEmpty()) {
                Collections.reverse(node.children); // 将子树反转压入栈中
                for (Node child : node.children) {
                    stack.push(child);
                }
            }
        }
        return list;
    }
}
