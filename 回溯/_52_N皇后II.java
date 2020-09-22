package 回溯;

/**
 * https://leetcode-cn.com/problems/n-queens-ii/
 *
 * @author beastars
 */
public class _52_N皇后II {
    boolean[] cols; // 判断列上是否有皇后，存放的是col，如果有为true
    boolean[] leftTop; // 判断左上到右下斜线上是否有皇后，如果有为true
    boolean[] rightTop; // 判断右上到左下斜线上是否有皇后，如果有为true
    int result;

    public int totalNQueens(int n) {
        if (n < 1)
            return 0;
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1]; // nxn方格上的斜线数量是2n-1个
        rightTop = new boolean[leftTop.length];

        place(0);

        return result;
    }

    /**
     * 摆放第row行上的皇后
     */
    private void place(int row) {
        if (row == cols.length) {
            result++;
            return;
        }

        for (int col = 0; col < cols.length; col++) {
            if (cols[col])
                continue;
            // 左上到右下的斜线上的点，x-y的值都相等，
            // 又因为对角线上的点会是负数，负数最小为n-1，再加上n-1，防止数组越界
            int ltIdx = row - col + cols.length - 1;
            if (leftTop[ltIdx])
                continue;
            // 左上到右下的斜线上的点，x+y的值都相等
            int rtIdx = row + col;
            if (rightTop[rtIdx])
                continue;

            cols[col] = true;
            leftTop[ltIdx] = true;
            rightTop[rtIdx] = true;

            place(row + 1); // 对下一行的皇后寻找位置

            // 还原现场
            cols[col] = false;
            leftTop[ltIdx] = false;
            rightTop[rtIdx] = false;
        }
    }
}
