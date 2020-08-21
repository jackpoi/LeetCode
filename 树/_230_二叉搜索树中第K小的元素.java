package 树;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 *
 * @author beastars
 */
public class _230_二叉搜索树中第K小的元素 {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = root;
        TreeNode tmp = root;
        while (node != null) {
            if (node.left != null) {
                TreeNode pred = node.left;
                while (pred.right != null && pred.right != node) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = node;
                    node = node.left;
                } else {
                    tmp = node;
                    k--;
                    node = node.right;
                    pred.right = null;
                }
            } else {
                tmp = node;
                k--;
                node = node.right;
            }
            if (k == 0) {
                return tmp.val;
            }
        }
        return -1;
    }

    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (--k == 0) {
                return curr.val;
            }
            curr = curr.right;
        }
        return -1;
    }
}
