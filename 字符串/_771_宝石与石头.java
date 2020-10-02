package 字符串;

/**
 * https://leetcode-cn.com/problems/jewels-and-stones/
 *
 * @author beastars
 */
public class _771_宝石与石头 {
    public int numJewelsInStones(String J, String S) {
        boolean[] chars = new boolean[58];
        for (char c : J.toCharArray()) {
            chars[c - 65] = true;
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            if (chars[c - 65]) {
                count++;
            }
        }
        return count;
    }
}
