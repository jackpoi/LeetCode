package 树;

/**
 * https://leetcode-cn.com/problems/largest-bst-subtree/
 *
 * @author beastars
 */
public class _333_最大BST子树 {

    /**
     * 自底向上
     */
    public int largestBSTSubtree(TreeNode root) {
        return root == null ? 0 : getInfo(root).size;
    }

    private Info getInfo(TreeNode root) {
        if (root == null)
            return null;

        Info leftInfo = getInfo(root.left); // 左子树的最大BST子树信息
        Info rightInfo = getInfo(root.right); // 右子树的最大BST子树信息

        int leftSize = -1, rightSize = -1;
        int min = root.val;
        int max = root.val;

        if (leftInfo == null) {
            leftSize = 0;
        } else if (leftInfo.root == root.left && root.val > leftInfo.max) {
            // 如果左子树的最大BST的根节点就是左子树，且根节点的值大于BST的最大值，说明根节点和左子树一起就是一个BST
            leftSize = leftInfo.size;
            min = leftInfo.min;
        }

        if (rightInfo == null) {
            rightSize = 0;
        } else if (rightInfo.root == root.right && root.val < rightInfo.min) {
            // 如果右子树的最大BST的根节点就是右子树，且根节点的值小于BST的最小值，说明根节点和右子树一起就是一个BST
            rightSize = rightInfo.size;
            max = rightInfo.max;
        }

        if (leftSize >= 0 && rightSize >= 0) {
            // 如果到了这里，说明进入了上面两个if判断，即说明，要不左（右）子树和根节点放一起是一个BST，
            // 要不左（右）子树都为空，
            // 也就是说，以root为根节点的树就是一棵BST，最大BST就是其本身
            return new Info(root, 1 + leftSize + rightSize, min, max);
        }

        // 如果到了这里，
        // 1.左（右）子树都有BST，但至少有一个子树的最大BST不是本身
        // 2.有一个子树没有BST，另一个子树的最大BST不是本身
        // 3.都没有BST
        if (leftInfo != null && rightInfo != null) {
            // 1.如果左（右）子树都有BST子树，返回节点数量最多的那一个
            return leftInfo.size > rightInfo.size ? leftInfo : rightInfo;
        }

        // 2.3.返回节点数量最多的那个，如果都没有返回0
        // 如果leftInfo不为null，rightInfo必为null
        // 如果leftInfo为null，rightInfo可能为null，也可能不为null
        return (leftInfo != null) ? leftInfo : rightInfo;
    }

    /**
     * 获取最大BST子树的信息
     */
    private static class Info {
        public TreeNode root; // BST的根节点信息
        public int size; // BST的节点个数
        public int min; // BST的节点最小值
        public int max; // BST的节点最大值，和最小值一起，可以判断和其它节点放一起是不是BST

        public Info(TreeNode root, int size, int min, int max) {
            this.root = root;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    /**
     * 自顶向下
     * 时间复杂度：O(n) * O(n) = O(n^2)
     */
    public int largestBSTSubtree2(TreeNode root) {
        if (root == null)
            return 0;
        if (isBST(root)) // 如果本身就是二叉搜索树，直接返回它的节点个数
            return nodesCount(root);

        // 如果本身不是二叉搜索树，判断它的左子树和右子树，找出二叉搜索树，找到数量比较多的那一个
        return Math.max(largestBSTSubtree2(root.left), largestBSTSubtree2(root.right));
    }

    /**
     * 判断以 root 为根节点的树是否是二叉搜索树
     */
    private boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        return min < root.val && max > root.val
                && isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

    /**
     * 计算以 root 为根节点的二叉搜索树的节点数量
     */
    private int nodesCount(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + nodesCount(root.left) + nodesCount(root.right);
    }
}
