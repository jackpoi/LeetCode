package 贪心;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies/
 *
 * @author beastars
 */
public class _455_分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s); // 孩子和饼干都从小到大排列，贪心
        int child = 0; // 指向孩子
        int cookie = 0; // 指向饼干

        while (child < g.length && cookie < s.length) {
            // 如果当前饼干能满足孩子，就是当前最小的可以满足孩子的饼干，孩子和饼干都指向下一个
            // 如果不能满足，寻找更大的饼干，饼干也要指向下一个
            if (g[child] <= s[cookie++]) {
                child++;
            }
        }

        return child;
    }
}
