package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 *
 * @author beastars
 */
public class _51_N皇后 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();

        if (n < 1)
            return lists;

        int[] cols = new int[n]; // 索引是行row，值是列col，cols[2,3]代表第二行第三列有皇后

        place(cols, 0, lists);

        return lists;
    }

    /**
     * 摆放row行的皇后
     */
    private void place(int[] cols, int row, List<List<String>> lists) {
        if (row == cols.length) {
            lists.add(show(cols));
            return;
        }

        for (int col = 0; col < cols.length; col++) {
            if (isValid(cols, row, col)) {
                cols[row] = col; // 将皇后放到这个地方，剪枝
                place(cols, row + 1, lists); // 回溯
            }
        }
    }

    /**
     * 判断cols中第row行第col列是否可以放置皇后
     */
    private boolean isValid(int[] cols, int row, int col) {
        // 判断这个列是否可以放置皇后(从第一行到最后一行看这一列是否有皇后)，
        // 如果这列没有皇后，说明可以放置
        for (int i = 0; i < row; i++) {
            if (cols[i] == col) { // 说明这一列有皇后，第i行的皇后在第col列
                return false;
            }
            if (row - i == Math.abs(col - cols[i])) {
                return false;
            }
        }
        return true;
    }

    private List<String> show(int[] cols) {
        List<String> list = new ArrayList<>();
        for (int row = 0; row < cols.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        return list;
    }
}
