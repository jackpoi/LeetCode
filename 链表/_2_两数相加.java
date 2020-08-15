package 链表;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author beastars
 */
public class _2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode dummyNode = new ListNode(0); // 设置虚拟头节点
        ListNode last = dummyNode; // 设置尾节点，用来添加新节点
        int carry = 0; // 进位

        while (l1 != null || l2 != null) {
            int v1 = 0; // 初始化 v1 为 0，只有当 l1 不为空时才将指赋给 v1
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            int v2 = 0;
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int sum = v1 + v2 + carry;
            carry = sum / 10; // 计算进位

            last.next = new ListNode(sum % 10); // 向后添加新节点
            last = last.next; // 指向最后一个节点
        }

        if (carry > 0) { // 如果还存在进位，将进位的值添加新节点（进位必然为 1，因为每个节点只能存储一位数字）
            last.next = new ListNode(carry);
        }
        return dummyNode.next;
    }
}
