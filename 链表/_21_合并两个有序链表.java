package 链表;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author beastars
 */
public class _21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preNode = new ListNode(-1);

        ListNode node = preNode;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        node.next = l1 == null ? l2 : l1;

        return preNode.next;
    }

    /**
     * 递归方式
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode node = null;
        if (l1.val > l2.val) {
            node = l2;
            l2.next = mergeTwoLists(l1, l2.next);
        } else {
            node = l1;
            l1.next = mergeTwoLists(l1.next, l2);
        }

        return node;
    }
}
