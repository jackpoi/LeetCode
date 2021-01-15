package 剑指Offer;

/**
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 *
 * @author beastars
 */
public class _11_旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        // 旋转之后，顺序为 →递增→…→ 最小值 →递增→…→，如 678 0 12345
        // 按顺序分为 第一段，第二段，第三段，第二段就是最小值。第一段整体大于第一段和第三段
        // 二分法，找到中间点，进行判断，一直到只有一位的时候，就是结果
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            if (numbers[start] < numbers[end]) // 如果首位比尾位小，说明已经顺序，直接跳出
                break;

            int mid = (start + end) >> 1; // 获取中间点坐标
            if (numbers[mid] > numbers[end]) {
                // 中间的大于最后一位，说明该中点属于第一段，需要在后面进行查找
                start = mid + 1;
            } else if (numbers[mid] < numbers[end]) {
                // 中间的小于最后一位，说明该中点属于第三段，需要在前面进行查找
                end = mid;
            } else {
                // 进行到这里，说明中间点和最后一位相等，不知道属于哪一段，需要逐个缩小范围，进行排除
                end--;
            }
        }

        return numbers[start];
    }
}
