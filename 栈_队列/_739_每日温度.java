package 栈_队列;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 *
 * @author beastars
 */
public class _739_每日温度 {
    public int[] dailyTemperatures(int[] T) {
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
