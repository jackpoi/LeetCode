package 字符串;

/**
 * https://leetcode-cn.com/problems/long-pressed-name/
 *
 * @author beastars
 */
public class _925_长按键入 {
    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length())
            return false;

        int n = 0, t = 0;

        while (n < name.length() && t < typed.length()) {
            if (name.charAt(n) == typed.charAt(t)) {
                t++;
                n++;
            } else if (t > 0 && typed.charAt(t) == typed.charAt(t - 1)) {
                t++;
            } else {
                return false;
            }
        }

        while (t < typed.length() - 1) {
            // saeed ssaaedd
            if (typed.charAt(t) != typed.charAt(t + 1)) {
                return false;
            }
            t++;
        }

        return n == name.length();
    }
}
