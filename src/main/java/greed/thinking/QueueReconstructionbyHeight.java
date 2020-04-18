package greed.thinking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-18 22:16
 * @Descripe 一个学生用两个分量 (h, k) 描述，
 * h 表示身高，k 表示排在前面的有 k 个学生的身高比他高或者和他一样高。
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * @Version 0.0.1
 */
public class QueueReconstructionbyHeight {
    @Test
    public void test() {
        int[][] a = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        printArray(reconstructionHeight(a), 6, 2);
    }

    /**
     * 为了使插入操作不影响后续的操作，身高较高的学生应该先做插入操作，
     * 否则身高较小的学生原先正确插入的第 k 个位置可能会变成第 k+1 个位置。
     * <p>
     * 身高 h 降序、个数 k 值升序，然后将某个学生插入队列的第 k 个位置中。
     */
    private int[][] reconstructionHeight(int[][] heights) {
        if (null == heights || heights.length == 0 || heights[0].length == 1) {
            return new int[0][0];
        }

        // 按照身高排序，如果身高相同，按照个数K生序
        Arrays.sort(heights, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);

        List<int[]> queqe = new ArrayList<>();
        for (int[] height : heights) {
            /** K插入的下标为K的位置，
             * 相同位置若已有元素，则将它和后面的元素整体向后移动
             */
            queqe.add(height[1], height);
        }

        return queqe.toArray(new int[queqe.size()][]);
    }


    private void printArray(int[][] a, int m, int n) {
        for (int i = 0; i < m; i++) {
            System.out.print("[");
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + ",");
            }
            System.out.print("],");
        }
    }
}
