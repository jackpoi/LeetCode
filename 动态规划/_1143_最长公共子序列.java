package 动态规划;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 *
 * @author beastars
 */
public class _1143_最长公共子序列 {
    /**
     * 一维数组，动态规划
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0)
            return 0;

        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        int[] dp = new int[chars2.length + 1];
        for (int i = 1; i <= chars1.length; i++) {
            int cur = 0;
            for (int j = 1; j <= chars2.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }

        return dp[chars2.length];
    }

    /**
     * 二维数组，动态规划
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0)
            return 0;

        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[chars1.length][chars2.length];
    }

    /**
     * 递归，超时
     */
    public int longestCommonSubsequence3(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0)
            return 0;

        return lcs(text1.toCharArray(), text1.length(), text2.toCharArray(), text2.length());
    }

    private int lcs(char[] text1, int len1, char[] text2, int len2) {
        if (len1 == 0 || len2 == 0)
            return 0;

        if (text1[len1 - 1] == text2[len2 - 1]) {
            return lcs(text1, len1 - 1, text2, len2 - 1) + 1;
        }
        return Math.max(lcs(text1, len1 - 1, text2, len2),
                lcs(text1, len1, text2, len2 - 1));
    }
}
