package 动态规划;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author beastars
 */
public class _5_最长回文子串 {
    /**
     * 动态规划
     * dp[i][j] = true 表示字符串s[i, j] 是回文字段
     * 转移方程：dp[i][j] = (s[i] == s[j]) && (dp[i+1][j-1] == true)
     * dp[i+1][j-1] == true ： 表示如果边界相等，且前后往里缩进一格之后依然为回文字段，就说明是回文字段
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;

        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] == chars[j]) {
                    if (j - i < 3) { // j - 1 - (i + 1) + 1 < 2
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }
}
