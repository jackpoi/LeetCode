package 剑指Offer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 * @author beastars
 */
public class _09_用两个栈实现队列 {
    private LinkedList<Integer> inStack;
    private LinkedList<Integer> outStack;

    public _09_用两个栈实现队列() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty() && inStack.isEmpty()) {
            return -1;
        } else if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        } else {
            return outStack.pop();
        }
    }
}
