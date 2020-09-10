package 数组;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * @author beastars
 */
public class _4_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0) {
            return len2 % 2 == 0
                    ? (nums2[len2 / 2] + nums2[len2 / 2 - 1]) / 2.0
                    : nums2[(len2 - 1) / 2];
        }
        if (len2 == 0) {
            return len1 % 2 == 0
                    ? (nums1[len1 / 2] + nums1[len1 / 2 - 1]) / 2.0
                    : nums1[len1 / 2];
        }

        int[] nums = new int[len1 + len2];
        int idx1 = 0;
        int idx2 = 0;
        int count = 0;
        while (count != (len1 + len2)) {
            if (idx1 == len1) {
                while (idx2 != len2) {
                    nums[count++] = nums2[idx2++];
                }
                break;
            }
            if (idx2 == len2) {
                while (idx1 != len1) {
                    nums[count++] = nums1[idx1++];
                }
                break;
            }
            if (nums1[idx1] < nums2[idx2]) {
                nums[count++] = nums1[idx1++];
            } else {
                nums[count++] = nums2[idx2++];
            }
        }

        return count % 2 != 0
                ? nums[count / 2] * 1.0
                : (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
    }
}
