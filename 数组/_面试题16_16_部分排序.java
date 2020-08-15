package 数组;

/**
 * https://leetcode-cn.com/problems/sub-sort-lcci/
 *
 * @author beastars
 */
public class _面试题16_16_部分排序 {
    /*
     * 寻找逆序对，从左往右寻找一个，从右往左寻找一个，这个范围内的就是无序队列
     * https://gitee.com/beastars1/blog-images/raw/master/images/20200815115826.png
     */
    public int[] subSort(int[] array) {
        if (array.length == 0)
            return new int[]{-1, -1};

        // 从左往右寻找逆序对（正序，逐渐变大）
        int max = array[0];
        int right = -1; // 用来记录最右边的逆序对的位置
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= max) { // 如果比最大值大或相等，是正序，更新最大值
                max = array[i];
            } else { // 如果比最大值小，说明有逆序对，记录位置
                right = i;
            }
        }

        if (right == -1) // 如果right == -1，说明是有序的，直接返回
            return new int[]{-1, -1};

        // 从右往左寻找逆序对（逆序，逐渐变小）
        int min = array[array.length - 1];
        int left = -1; // 用来记录最右边的逆序对的位置
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] <= min) { // 如果比最小值小或相等，是正序，更新最小值
                min = array[i];
            } else { // 如果比最小值大，说明有逆序对，记录位置
                left = i;
            }
        }

        return new int[]{left, right};
    }
}
