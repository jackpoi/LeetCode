package 剑指Offer;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 *
 * @author beastars
 */
public class _05_替换空格 {
    public String replaceSpace(String s) {
        if (s.length() == 0)
            return s;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
