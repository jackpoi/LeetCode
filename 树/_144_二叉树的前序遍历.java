package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @author beastars
 */
public class _144_二叉树的前序遍历 {
    /*
    * 只压入右子树，如果根节点空，直接返回list，否则压入根节点到栈中，当栈中没有元素时结束循环，返回list
      先判断右子树，如果右子树不为空就压入栈中，如果左子树不为空，就压入左子树
      如果左子树为空，且栈中元素不为空，则将栈中顶部元素弹出，该元素就是最近的右子树，再遍历该节点
    * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return list;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            list.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }

            if (root.left != null) {
                root = root.left;
            } else if (!stack.isEmpty()) {
                root = stack.pop();
            }
        }
        return list;
    }
}
