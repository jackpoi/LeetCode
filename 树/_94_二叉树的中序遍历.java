package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * @author beastars
 */
public class _94_二叉树的中序遍历 {
    /**
     * 利用 Morris 中序遍历二叉树
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public List<Integer> inorderTraversalMorris(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;

        while (node != null) {
            if (node.left != null) {
                // 找到前驱节点(predecessor)
                // 因为 node.left != null，所以前驱节点一定在左子树内
                TreeNode pred = node.left;
                while (pred.right != null && pred.right != node) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = node;
                    node = node.left;
                } else {
                    list.add(node.val);
                    pred.right = null; // 断掉连接的线，保持树的结构
                    node = node.right;
                }
            } else {
                list.add(node.val);
                node = node.right;
            }
        }

        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}
