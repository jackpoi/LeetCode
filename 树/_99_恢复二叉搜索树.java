package 树;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 *
 * @author beastars
 */
public class _99_恢复二叉搜索树 {
    // 上一次中序遍历的节点
    private TreeNode prev;
    // 第一个错误节点
    private TreeNode first;
    // 第二个错误节点
    private TreeNode second;

    /**
     * 使用 Morris 中序遍历树，查找错误节点
     */
    public void recoverTree(TreeNode root) {
        TreeNode node = root;

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
                    find(node);
                    pred.right = null;
                    node = node.right;
                }
            } else {
                find(node);
                node = node.right;
            }
        }

        // 交换两个错误节点的值
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    /**
     * 找出第一和第二个错误节点
     */
    private void find(TreeNode node) {
        if (prev != null && prev.val > node.val) {
            // 前面有节点，且前面的节点比现在的大，说明是逆序对

            // 第2个错误节点：最后1个逆序对中的较小节点
            // 如果只出现一个逆序对，将第二个错误节点赋给 second
            // 如果出现两个逆序对，让第二个逆序对覆盖 second
            second = node;

            if (first != null) // 此时first和second都已经找到，直接返回
                return;
            // 第1个错误节点：第1个逆序对中的较大节点
            // 如果出现两个逆序对，当第二个出现时，first不为null，不进行处理
            first = prev;
        }

        prev = node; // 更新 prev
    }

    /**
     * 11 17 18 22 28 37 42 44 62
     * 两个节点进行错误交换，可能会导致两种可能：
     *  1. 出现一个逆序对 -> 11 17 '22 18' 37 42 44 62
     *  2. 出现两个逆序对 -> 11 17 '44 22' 37 '42 18' 62
     * 共性：
     *  第1个错误节点：第1个逆序对中的较大节点 'prev root'
     *  第2个错误节点：最后1个逆序对中的较小节点 'prev' root ... prev 'root'
     */
    public void recoverTree2(TreeNode root) {
        findWrongNode(root);

        // 交换两个错误节点的值
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    /**
     * 找到错误节点，使用中序遍历(二叉搜索树的中序遍历是升序的)
     */
    private void findWrongNode(TreeNode root) {
        if (root == null)
            return;

        findWrongNode(root.left);

        find(root);

        findWrongNode(root.right);
    }
}
