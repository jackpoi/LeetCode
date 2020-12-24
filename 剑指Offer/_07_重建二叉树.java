package 剑指Offer;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 *
 * @author beastars
 */
public class _07_重建二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;

        return buildNode(preorder, 0, inorder, 0, inorder.length - 1);
    }

    /**
     * 建立左右子树
     *
     * @param startPre 前序遍历数组的开始索引，该索引也就是该条树的根节点
     * @param startIn  中序遍历数组的开始索引
     * @param endIn    中序遍历数组的结束索引，根据根节点在startIn-endIn的数组中找到根节点，那么左边就是左子树，右边就是右子树
     */
    private TreeNode buildNode(int[] preorder, int startPre, int[] inorder, int startIn, int endIn) {
        if (startPre >= preorder.length || startIn > endIn)
            return null;

        //创建结点
        TreeNode node = new TreeNode(preorder[startPre]);
        int index = 0;
        //找到当前节点root在中序遍历中的位置，然后再把数组分两半
        for (int i = startIn; i <= endIn; i++) {
            if (inorder[i] == node.val) {
                index = i;
                break;
            }
        }

        node.left = buildNode(preorder, startPre + 1, inorder, startIn, index - 1);
        node.right = buildNode(preorder, startPre + (index - startIn) + 1, inorder, index + 1, endIn);
        return node;
    }
}
