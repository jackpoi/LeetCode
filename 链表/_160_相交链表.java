package 链表;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author beastars
 */
public class _160_相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode currA = headA;
        ListNode currB = headB;

        while (currA != currB) {
            currA = currA == null ? headB : currA.next;
            currB = currB == null ? headA : currB.next;

            // 在不相交时，会陷入死循环
//            currA = currA.next == null ? headB : currA.next;
//            currB = currB.next == null ? headA : currB.next;
        }

        return currA;
    }
}
