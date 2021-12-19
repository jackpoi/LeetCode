package 链表;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author beastars
 */
public class _234_回文链表 {
    /*
     * 先找出中间节点，将该节点后面的链表反转，反转之后就可以从后往前遍历后半部分
     * 两个指针，分别从前往后和从后往前遍历，比较是否相等
     * 一直到后半部分进入null，如果全部相等，说明是回文链表
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) // null或者长度为1
            return true;
        if (head.next.next == null) // 长度为2
            return head.val == head.next.val;

        // 长度为3或以上
        // 找到中间节点
        ListNode mid = middleNode(head);
        // 反转中间节点后面的链表
        ListNode rHead = reverseList(mid.next);
        ListNode lHead = head;

        // 当反转的链表遍历到null时，还没有发现不同，可以认定为是回文链表
        while (rHead != null) {
            if (lHead.val != rHead.val) {
                return false;
            }

            lHead = lHead.next;
            rHead = rHead.next;
        }

        return true;
    }

    /**
     * 找到 root 的中间节点
     * 快慢指针
     */
    private ListNode middleNode(ListNode root) {
        ListNode slow = root;
        ListNode fast = root;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * 反转链表
     * 1>2>3>2>1>null -> 1>2>3>2(>null)<1
     */
    private ListNode reverseList(ListNode root) {
//        if (root == null || root.next == null)
//            return root;

        ListNode node = null;
        while (root != null) {
            ListNode tmp = root.next;
            root.next = node;
            node = root;
            root = tmp;
        }

        return node;
    }

    /**
     * 不破坏链表的原来结构
     *
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null)
            return true;
        if (head.val == head.next.val)
            return true;

        ListNode mid = middleNode(head);
        ListNode lHead = head;
        ListNode rHead = reverseList(mid.next);
        ListNode rOldHead = rHead; // 备份反转后的链表

        while (rHead != null) {
            if (lHead.val != rHead.val) {
                // 重新反转链表，恢复表的原来结构
                reverseList(rOldHead);
                return false;
            }

            lHead = lHead.next;
            rHead = rHead.next;
        }

        // 重新反转链表，恢复表的原来结构
        reverseList(rOldHead);
        return true;
    }
}
