package greed.thinking;

import org.junit.Test;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-17 22:01
 * @Descripe flowerbed 数组中 1 表示已经种下了花朵。
 * 花朵之间至少需要一个单位的间隔，求解是否能种下 n 朵花。
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * @Version 0.0.1
 */
public class CanPlaceFlowers {
    @Test
    public void test() {
        int[] a = new int[]{1, 0, 0, 0, 1};
        System.out.println(canPlanceFlowers(a, 1));
        System.out.println(canPlanceFlowers(a, 2));
    }

    /**
     * 遍历数组中的每一个结点，并进行判断该节点是否可以种植，
     * 满足种植条件后，该节点值置1。
     * 必须满足两个条件才可以种植：
     * 1.该节点值必须为0；
     * 2.该节点前后的位置必须为0。
     */
    private boolean canPlanceFlowers(int[] place, int n) {
        if (place == null || place.length == 0) {
            return false;
        }
        int canPlace = 0;
        for (int i = 0; i < place.length; i++) {
            if (place[i] == 1) {
                continue;
            }
            // 处理边界条件
            if (i == 0) {
                place[i - 1] = 0;
            }
            if (i == place.length - 1) {
                place[i + 1] = 0;
            }
            // 判断是否可以放置
            if (place[i] == 0 && place[i - 1] == 0 && place[i + 1] == 0) {
                canPlace++;
            }
        }
        return canPlace >= n;
    }
}
