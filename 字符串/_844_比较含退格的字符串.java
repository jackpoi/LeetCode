package 字符串;

/**
 * https://leetcode-cn.com/problems/backspace-string-compare/
 *
 * @author beastars
 */
public class _844_比较含退格的字符串 {
    public boolean backspaceCompare(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int is = S.length() - 1;
        int it = T.length() - 1;
        int ns = 0;
        int nt = 0;

        while (is >= 0 || it >= 0) {
            while (is >= 0) {
                if (s[is] == '#') {
                    ns++;
                    is--;
                } else if (ns > 0) {
                    is--;
                    ns--;
                } else {
                    break;
                }
            }
            while (it >= 0) {
                if (t[it] == '#') {
                    nt++;
                    it--;
                } else if (nt > 0) {
                    it--;
                    nt--;
                } else {
                    break;
                }
            }
            if (is >= 0 && it >= 0) {
                if (s[is] != t[it]) {
                    return false;
                }
            } else {
                if (is >= 0 || it >= 0) {
                    return false;
                }
            }
            is--;
            it--;
        }

        return true;
    }
}
