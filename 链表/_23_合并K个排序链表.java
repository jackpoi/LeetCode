package 链表;

import javax.print.attribute.standard.NumberUp;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * @author beastars
 */
public class _23_合并K个排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        if (lists.length == 2)
            return mergeList(lists[0], lists[1]);

        int mid = lists.length >> 1;
        ListNode[] l1 = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            l1[i] = lists[i];
        }
        ListNode[] l2 = new ListNode[lists.length - mid];
        for (int i = mid; i < lists.length; i++) {
            l2[i - mid] = lists[i];
        }

        return mergeList(mergeKLists(l1), mergeKLists(l2));
    }

    private ListNode mergeList(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode node = null;

        if (list1.val > list2.val) {
            node = list2;
            node.next = mergeList(list1, list2.next);
        } else {
            node = list1;
            node.next = mergeList(list1.next, list2);
        }

        return node;
    }
}
