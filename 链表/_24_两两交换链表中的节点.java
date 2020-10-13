package 链表;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @author beastars
 */
public class _24_两两交换链表中的节点 {
    /**
     * 非递归
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        // prev -> first -> second，交换first和second的顺序：prev -> second -> first
        // 之后再将first变为prev，交换下一组的顺序
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
        }

        return dummyNode.next;
    }

    /**
     * 递归
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // head -> next -> head2 -> next2
        // head -> next -> next2 -> head2
        // next -> head -> next2 -> head2
        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;

        return next;
    }
}
