package 链表;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author beastars
 */
public class _142_环形链表II {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        /*
        起点到入环点的长度为a，入环点到相遇点的长度为b
        快指针走的长度为慢指针的两倍，则慢指针走了(a+b)，快指针走了2(a+b)
        也就是说慢指针再走(a+b)个长度也能到达相遇点，因此可以让一个新指针从起点出发，
        这个新指针和慢指针速度相同，也需要走(a+b)个长度到相遇点，
        而且有一个相同的路径就是入环点到相遇点的长度b，
        因此当他们同时走了a个长度的时候，就是同时到达了入环点
         */

        if (hasCycle) {
            ListNode newSlow = head;
            while (newSlow != slow) {
                newSlow = newSlow.next;
                slow = slow.next;
            }
            return newSlow;
        } else {
            return null;
        }
    }
}
