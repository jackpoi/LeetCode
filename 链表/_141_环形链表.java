package 链表;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author beastars
 */
public class _141_环形链表 {
    /**
     * 使用快慢指针，慢指针从首节点开始，每次移动一位，快指针从第二个节点开始，每次移动两位，
     * 如果是环形链表，那么这两个指针最后一定会进入环形中，一定有一个时间会相遇，如果相遇，就说明有环形链表
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
