package 栈_队列;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 *
 * @author beastars
 */
public class _739_每日温度 {

    /*
     * 倒推法
     *
     * i 用来扫描所有的元素，从右往左扫描（i 逐渐递减），一开始 i 指向倒数第 2 个元素，j 指向最后一个
     * 对于每一个 i，一开始令 j = i + 1
     */
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0)
            return null;

        int[] result = new int[T.length]; // 存放结果，即对应索引元素右侧最近的大于自身的元素的索引

        for (int i = T.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (true) {
                if (T[i] < T[j]) {
                    // 如果 i 对应的值小于 j 对应的值，说明 j 就是离 i 最近的大值，距离就是 j 和 i 的距离
                    result[i] = j - i;
                    break; // i--
                } else if (result[j] == 0) {
                    // 如果 T[i] >= T[j]，且 result[j] 为 0，说明 T[j] 后面都是比它小的，即 T[i] 后面也都是比它小的
                    result[i] = 0;
                    break;
                }
//                else if (T[i] == T[j]) {
//                    // 如果 T[i] == T[j]，说明后面有比他们两个大的数，result[i] 其实就是 result[j] 加上他们之间的距离
//                    result[i] = result[j] + j - i;
//                    break;
//                }

                // 如果 T[i] > T[j]，且 result[j] != 0，说明后面有比 result[j] 大的数，但是不确定有没有 result[i] 大，
                // 因此，让 j 向后遍历，判断有没有比 T[i] 大的数；
                // 如果 T[i] == T[j]，且 result[j] != 0，说明后面有比 result[j] 大的数，而且该数也比 T[i] 大，
                // 因此，让 j 直接加上他们之间的距离，j 就变成了比 T[j] 最近大数的索引，再次进入循环，即进入到了 T[i] < T[j]中
                j = j + result[j];
            }
        }

        return result;
    }

    public int[] dailyTemperatures2(int[] T) {
        if (T == null || T.length == 0)
            return null;

        // 用来存放索引，每当遍历到的索引对应的值比栈顶大时，弹出栈顶，
        // 代表遍历到的该值是右侧大于栈顶元素的最近的值的索引
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length]; // 存放结果，即对应索引元素右侧最近的大于自身的元素的索引

        // 遍历数组
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                // 如果栈不为空，且遍历到的元素比栈顶元素大，说明该元素就是栈顶元素最近的大值的索引
                Integer pop = stack.pop(); // 弹出栈顶元素，该元素是索引
                result[pop] = i - pop; // 距离就是最近的大值的索引 - 弹出元素的索引
            }

            // 如果栈为空，或者遍历到的元素比栈顶元素小，就将其压入栈中
            stack.push(i);
        }

        return result;
    }
}
