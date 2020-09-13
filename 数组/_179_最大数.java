package 数组;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/largest-number/
 *
 * @author beastars
 */
public class _179_最大数 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";

        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
        }
        String s = sb.toString();
        if (s.charAt(0) == '0') {
            return "0";
        }
        return s;
    }
}
