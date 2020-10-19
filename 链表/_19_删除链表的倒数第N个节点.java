package 链表;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author beastars
 */
public class _19_删除链表的倒数第N个节点 {
    /**
     * 快慢指针，快指针先走n步，之后快慢指针一起走，快指针指向最后一个的时候，慢指针就是要删除的节点
     * head -> ... -> prev -> slow -> ... -> fast -> null
     * 此处，可以将快指针多走一步，这样慢指针就会在prev处，要删除slow节点，只需要slow.next = slow.next.next即可
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null) {
            if (n > 0) {
                fast = fast.next;
                n--;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }

        if (n > 0) // 如果n>0，说明n和链表长度相等，是删除头节点，只需要返回head.next即可
            return head.next;

        slow.next = slow.next.next;

        return head;
    }
}
