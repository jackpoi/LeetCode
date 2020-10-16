package 数组;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 *
 * @author beastars
 */
public class _977_有序数组的平方 {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0)
            return new int[0];
        if (A.length == 1)
            return new int[]{A[0] * A[0]};

        int left = 0;
        int right = A.length - 1;
        int cur = right;
        int[] res = new int[A.length];

        while (cur >= 0) {
            if (Math.abs(A[right]) >= Math.abs(A[left])) {
                res[cur--] = A[right] * A[right--];
            } else {
                res[cur--] = A[left] * A[left++];
            }
        }

        return res;
    }
}
