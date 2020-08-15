package 数组;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author beastars
 */
public class _88_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] <= nums2[n]) {
                nums1[index--] = nums2[n--];
            } else {
                nums1[index--] = nums1[m--];
            }
        }

        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int l1 = m - 1;
        int l2 = n - 1;
        int cur = nums1.length - 1;

        while (l2 >= 0) {
            if (l1 >= 0 && nums1[l1] > nums2[l2]) {
                nums1[cur--] = nums1[l1--];
            } else { // 如果 nums1 数组已经排序完毕，把 2 数组的剩下元素填充到 1 数组；
                // 如果是 2 数组比 1 数组大，把 2 数组的该元素放到到 1 数组
                nums1[cur--] = nums2[l2--];
            }
        }
    }
}
