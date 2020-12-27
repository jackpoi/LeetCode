package 数学;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 *
 * @author beastars
 */
public class _9_回文数 {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;
        if (x % 10 == 0)
            return false;

        /*
        将数字的后一半提取出来，和前一半进行比较，判断是否是回文数字
        如果是偶数，前一半和后一半判断是否相等
        如果是奇数，后一半比前一半多一位，先/10在比较
         */
        int reversed = 0; // 后一半的数字
        while (x > reversed) {
            reversed = (reversed * 10) + x % 10;
            x /= 10;
        }

        return x == reversed || x == (reversed / 10);
    }
}
