package 动态规划;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 *
 * @author beastars
 */
public class _718_最长重复子数组 {
    /**
     * 一维数组，动态规划
     */
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0)
            return 0;

        int[] dp = new int[B.length + 1];
        int max = 0;

        for (int i = 1; i <= A.length; i++) {
            int cur = 0;
            for (int j = 1; j <= B.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (A[i - 1] == B[j - 1]) {
                    dp[j] = leftTop + 1;
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
            }
        }

        return max;
    }

    /**
     * 二维数组，动态规划
     */
    public int findLength2(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0)
            return 0;

        int[][] dp = new int[A.length + 1][B.length + 1];
        int max = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }
}
