package 数学;

/**
 * https://leetcode-cn.com/problems/powx-n/
 *
 * @author beastars
 */
public class _50_Pow {
    /**
     * 递归
     * 时间复杂度： O(log n)
     * 空间复杂度： O(log n)
     */
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;

        if (n == -1)
            return 1 / x;

        boolean odd = (n & 1) == 1; // 如果与上1为1，说明是奇数
        double half = myPow(x, n >> 1);
        half *= half;
        return odd ? (half * x) : half;
    }

    /**
     * 非递归
     * 快速幂
     * 时间复杂度： O(log n)
     * 空间复杂度： O(1)
     */
    public double myPow2(double x, int n) {
        double result = 1.0;
        // 将n转化成long类型，因为n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1]，如果是负数，int会越界
        long y = (n < 0) ? -((long) n) : n;
        while (y > 0) {
            // 让二进制与上1
            if ((y & 1) == 1) { // 如果与上1为1，说明最后一位为1，是有值的，更新结果
                result = result * x;
            }
            x *= x;
            // 舍弃掉最后一个二进制位
            y = y >> 1;
        }

        return (n < 0) ? (1 / result) : result;
    }
}
