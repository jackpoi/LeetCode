package 链表;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 *
 * @author beastars
 */
public class _面试题22_链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node = head;
        int n = 0;
        while (node.next != null) {
            n++;
            node = node.next;
        }
        for (int i = 0; i <= n - k; i++) {
            head = head.next;
        }
        return head;
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        int n = 0;
        while (fast != null) {
            if (n >= k) // 快慢指针的差值为k，即当快指针到达尾节点时，慢指针的位置恰好是k
                slow = slow.next;
            fast = fast.next;
            n++;
        }
        return slow;
    }
}
