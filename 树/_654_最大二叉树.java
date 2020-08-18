package 树;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 *
 * @author beastars
 */
public class _654_最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return findRoot(nums, 0, nums.length);
    }

    /**
     * 找出指定范围的根节点
     * nums[left, right)
     */
    private TreeNode findRoot(int[] nums, int left, int right) {
        if (left == right)
            return null;

        // 找出最大值对应的索引
        int maxIdx = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        // 递归调用，找出左子树以及右子树
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = findRoot(nums, left, maxIdx); // nums[left, maxIdx)
        root.right = findRoot(nums, maxIdx + 1, right); // nums[maxIdx + 1, right)
        return root;
    }
}
