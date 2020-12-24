package 剑指Offer;

/**
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 *
 * @author beastars
 */
public class _10_II_青蛙跳台阶问题 {
    public int numWays(int n) {
        if (n == 0)
            return 1;

        /*
        第一次跳一格,还剩f(n - 1)种方法
        第一次跳两格,还剩f(n - 2)种方法
        也就是n层共有f(n - 1) + f(n - 2)种方法
        即f(n) = f(n - 1) + f(n - 2)
        实际上就是斐波那契数列
         */

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }

        return dp[n];
    }
}
