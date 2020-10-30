package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 对角线优化
 * https://leetcode-cn.com/problems/n-queens/
 *
 * @author beastars
 */
public class _51_N皇后_2 {
    int[] queens; // 索引是行row，值是列col，存放皇后信息
    boolean[] cols; // 判断列上有没有皇后
    boolean[] leftTop; // 判断左上到右下斜线有没有皇后
    boolean[] rightTop; // 判断右上到左下斜线有没有皇后
    List<List<String>> lists;

    public List<List<String>> solveNQueens(int n) {
        lists = new ArrayList<>();
        if (n < 1)
            return lists;

        queens = new int[n];
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1]; // 有多少个斜线
        rightTop = new boolean[leftTop.length];

        place(0);
        return lists;
    }

    /**
     * 在第row行放置皇后
     */
    private void place(int row) {
        if (row == queens.length) {
            lists.add(format());
            return;
        }

        for (int col = 0; col < queens.length; col++) {
            if (cols[col]) // 判断列上是否有皇后
                continue;
            // 左上角 -> 右下角的对角线索引：row – col + n - 1
            int ltIdx = row - col + cols.length - 1;
            if (leftTop[ltIdx]) // 判断左上到右下斜线是否有皇后
                continue;
            // 右上角 -> 左下角的对角线索引：row + col
            int rtIdx = row + col;
            if (rightTop[rtIdx]) // 判断右上到左下斜线是否有皇后
                continue;

            // 将皇后放入
            queens[row] = col;
            cols[col] = true;
            leftTop[ltIdx] = true;
            rightTop[rtIdx] = true;
            // 回溯
            place(row + 1);
            // 还原现场
            cols[col] = false;
            leftTop[ltIdx] = false;
            rightTop[rtIdx] = false;
        }
    }

    private List<String> format() {
        List<String> list = new ArrayList<>();
        for (int row = 0; row < cols.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < cols.length; col++) {
                if (queens[row] == col) {
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
