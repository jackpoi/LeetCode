package 链表;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 *
 * @author beastars
 */
public class _146_LRU缓存机制 {
    // 使用哈希表和双向链表实现
    private Map<Integer, Node> map;
    private int capacity;
    private Node first; // 虚拟头节点
    private Node last; // 虚拟尾节点

    public _146_LRU缓存机制(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        first = new Node();
        last = new Node();
        first.next = last;
        last.prev = first;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) // 如果没有，直接返回
            return -1;

        // 如果有，先删除，再添加到链表的最前面，表示最近访问
        removeNode(node);
        addAfterFirst(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) { // 如果已经有了，更新值，放到最前面
            node.value = value;
            removeNode(node);
        } else { // 如果没有，添加一对新的key-value
            if (map.size() == capacity) {
                // 如果缓存满了，在map和链表中删除最近最少访问的节点，也就是链表的最后一个
                removeNode(map.remove(last.prev.key));
            }
            // 将新添加的放入map
            node = new Node(key, value);
            map.put(key, node);
        }
        // 将新添加的放入链表的头部
        addAfterFirst(node);
    }

    /**
     * 将节点放到虚拟头节点first的后面，也就是放到实际的最前面
     */
    private void addAfterFirst(Node node) {
        // node -> first.next
        // node <- first.next
        node.next = first.next;
        first.next.prev = node;
        // first -> node
        // first <- node
        first.next = node;
        node.prev = first;
    }

    /**
     * 删除节点
     */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private static class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
