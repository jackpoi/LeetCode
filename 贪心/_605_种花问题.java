package 贪心;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/can-place-flowers/
 *
 * @author beastars
 */
public class _605_种花问题 {
    /**
     * 前后添0，每有三个连续的0就能种一朵花
     */
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        if (n == 0)
            return true;
        int[] tmp = new int[flowerbed.length + 2];
        tmp[0] = 0;
        tmp[tmp.length - 1] = 0;
        for (int i = 1; i < flowerbed.length + 1; i++) {
            tmp[i] = flowerbed[i - 1];
        }
        System.out.println(Arrays.toString(tmp));
        for (int i = 1; i < tmp.length - 1; i++) {
            if (tmp[i - 1] == 0 && tmp[i] == 0 && tmp[i + 1] == 0) {
                n--;
                tmp[i] = 1;
            }
        }
        return n <= 0;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;

        // [0]的特殊情况
        if (flowerbed.length == 1)
            return n <= 1 && flowerbed[0] == 0;

        // [0, 0, ...]的特殊情况
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }

        // [...,0, 0]的特殊情况
        if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            flowerbed[flowerbed.length - 1] = 1;
            n--;
        }
        if (n > flowerbed.length >> 1)
            return false;

        int i = 1; // 从第二个开始遍历(0, flowerbed.length - 1) 开区间
        while (n > 0 && i < flowerbed.length - 2) { // [..., 0, cur(1), 0, ?, ...]
            if (flowerbed[i] == 1) { // 如果当前位置有花，后面的一个位置必然不能有花，直接跳两次到第二个位置
                i += 2;
            } else if (flowerbed[i - 1] == 1) { // [..., 1, cur(0), ?, ...]
                // 如果前一个位置有花，当前位置必然不能有花，跳到下一个位置
                i++;
            } else if (flowerbed[i + 1] == 1) { // [..., 1, cur(0), 1, 0, ?, ...]
                // 如果后一个位置有花，当前位置必然不能有花，且后一个位置的后一个位置也必然不能有花，直接跳到后后后个位置
                i += 3;
            } else {
                n--;
                flowerbed[i] = 1; // 在当前位置种花
            }
        }

        return n <= 0;
    }
}
