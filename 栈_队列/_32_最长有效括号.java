package 栈_队列;

import java.util.Deque;
import java.util.LinkedList;

public class _32_最长有效括号 {
    public int longestValidParentheses(String s) {
        if (s.length() == 0)
            return 0;

        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            // 每次把（的下标压栈，遇到）时把（弹出栈，
            // 如果弹出栈之后，栈还有值，说明栈里还有（，更新最大值，接着匹配
            //      长度为当前）下标匹配的（的上一个值的下标
            // 如果栈为空，说明这一段到这里就匹配完了，把自己的下标压栈
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }
}
