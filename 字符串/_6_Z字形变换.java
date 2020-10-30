package 字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 *
 * @author beastars
 */
public class _6_Z字形变换 {
    /**
     * 0     6      12        18
     * 1   5 7   11 13    17
     * 2 4   8 10   14 16
     * 3     9      15
     * 对于n行的, s中的第i个字符：
     * 对余数进行判断
     * <p>
     * i%(2n-2) == 0 ----> row0
     * i%(2n-2) == 1 & 2n-2-1 ----> row1
     * i%(2n-2) == 2 & 2n-2-2 ----> row2
     */
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
