package 数学;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/meeting-rooms/
 *
 * @author beastars
 */
public class _252_会议室 {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return true;

        // 数组按第一个数的从小到大排列
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        // 遍历每一个会议
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][0])
                return false;
        }
        return true;
    }
}
