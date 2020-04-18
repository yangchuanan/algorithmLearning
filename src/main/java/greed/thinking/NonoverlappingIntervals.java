package greed.thinking;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-18 21:14
 * @Descripe 计算让一组区间不重叠所需要移除的区间个数
 * Input: [ [1,2], [1,2], [1,2] ]
 * <p>
 * Output: 2
 * <p>
 * Input: [ [1,2], [2,3] ]
 * <p>
 * Output: 0
 * <p>
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * @Version 0.0.1
 */
public class NonoverlappingIntervals {

    @Test
    public void test() {
        int[][] a = new int[][]{{1, 2}, {1, 2}, {1, 2}};
        int[][] b = new int[][]{{1, 2}, {2, 3}};
        System.out.println(eraseOverlapIntervals(a));
        System.out.println(eraseOverlapIntervals(b));
    }

    /**
     * 先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
     * <p>
     * 在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
     * <p>
     * 按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
     */
    private int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // 将区间按照区间结尾排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        // 第一个区间计数为1
        int count = 1;
        // 第一个区间的结尾
        int end = intervals[0][1];
        // 从第二个区间开始遍历
        for (int i = 1; i < intervals.length; i++) {
            // 找到不重叠的区间
            if (intervals[i][0] >= end) {
                // 更新计数、区间的结尾
                ++count;
                end = intervals[i][1];
            }
        }
        return intervals.length - count;
    }

    private int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // 将区间按照区间结尾排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // 第一个区间计数为1
        int count = 1;
        // 第一个区间的结尾
        int end = intervals[0][1];
        // 从第二个区间开始遍历
        for (int i = 1; i < intervals.length; i++) {
            // 找到不重叠的区间
            if (intervals[i][0] >= end) {
                // 更新计数、区间的结尾
                ++count;
                end = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}
