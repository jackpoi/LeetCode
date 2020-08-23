package 数学;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/meeting-rooms-ii/
 *
 * @author beastars
 */
public class _253_会议室II {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        // 先按开始时间进行排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        // 创建一个最小堆，存放每一个会议的结束时间
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 添加0号会议的结束时间
        heap.add(intervals[0][1]);

        // 堆顶的含义：目前占用的会议室中最早结束的时间
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= heap.peek()) {
                // 如果当前会议的开始时间比最早结束的会议要晚，说明可以使用当前堆顶的会议房间
                heap.poll(); // 将堆顶删除，将当前会议添加进去
            }
            // 如果开始时间比最早结束的会议还要早，说明要新开一个房间
            // 如果进行了上面的if，说明要用当前会议添加进去
            heap.add(intervals[i][1]);
        }

        return heap.size();
    }

    public int minMeetingRooms2(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        int[] begins = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            begins[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(begins);
        Arrays.sort(ends);

        int room = 0;
        int endIdx = 0;
        for (int begin : begins) {
            if (begin >= ends[endIdx]) {
                endIdx++;
            } else {
                room++;
            }
        }

        return room;
    }
}
