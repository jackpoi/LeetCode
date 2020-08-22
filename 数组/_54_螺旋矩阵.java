package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 *
 * @author beastars
 */
public class _54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null)
            return null;

        List<Integer> list = new ArrayList<>();

        if (matrix.length == 0)
            return list;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            // left top -> right top
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            // right top -> right bottom
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            // 奇数行、偶数列的时候有问题
            if (top > bottom || left > right)
                break;

            // right bottom -> left bottom
            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;

            // left bottom -> left top
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }

        return list;
    }
}
