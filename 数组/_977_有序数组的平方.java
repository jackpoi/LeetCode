package 数组;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 *
 * @author beastars
 */
public class _977_有序数组的平方 {
    public int[] sortedSquares(int[] A) {
        if (A.length == 1) {
            A[0] = A[0] * A[0];
            return A;
        }

        int left = 0;
        int right = A.length - 1;
        int curr = right;
        int[] arr = new int[A.length];

        while (left <= right) {
            if (A[left] < 0 && Math.abs(A[left]) >= Math.abs(A[right])) {
                arr[curr--] = (int) Math.pow(A[left++], 2);
            } else {
                arr[curr--] = (int) Math.pow(A[right--], 2);
            }
        }

        return arr;
    }
}
