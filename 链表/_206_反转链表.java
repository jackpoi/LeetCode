package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author beastars
 */
public class _206_反转链表 {

    /**
     * 递归方法，假设只剩首节点没有反转，剩下的都已经反转过来
     * 1>2>3>4>5>null >> 1> null<2<3<4<5
     * 进行递归，将已经反转的和没有反转的进行反转
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 头插法，创建一个新链表，将原链表的首节点转移过去，再将原链表的首节点删除，首节点替换为原来首节点的next
     * 转移之前，要将首节点的next被引用，否则转移之后，剩下的链表就会因为没有引用被释放掉
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
