package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author beastars
 */
public class _22_括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n < 0)
            return list;

        dfs(0, n, n, new char[n << 1], list);

        return list;
    }

    /**
     * @param index       搜索的层号
     * @param leftRemain  左括号“（”的剩余数量
     * @param rightRemain 右括号“）”的剩余数量
     * @param chars       有效的括号组合
     * @param list        放入集合
     */
    private void dfs(int index, int leftRemain, int rightRemain,
                     char[] chars, List<String> list) {
        if (index == chars.length) {
            list.add(new String(chars));
            return;
        }

        // 枚举这一层所有可能的选择
        // 选择一种可能之后，进入下一层搜索

        // 什么情况可以选择左括号？左括号的数量 > 0
        // 选择左括号，然后进入下一层搜索
        if (leftRemain > 0) {
            chars[index] = '(';
            dfs(index + 1, leftRemain - 1, rightRemain, chars, list);
        }

        // 当左括号、右括号的数量一样时，只能选择左括号
        // 什么情况可以选择右括号？(右括号的数量 > 0) && (右括号的数量 != 左括号的数量)
        // 选择右括号，然后进入下一层搜索
        if (rightRemain > 0 && rightRemain != leftRemain) {
            chars[index] = ')';
            dfs(index + 1, leftRemain, rightRemain - 1, chars, list);
        }
    }
}
