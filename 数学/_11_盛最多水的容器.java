package 数学;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author beastars
 */
public class _11_盛最多水的容器 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int left = 0;
        int right = height.length - 1;
        int water = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                water = Math.max(water, (right - left) * height[left]);
                left++;
            } else {
                water = Math.max(water, (right - left) * height[right]);
                right--;
            }
        }

        return water;
    }
}
