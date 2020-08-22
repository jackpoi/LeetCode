package 数组;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * @author beastars
 */
public class _283_移动零 {
    public void moveZeroes(int[] nums) {
        // 将非0的元素挪到前面
        int curr = 0; // 指向非0的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) // 如果是0就跳过
                continue;
            // 如果不是0，交换到前面
            int tmp = nums[i];
            nums[i] = nums[curr];
            nums[curr++] = tmp;
        }
    }
}
