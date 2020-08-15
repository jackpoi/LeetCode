package 链表;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * @author beastars
 */
public class _203_移除链表元素 {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;
        ListNode node = head;
        if (node != null) {
            while (node.next != null) {
                if (node.next.val == val) {
                    node.next = node.next.next;
                } else
                    node = node.next;
            }
        }
        return head;
    }
}
