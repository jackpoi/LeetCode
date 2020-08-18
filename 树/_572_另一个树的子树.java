package 树;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 *
 * @author beastars
 */
public class _572_另一个树的子树 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null)
            return false;
//        return postSerialize(s).contains(postSerialize(t));
        return kmpSearch(postSerialize(s), postSerialize(t));
    }

    public int[] GetNext(String p) {
        int[] next = new int[p.length()];
        char[] chs = p.toCharArray();

        next[0] = -1;
        int i = -1;
        int j = 0;

        while (j < chs.length - 1) {
            if (i == -1 || chs[i] == chs[j]) {
                i++;
                j++;
                if (chs[i] == chs[j]) {
                    // 当chs[i] == chs[j]时会增大时间复杂度，进行优化，当相等时，再次计算next值
                    next[j] = next[i];
                } else {
                    next[j] = i;
                }
            } else {
                i = next[i];
            }
        }
        return next;
    }

    // kmp 算法
    public boolean kmpSearch(String s, String p) {
        int[] next = GetNext(p);
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        int i = 0;
        int j = 0;

        while (i < cs.length && j < cp.length) {
            if (j == -1 || cs[i] == cp[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        return j == cp.length;
    }

    /**
     * 后序遍历序列化树
     */
    private String postSerialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postSerialize(root, sb);
        return sb.toString();
    }

    /**
     * 后序遍历，拼接字符串
     */
    private void postSerialize(TreeNode root, StringBuilder sb) {
        if (root.left != null) {
            postSerialize(root.left, sb);
        } else {
            sb.append("#!");
        }
        if (root.right != null) {
            postSerialize(root.right, sb);
        } else {
            sb.append("#!");
        }
        sb.append(root.val).append("!");
    }
}
