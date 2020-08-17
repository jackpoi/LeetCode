package 链表;

/**
 * https://leetcode-cn.com/problems/partition-list/
 *
 * @author beastars
 */
public class _86_分隔链表 {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;

        ListNode lHead = new ListNode(0); // 创建比 x 小的链表的虚拟头节点
        ListNode lLast = lHead; // 创建尾部指针，用于添加
        ListNode rHead = new ListNode(0); // 创建比 x 大的链表的虚拟头节点
        ListNode rLast = rHead;

        while (head != null) {
            if (head.val < x) {
                lLast.next = head; // 尾部指向比 x 小的节点
                lLast = head;
            } else {
                rLast.next = head; // 尾部指向比 x 大的节点
                rLast = head;
            }
            head = head.next;
        }

        // 拼接
        lLast.next = rHead.next;
        // 将最后一个节点的next指向null，如果没有这一步，rLast可能指向的还是之前的一个节点
        rLast.next = null;

        return lHead.next;
    }
}
