package 树;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * @author beastars
 */
public class _108_将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode(0);
        return sortedArrayToBST(root, nums, 0, nums.length);
    }

    /**
     * [left, right)
     */
    private TreeNode sortedArrayToBST(TreeNode node, int[] nums, int left, int right) {
        if (right - left <= 0)
            return null;
        int mid = (right + left) >> 1;
        node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(node, nums, left, mid);
        node.right = sortedArrayToBST(node, nums, mid + 1, right);
        return node;
    }
}
