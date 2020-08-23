package 数学;

/**
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 *
 * @author beastars
 */
public class _剑指Offer_62_圆圈中最后剩下的数字 {
    /**
     * 递归
     * 公式： f(n, m) = (f(n-1, m) + m) % n
     */
    public int lastRemaining(int n, int m) {
        if (n == 1)
            return 0;
        return (lastRemaining(n - 1, m) + m) % n;
    }

    /**
     * 非递归
     */
    public int lastRemaining2(int n, int m) {
        // f(1, 3) = 0
        // f(2, 3) = (f(1, 3) + 3) % 2
        // ...
        // f(7, 3) = (f(6, 3) + 3) % 7
        // f(8, 3) = (f(7, 3) + 3) % 8
        // f(9, 3) = (f(8, 3) + 3) % 9
        // f(10, 3) = (f(9, 3) + 3) % 10
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + m) % i;
        }
        return result;
    }
}
