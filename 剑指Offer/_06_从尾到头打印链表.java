package 剑指Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @author beastars
 */
public class _06_从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        if (head == null || head.next == null)
            return head == null ? new int[0] : new int[]{head.val};

        /*
        用数组接收反转链表的值，只需要正着遍历链表，数组从后向前接收就好了
         */
        int count = 0; // 计算结点的数量
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }

        int[] res = new int[count];
        // 从后往前接收链表的值
        for (int i = count - 1; i >= 0; i--) {
            res[i] = head.val;
            head = head.next;
        }

        return res;
    }

    public int[] reversePrint2(ListNode head) {
        if (head == null || head.next == null)
            return head == null ? new int[0] : new int[]{head.val};

        List<Integer> list = new LinkedList<>();

        int count = 0; // 数有多少个节点

        // 先反转链表
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next; // 指向原链表的后续链表，防止被回收
            head.next = newHead;
            newHead = head;
            head = temp;
            count++;
        }

        int[] res = new int[count];

        // 遍历链表输出
        for (int i = 0; i < count; i++) {
            res[i] = newHead.val;
            newHead = newHead.next;
        }

        return res;
    }
}
