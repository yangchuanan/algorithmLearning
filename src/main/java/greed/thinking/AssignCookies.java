package greed.thinking;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-17 22:01
 * @Descripe 每个孩子都有一个满足度 grid，每个饼干都有一个大小 size，
 * 只有饼干的大小大于等于一个孩子的满足度，该孩子才会获得满足。
 * 求解最多可以获得满足的孩子数量。
 * Input: grid[1,3], size[1,2,4]
 * Output: 2
 * @Version 0.0.1
 */
public class AssignCookies {

    /**
     * 给一个孩子的饼干应当尽量小并且又能满足该孩子，这样大饼干才能拿来给满足度比较大的孩子。
     * 因为满足度最小的孩子最容易得到满足，所以先满足满足度最小的孩子。
     */
    @Test
    public void test() {
        int[] grid = new int[]{1, 3};
        int[] size = new int[]{1, 2, 4};
        System.out.println(greed(grid, size));
    }


    private int greed(int[] grid, int[] size) {
        if (null == grid || size == null) {
            return 0;
        }
        // 排序
        Arrays.sort(grid);
        Arrays.sort(size);

        int greed = 0;
        // 每次循环size的起始位置
        int begin = 0;
        for (int i = 0; i < grid.length; i++) {
            // size 数组已经遍历完成
            if (begin >= size.length) {
                break;
            }
            // 从begin开始遍历size数组
            for (int j = begin; j < size.length; j++) {
                // 如果满足
                if (grid[i] < size[j]) {
                    greed++;
                    begin++;
                    break;
                }
            }
        }
        return greed;
    }
}
