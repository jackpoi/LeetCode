package 数学;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author beastars
 */
public class _7_整数反转 {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int preRes = res;
            res = (preRes * 10) + (x % 10);
            if ((res - x % 10) / 10 != preRes) // 如果和原来的res不相等，说明越界溢出
                return 0;
            x = x / 10;
        }
        return res;
    }

    public int reverse2(int x) {
//        int res = 0;
        long res = 0; // 使用 long 接收，用来判断是否溢出
        while (x != 0) {
            res = (res * 10) + (x % 10);
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
                return 0; // 如果溢出，返回0

            x = x / 10;
        }
        return (int) res;
    }
}
