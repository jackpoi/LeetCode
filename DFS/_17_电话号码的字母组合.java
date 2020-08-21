package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author beastars
 */
public class _17_电话号码的字母组合 {
    private List<String> list;
    private char[] strings; // 存储每一层的字母
    private char[] chars;
    private char[][] lettersArray = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };
    public List<String> letterCombinations(String digits) {
        if (digits == null)
            return null;

        chars = digits.toCharArray();
        list = new ArrayList<>();

        if (chars.length == 0)
            return list;

        strings = new char[chars.length];
        dfs(0); // 从第0层开始
        return list;
    }

    /**
     * "234"
     * index  number     char
     * 0        2       a   b   c
     * 1        3       d   e   f
     * 2        4       g   h   i
     * 3    存储，返回上一层
     * @param index 搜索第index层
     */
    private void dfs(int index) {
        if (index == chars.length) { // 进入最后一层，说明已经整理好了一个字符串
            list.add(new String(strings)); // 存入，并退出，返回上一层
            return;
        }

        char[] letters = lettersArray[this.chars[index] - '2']; // 存储对应按键的字母
        for (char c : letters) { // 键盘的0和1都不包含字母
            strings[index] = c;
            dfs(index + 1);
        }
    }
}
