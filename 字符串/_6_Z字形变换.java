package 字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 *
 * @author beastars
 */
public class _6_Z字形变换 {
    public String convert(String s, int numRows) {
        if (s == null || numRows > s.length() || numRows <= 1)
            return s;

        StringBuilder res = new StringBuilder();
        int len = (numRows << 1) - 2;
        for (int i = 0; i < numRows; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int v = j % len;
                if (v == i || v == len - i) {
                    sb.append(s.charAt(j));
                }
            }
            res.append(sb);
        }

        return res.toString();
    }
}
