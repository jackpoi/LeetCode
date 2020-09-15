package 图;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/course-schedule-ii/
 *
 * @author beastars
 */
public class _210_课程表II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] input = new int[numCourses]; // 入度
        int[] result = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int[] edge : prerequisites) {
            input[edge[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (input[i] == 0)
                queue.offer(i);
        }

        int index = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            result[index++] = poll;
            for (int[] edge : prerequisites) {
                if (edge[1] == poll) { // 度数减一
                    input[edge[0]]--;
                    if (input[edge[0]] == 0)
                        queue.offer(edge[0]);
                }
            }
        }

        return index == numCourses ? result : new int[0];
    }
}
