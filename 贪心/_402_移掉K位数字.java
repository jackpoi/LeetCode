package 贪心;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/remove-k-digits/
 */
public class _402_移掉K位数字 {
    public String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            // 要删除的位的索引
            int idx;
            // 从左到右，寻找第一个 前一位比后一位大 的字符，删除前一位，循环k次
            for (idx = 0; idx < sb.length() - 1; idx++) {
                // 如果这一位比下一位大，就删除这一位
                if (sb.charAt(idx) > sb.charAt(idx + 1)) {
                    break;
                }
            }
            sb.deleteCharAt(idx);
        }

        // 删除前面的 0
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    /**
     * 栈
     */
    public String removeKdigits2(String num, int k) {
        if (num.length() == k)
            return "0";
        LinkedList<Character> stack = new LinkedList<>();
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > chars[i]) {
                k--;
                stack.pollLast();
            }
            stack.offerLast(chars[i]);
        }
        for (int i = 0; i < k; i++) {
            stack.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        // 删除前面的 0
        boolean zero = true;
        while (!stack.isEmpty()) {
            Character c = stack.pollFirst();
            if (c == '0' && zero) {
                continue;
            }
            zero = false;
            sb.append(c);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
