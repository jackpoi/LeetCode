package 数组;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 * @author beastars
 */
public class _349_两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }

        Set<Integer> minSet;
        Set<Integer> maxSet;

        if (set1.size() <= set2.size()) {
            minSet = set1;
            maxSet = set2;
        } else {
            minSet = set2;
            maxSet = set1;
        }

        int[] nums = new int[minSet.size()];
        int index = 0;

        for (Integer n : minSet) {
            if (maxSet.contains(n)) {
                nums[index++] = n;
            }
        }

        return Arrays.copyOf(nums, index);
    }
}
