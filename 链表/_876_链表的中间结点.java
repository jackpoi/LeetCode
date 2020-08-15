package 链表;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * @author beastars
 */
public class _876_链表的中间结点 {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode middleNode2(ListNode head) {
        int i = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            i++;
        }
        int k = 0;
        node = head;
        while (k < i / 2) {
            node = node.next;
            k++;
        }
        return node;
    }

    public ListNode middleNode3(ListNode head) {
        ListNode[] arr = new ListNode[100];
        int i = 0;
        while (head != null) {
            arr[i++] = head;
            head = head.next;
        }

        return arr[(i + 1) / 2];
    }
}
