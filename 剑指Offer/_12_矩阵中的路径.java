package 剑指Offer;

/**
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 *
 * @author beastars
 */
public class _12_矩阵中的路径 {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        // 对board进行遍历，因为路径可以从矩阵中的任意一格开始
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, chars, i, j, 0)) // 0代表word的首字母，从首字母开始
                    return true;
            }
        }
        return false;
    }

    /**
     * 查找 board 中和 word[cur] 相等的字符
     *
     * @param i   board 的行坐标
     * @param j   board 的列坐标
     * @param cur word 的坐标，即所需要寻找的字符
     */
    private boolean dfs(char[][] board, char[] word, int i, int j, int cur) {
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0) // 边界条件
            return false;
        if (board[i][j] != word[cur]) // 如果该坐标的字符和路径中所需的字符不一样，说明不是该条路径
            return false;

        // 到了这里说明 board[i][j] == word[cur]，已经在board里找到了需要的字符
        if (cur == word.length - 1) // 如果当前需要的字符已经是最后一个，且已经找到，直接返回true
            return true;

        char temp = board[i][j]; // 如果该条路径可以向下走，备份当前坐标字符，不然回溯时就不是原来的子符
        board[i][j] = '.'; // 替换为不会出现的一个字符

        // 进行深度优先遍历，遍历当前字符的 上下左右 位置，看是否有需要的下一个字符
        boolean res = dfs(board, word, i - 1, j, cur + 1) || dfs(board, word, i + 1, j, cur + 1) ||
                dfs(board, word, i, j - 1, cur + 1) || dfs(board, word, i, j + 1, cur + 1);

        board[i][j] = temp; // 恢复现场
        return res;
    }
}
