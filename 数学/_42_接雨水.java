package 数学;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * @author beastars
 */
public class _42_接雨水 {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int water = 0;
        int lowerMax = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int lower;
            if (height[left] <= height[right]) {
                lower = height[left++];
            } else {
                lower = height[right--];
            }
            lowerMax = Math.max(lowerMax, lower);
            water += lowerMax - lower;
        }

        return water;
    }
}
