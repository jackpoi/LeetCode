package 字符串;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * @author beastars
 */
public class _242_有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null)
            return false;
        if (s.length() != t.length())
            return false;

        // 已知都是小写字母
        int[] counts = new int[26];

        // 使用字符数组接收字符串，空间换时间
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        for (char c : sChar) {
            // a - 'a' = 0, b - 'a' = 1
            // ASCII 中，'a' = 97
            counts[c - 'a']++;
        }

        for (char c : tChar) {
            // 遍历字符串 t，由于字符串长度相同，遍历完成后，如果 count 数组没有低于 0 的数，说明是异位词
            if (--counts[c - 'a'] < 0)
                return false;
        }

        return true;
    }
}
