package 剑指Offer;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 * 前提：所有数字都在 0～n-1 的范围内
 * 因此数组中如果没有重复，一定是每一个索引对应一个数字
 *
 * @author beastars
 */
public class _03_数组中重复的数字 {
    /**
     * 在原数组进行查找
     * 遍历数组，将数字放到对应的索引上
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == i) { // 如果当前数字和索引相同，跳过
                continue;
            } else if (num != nums[num]) { // 如果当前数字和当前数字相同的索引上的数字不相同，就进行交换
                swap(nums, num, i);
            } else { // 如果当前数字和该数字索引上的数字相同，说明重复
                return num;
            }
        }

        return -1;
    }

    /**
     * 新开辟一个数组
     */
    public int findRepeatNumber2(int[] nums) {
        int[] tmp = new int[nums.length];

        for (int num : nums) {
            tmp[num]++;
            if (tmp[num] > 1) {
                return num;
            }
        }
        return -1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
