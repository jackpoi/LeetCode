package 数组;

/**
 * https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
 * @author beastars
 */
public class _1365_有多少小于当前数字的数字 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[101];

        for (int i : nums) {
            arr[i]++;
        }

        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (nums[i] - 1 != -1) ? arr[nums[i] - 1] : 0;
        }

        return nums;
    }
}
