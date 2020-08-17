package 栈_队列;

import java.util.Stack;

/**
 * @author beastars
 */
public class _155_最小栈 {
    private Stack<Integer> stack; // 正常存放数据
    private Stack<Integer> minStack; // 存放当前栈中最小数，和stack一一对应，同时pop同时push

    /** initialize your data structure here. */
    public _155_最小栈() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(x, minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
