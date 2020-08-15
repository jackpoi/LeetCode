package 二叉树;

/**
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 *
 * @author beastars
 */
public class _700_二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        /*while (root != null) {
            if (root.val > val)
                root = root.left;
            else if (root.val < val)
                root = root.right;
            else
                break;
        }
        return root;*/

        while (true) {
            if (root == null || root.val == val)
                return root;
            root = root.val > val ? root.left : root.right;
        }
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;
        return root.val > val ? searchBST2(root.left, val) : searchBST2(root.right, val);
    }
}
