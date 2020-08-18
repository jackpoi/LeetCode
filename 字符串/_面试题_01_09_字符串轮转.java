package 字符串;

/**
 * https://leetcode-cn.com/problems/string-rotation-lcci/
 *
 * @author beastars
 */
public class _面试题_01_09_字符串轮转 {
    /*
     * 如果是轮转字符串，那么一个字符串与自己拼接到一起，必然包含所有的轮转字符串
     * t r u e + t r u e = t r u e t r u e
     * 1. t r u e : r u e t
     * 2. t r u e : u e t r
     * 3. t r u e : e t r u
     */
    public boolean isFlipedString(String s1, String s2) {
        if (s1 == null && s2 == null)
            return true;
        if (s1 == null || s2 == null)
            return false;
        if (s1.length() != s2.length())
            return false;

        return (s1 + s1).contains(s2);
    }
}
