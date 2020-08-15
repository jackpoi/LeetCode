package 链表;

/**
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * @author beastars
 */
public class _1290_二进制链表转整数 {
    public int getDecimalValue(ListNode head) {
        ListNode node = head;
        int sum = 0;
        while(node != null) {
            sum = (sum << 1) + node.val;
            node = node.next;
        }
        return sum;
    }
}
