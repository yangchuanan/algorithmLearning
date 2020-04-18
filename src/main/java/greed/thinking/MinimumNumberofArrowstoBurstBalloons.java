package greed.thinking;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-18 21:54
 * @Descripe 求解最小的投飞镖次数使所有气球都被刺破。
 * 有若干个气球，给出了它们的直径两个端点的坐标（x轴），
 * 飞镖垂直投向坐标轴，使得路径上的气球都被刺破。
 * 例如两个气球的直径分别是（1,6）和（2,8），
 * 那么我们就可以在x=6的坐标处发射一支箭从而将它们一起戳破。
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 * <p>
 * Output:
 * 2
 * @Version 0.0.1
 */
public class MinimumNumberofArrowstoBurstBalloons {
    @Test
    public void test() {
        int[][] a=new int[][]{{10,16},{2,8},{1,6},{7,12}};
        System.out.println(minArrows(a));
    }

    /**
     * 也是计算不重叠的区间个数，
     * 不过和 Non-overlapping Intervals 的区别在于，
     * [1, 2] 和 [2, 3] 在本题中算是重叠区间。
     */
    private int minArrows(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));
        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            // 不取等号
            if (points[i][0] > end) {
                ++count;
                end = points[i][1];
            }
        }
        return points.length - count;
    }

}
