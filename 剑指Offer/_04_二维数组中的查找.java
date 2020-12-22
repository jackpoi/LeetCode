package 剑指Offer;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 *
 * @author beastars
 */
public class _04_二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        /*
        从右上角看，是一个二叉搜索树
        从右上角的值开始进行比较
            如果该值大于目标，向左移动
            如果该值小于目标，向下移动

             ------→ 逐渐变大
            |
            |
            ↓
            逐渐变大
         */
        int col = matrix[0].length - 1;
        int row = 0;
        int curr; // 当前进行比较的值

        while (col >= 0 && row < matrix.length) {
            curr = matrix[row][col]; // 刚开始是右上角的值
            if (curr > target) {
                col--;
            } else if (curr < target) {
                row++;
            } else {
                return true;
            }
        }

        return false;
    }
}
