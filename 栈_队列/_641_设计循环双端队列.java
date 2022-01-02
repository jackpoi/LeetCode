package 栈_队列;

/**
 * https://leetcode-cn.com/problems/design-circular-deque/
 */
public class _641_设计循环双端队列 {
    private int size = 0;
    private int[] elements;
    private int head = 0;
    private int tail;

    public _641_设计循环双端队列(int k) {
        elements = new int[k];
        tail = k - 1;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (head == 0) {
            head = elements.length - 1;
        } else {
            head--;
        }
        elements[head] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (tail == elements.length - 1) {
            tail = 0;
        } else {
            tail++;
        }
        elements[tail] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (head == elements.length - 1) {
            head = 0;
        } else {
            head++;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (tail == 0) {
            tail = elements.length - 1;
        } else {
            tail--;
        }
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return elements[head];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return elements[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return elements.length == size;
    }
}
