package 贪心;

/**
 * https://leetcode-cn.com/problems/score-after-flipping-matrix/
 *
 * @author beastars
 */
public class _861_翻转矩阵后的得分 {
    public int matrixScore(int[][] A) {
        int rowLen = A.length;
        int colLen = A[0].length;

        // 移动行，保证第一列都是1
        // 1.如果第一列为1，不用移动
        // 2.如果第一列为0，反转，将第一列变为1
        for (int row = 0; row < rowLen; row++) {
            if (A[row][0] == 0) {
                // 如果第一列为0，反转，遍历该行，将第一列变为1
                for (int col = 0; col < colLen; col++) {
                    A[row][col] = A[row][col] == 0 ? 1 : 0;
                }
            }
        }

        // 每一行的第一个都为1了，计算值 1xxx = 1*2^3 = 8
        int res = rowLen * (1 << (colLen - 1));

        // 将除第一列之后的每一列，都变为1比较多的列
        for (int col = 1; col < colLen; col++) {
            int count = 0; // 计算每一列1的个数
            for (int[] row : A) {
                if (row[col] == 1) {
                    count++;
                }
            }
            // rowLen - count 就是0的个数
            // 如果1比0多，不变换，否则反转1和0
            count = Math.max(count, rowLen - count);
            // 如果该列为0就不加
            // 每一行的结果就是该列为1时，xx1xxx = 1*2^3 = 8
            res += count * (1 << (colLen - col - 1));
        }

        return res;
    }
}
