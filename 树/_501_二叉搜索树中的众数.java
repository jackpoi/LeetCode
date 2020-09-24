package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 *
 * @author beastars
 */
public class _501_二叉搜索树中的众数 {
    List<Integer> list = new LinkedList<>(); // 存放众数
    int current; // 当前重复数的值
    int count; // 当前节点的值的重复个数
    int maxCount; // 重复数的最大个数

    public int[] findMode(TreeNode root) {
        inorderTraversal(root); // 平衡二叉树的中序遍历是从小到大有顺序的
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) { // 将list中的众数存到数组中
            res[i] = list.get(i);
        }
        return res;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null)
            return;
        inorderTraversal(node.left);

        int nodeVal = node.val; // 当前节点的值
        if (nodeVal == current) {
            // 如果当前节点的值和重复数相等，说明是众数
            count++; // 当前众数数量加一
        } else {
            // 如果不相等，更新
            current = nodeVal;
            count = 1;
        }

        if (count == maxCount) {
            // 如果当前众数数量和最大相等，向list中添加
            list.add(nodeVal);
        } else if (count > maxCount) {
            // 如果当前众数数量比最大还大，清空list并更新
            list.clear();
            list.add(nodeVal);
            maxCount = count;
        }

        inorderTraversal(node.right);
    }
}
