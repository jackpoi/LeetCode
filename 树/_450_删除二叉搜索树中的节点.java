package 树;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 *
 * @author beastars
 */
public class _450_删除二叉搜索树中的节点 {
    /*
    * 要删除的节点为叶子节点，可以直接删除。
    * 要删除的几点不是叶子节点且拥有右节点，则该节点可以由该节点的后继节点进行替代，该后继节点位于右子树中较低的位置。然后可以从后继节点的位置递归向下操作以删除后继节点。
    * 要删除的节点不是叶子节点，且没有右节点但是有左节点。这意味着它的后继节点在它的上面，但是我们并不想返回。我们可以使用它的前驱节点进行替代，然后再递归的向下删除前驱节点。
    * */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key > root.val) {
            // 如果 key > root.val，说明要删除的节点在右子树，root.right = deleteNode(root.right, key)
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            // 如果 key < root.val，说明要删除的节点在左子树，root.left = deleteNode(root.left, key)
            root.left = deleteNode(root.left, key);
        } else {
            // 如果 key == root.val，则该节点就是我们要删除的节点
            if (root.left == null && root.right == null) {
                // 如果该节点是叶子节点，则直接删除它：root = null
                root = null;
            } else if (root.right != null) {
                // 如果该节点不是叶子节点且有右节点，则用它的后继节点的值替代 root.val = successor.val，然后删除后继节点
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                // 如果该节点不是叶子节点且只有左节点，则用它的前驱节点的值替代 root.val = predecessor.val，然后删除前驱节点
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    private int predecessor(TreeNode node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }

    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
