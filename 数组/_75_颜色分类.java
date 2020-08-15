package 数组;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 *
 * @author beastars
 */
public class _75_颜色分类 {
    /*
     * 一个直观的解决方案是使用计数排序的两趟扫描算法。
     * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
     * 你能想出一个仅使用常数空间的一趟扫描算法吗？
     *
     * 空间复杂度 O(1) 时间复杂度 O(n)
     *
     * 三指针 一个指向0 一个指向2 一个扫描数据
     */
    public void sortColors(int[] nums) {
        int left = 0; // 指向 0 的指针
        int right = nums.length - 1; // 指向 2 的指针
        int curr = 0; // 扫描数据的指针

        while (curr <= right) {
            if (nums[curr] == 0) {
                // 如果扫描到 0，和 left 指向的数据交换，
                // 扫描指针++ (因为之前的数据已经扫描过了，交换的也是扫描过的，所以扫描指针直接指向下一个即可)，
                // 0 指针++
                swap(nums, curr++, left++);
            } else if (nums[curr] == 2) {
                // 如果扫描到 2，和 right 指向的数据交换，
                // 扫描指针不变 (因为之后的数据还没有扫描，交换的也是没有扫描的，所以扫描指针依旧指向这个数据)，
                // 2 指针--
                swap(nums, curr, right--);
            } else { // 如果扫描到 1，直接跳过
                curr++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void sortColors2(int[] nums) {
        int len = nums.length;
        int[] newNums = new int[len];
        int left = 0;
        int right = len - 1;

        for (int n : nums) {
            if (n == 0) {
                newNums[left++] = n;
                continue;
            }
            if (n == 2) {
                newNums[right--] = n;
            }
        }

        while (left <= right) {
            newNums[left++] = 1;
        }

        for (int i = 0; i < len; i++) {
            nums[i] = newNums[i];
        }
    }
}
