package 栈_队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 *
 * @author beastars
 */
public class _225_用队列实现栈 {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private Queue<Integer> tmp;

    /** Initialize your data structure here. */
    public _225_用队列实现栈() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        tmp = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (!(queue1.size() == 1)) { // 将队列1的前n-1个赋给队列2，队列1留下的就是最后进入的，即栈顶元素
            queue2.add(queue1.poll());
        }
        tmp = queue2;
        queue2 = queue1;
        queue1 = tmp; // 再把队列1和队列2交换
        return queue2.poll(); // 将队列2也就是原来的队列1最后一个元素弹出，清空队列2
    }

    /** Get the top element. */
    public int top() {
        while (!(queue1.size() == 1)) {
            queue2.add(queue1.poll());
        }
        int top = queue1.poll();
        queue2.add(top);
        tmp = queue2;
        queue2 = queue1;
        queue1 = tmp;
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
