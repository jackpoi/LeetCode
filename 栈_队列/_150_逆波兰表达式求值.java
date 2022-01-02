package 栈_队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class _150_逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(token)) {
                // 先弹出来的是减数
                Integer subtrahend = stack.pop();
                // 后弹出来的是被减数
                Integer minuend = stack.pop();
                stack.push(minuend - subtrahend);
            } else if ("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(token)) {
                // 先弹出来的是除数
                Integer divisor = stack.pop();
                // 后弹出来的是被除数
                Integer dividend = stack.pop();
                stack.push(dividend / divisor);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }
}
