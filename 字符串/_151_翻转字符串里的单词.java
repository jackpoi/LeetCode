package 字符串;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 *
 * @author beastars
 */
public class _151_翻转字符串里的单词 {
    /*
     * "a good   example"
     * 1.取出多余空格 : "a good example"
     * 2.反转整个字符串 : "elpmaxe doog a"
     * 3.反转单个单词 : "example good a"
     */
    public String reverseWords(String s) {
        if (s == null)
            return "";

        char[] chars = s.toCharArray();

        // 1.取出多余空格
        int len = 0; // 字符串的最终有效长度
        int curr = 0; // 指向当前用来存放字符的位置
        boolean space = true; // 标记前一个字符是否是空格，是为true

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') { // 如果不为空格
                chars[curr++] = chars[i]; // 挨个放到数组的签名
                space = false;
            } else if (space == false) { // 如果为空格，且前一个不是空格，说明是单词之间的空格
                chars[curr++] = ' ';
                space = true;
            }
            // 如果为空格，且前一个也是空格，说明是多余的空格，直接跳过，进入下一个循环
        }

        // 如果 space 为 true，说明 curr 指向的最后一位为空格，字符串的实际长度就为 curr - 1
        // 如果 space 为 false，说明 curr 指向的最后一位不是空格，字符串的实际长度就是 curr
        len = space ? (curr - 1) : curr;
        if (len <= 0) // 如果有效位小于 0，直接退出
            return "";

        // 2.反转整个字符串
        reverse(chars, 0, len);

        // 3.反转单个单词
        int spaceIdx = -1; // 标记遇到的空格的位置
        for (int i = 0; i < len; i++) {
            if (chars[i] == ' ') {
                reverse(chars, spaceIdx + 1, i);
                spaceIdx = i;
            }
        }

        // 由于最后没有空格，因此只反转了前面的单词，最后一个没有反转
        // 进行最后一个单词的反转
        reverse(chars, spaceIdx + 1, len);

        return new String(chars, 0, len);
    }

    /**
     * 将 chars[left, right) 范围内的字符逆序
     */
    private void reverse(char[] chars, int left, int right) {
        right--;
        while (left < right) { // 交换指定范围两端的元素，逐个缩小范围
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }
}
