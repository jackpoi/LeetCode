package 字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author beastars
 */
public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        char[] chars = s.toCharArray();
        // 用来保存每一个字符上一次出现的位置
        Map<Character, Integer> map = new HashMap<>();
        map.put(chars[0], 0); // 将第一个字符添加进去

        int li = 0; // 以 i-1 位置字符结尾的最长不重复字符串的开始索引
        int max = 1; // 不重复子串的最大长度，默认为 1

        for (int i = 1; i < chars.length; i++) {
            Integer pi = map.get(chars[i]); // char[i] 的上一次出现的位置
            if (pi != null && li <= pi) {
                // 如果之前 char[i] 出现过，
                // 且以 char[i-1] 为结尾的最长不重复子串的开始位置小于等于 char[i] 的上一次出现的位置，
                // 也就是说以 char[i-1] 为结尾的之中有一个字符（即 pi，char[pi] == char[i]）与 char[i] 重复了，
                // 因此以 char[i] 为结尾的最长不重复子串的长度等于 pi 到 i 的距离，即 i - pi
                li = pi + 1; // 更新 li，因为 i 有重复了，所以将 li 更新为 i 的最长不重复子串，留给下个循环使用
            }
            // 如果 pi == null，说明该字符是第一次出现，添加到 map 中，不需要更新 li
            // 如果 li > pi，说明 pi 和 i 中间有重复的字符，li 和 i 中间没有重复的字符，也没有 i 对应的字符，不用更新 li
            map.put(chars[i], i);
            // 求出最长不重复子串的长度
            max = Math.max(max, i - li + 1);
        }

        return max;
    }

    /*
     * 假设给定输入都是单字节字符
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0)
            return 0;

        char[] chars = s.toCharArray();
        // 用来保存每一个字符上一次出现的位置
        int[] prevIdxes = new int[128]; // 使用 ASCII 表
        for (int i = 0; i < prevIdxes.length; i++) {
            // 初始化数组
            prevIdxes[i] = -1;
        }
        prevIdxes[chars[0]] = 0;

        int li = 0; // 以 i-1 位置字符结尾的最长不重复字符串的开始索引
        int max = 1; // 不重复子串的最大长度，默认为 1

        for (int i = 1; i < chars.length; i++) {
            int pi = prevIdxes[chars[i]]; // char[i] 的上一次出现的位置
            if (li <= pi) {
                li = pi + 1; // 更新 li，因为 i 有重复了，所以将 li 更新为 i 的最长不重复子串，留给下个循环使用
            }
            prevIdxes[chars[i]] = i;
            // 求出最长不重复子串的长度
            max = Math.max(max, i - li + 1);
        }

        return max;
    }
}
