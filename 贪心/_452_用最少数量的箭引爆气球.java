package 贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 *
 * @author beastars
 */
public class _452_用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length < 1)
            return 0;
        // 让气球按右坐标从小到大排列
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int count = 1; // 最少需要一个
        int end = points[0][1]; // 指向右坐标最小的一个气球的右坐标

        for (int i = 1; i < points.length; i++) {
            // 如果有气球的左坐标比当前气球的右坐标还要大，说明没有重合，需要一个额外的箭才能刺穿
            // 如果气球的左坐标比当前气球的右坐标要小，说明重合了，一箭就可以刺穿
            if (points[i][0] > end) {
                count++;
                end = points[i][1]; // 将新的气球的右坐标赋给end，再往后的气球就需要跟这个气球进行比较
            }
        }

        return count;
    }
}
