package 栈_队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * @author beastars
 */
public class _239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1)
            return new int[0];
        if (k == 1)
            return nums;

        int[] maxes = new int[nums.length - k + 1];
        int maxIdx = 0; // 存放窗口中最大值的索引

        for (int i = 1; i < k; i++) { // 初始化第一个窗口的最大值索引
            if (nums[i] >= nums[maxIdx]) {
                maxIdx = i;
            }
        }
        maxes[0] = nums[maxIdx];

        for (int li = 1; li < maxes.length; li++) {
            int ri = li + k - 1; // 滑动窗口的右索引
            if (maxIdx < li) { // 判断最大值索引是否合法
                // 如果不合法，重新计算
                maxIdx = li;
                for (int i = li + 1; i <= ri; i++) { // 初始化第一个窗口的最大值索引
                    if (nums[i] >= nums[maxIdx]) {
                        maxIdx = i;
                    }
                }
            } else if (nums[ri] >= nums[maxIdx]) {
                // 如果合法，且窗口新添加的元素比最大的要大，更新
                maxIdx = ri;
            }

            maxes[li] = nums[maxIdx];
        }

        return maxes;
    }

    public int[] maxSlidingWindow_deque(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1)
            return new int[0];
        if (k == 1)
            return nums;

        int[] maxes = new int[nums.length - k + 1]; // 滑动窗口滑动的最大次数

        Deque<Integer> deque = new LinkedList<>(); // 创建一个双端队列来存放滑动窗口的数据的索引
        for (int i = 0; i < nums.length; i++) {
            // 如果队列不为空，并且遍历到的数组元素大于等于队列中尾部索引对应的元素，就将尾部索引弹出
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // 将索引i加到队尾
            deque.offerLast(i);

            // 检查滑动窗口的索引是否合法
            int left = i - k + 1;
            if (left < 0) // 说明滑动窗口只滑进了一部分
                continue;

            // 检查队头索引对应的元素是否在窗口中
            if (deque.peekFirst() < left) {
                // 队头不合法，不在窗口范围内，将队头消去
                deque.pollFirst();
            }

            // 设置窗口的最大值
            maxes[left] = nums[deque.peekFirst()];
        }

        return maxes;
    }
}
