package 字符串;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author beastars
 */
public class _5_最长回文子串 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        if (s.length() == 1)
            return s;

        int[] range = new int[2];
        char[] chars = s.toCharArray();

        // 将字符串里连续相同的字符看作是一个字符
        for (int i = 0; i < chars.length; i++) {
            i = longestStr(chars, i, range);
        }

        return s.substring(range[0], range[1] + 1);
    }

    /**
     * 获取left索引开始的chars字符组的回文字符串
     *
     * @param range 回文字符串的开始索引和结束索引
     * @return 返回相同字符串的最后一位的索引
     */
    private int longestStr(char[] chars, int left, int[] range) {
        int right = left;

        // 找出连续相同的字符
        while (right < chars.length - 1 && chars[left] == chars[right + 1]) {
            right++;
        }

        // 将相同字符串的最后一位的索引保存下来返回
        int ans = right;

        // 在相同字符串的左右进行扩散，看是否有回文字符串
        while (left > 0 && right < chars.length - 1 && chars[left - 1] == chars[right + 1]) {
            left--;
            right++;
        }

        // 将回文字符串的长度保存下来
        if (right - left > range[1] - range[0]) {
            range[0] = left;
            range[1] = right;
        }

        return ans;
    }
}
