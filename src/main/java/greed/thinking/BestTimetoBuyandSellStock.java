package greed.thinking;

import org.junit.Test;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-19 10:32
 * @Descripe 给定一个整形数组，其中的第i个元素代表股票第i天的价格。
 * 在一开始，你手里有足够的钱，但没有股票。
 * 你仅有一次买股票和一次卖股票的机会（每次只能买/卖1股），或者不买不卖。
 * 输出你可能的最大盈利值。尽量降低程序的时间复杂度。
 * [7, 1, 5, 3, 6, 4]，在价格为1的时候买入，在价格为6的时候卖出，可以得到最大盈利值为5。（5 = 6 - 1）
 * [7, 6, 5, 4, 3, 2]，选择不买不卖，最大盈利值为0。
 * @Version 0.0.1
 */
public class BestTimetoBuyandSellStock {
    @Test
    public void test() {
        int[] a = new int[]{7, 1, 5, 3, 6, 4};
        int[] b = new int[]{7, 6, 5, 4, 3, 2};
        System.out.println(getMax(a));
        System.out.println(getMax(b));
    }

    /**
     * 维护两个变量，一个是到目前为止最好的交易，
     * 另一个是在当天卖出的最佳交易（也就是局部最优）。
     * 其实，就是求一个数组中连续子数组差最大。
     */
    private int getMax(int[] price) {
        if (null == price || price.length == 0) {
            return 0;
        }
        int len = price.length;
        // 到目前为止组好的交易
        int max = 0;
        // 买入的最小值
        int smallSofar = price[0];
        for (int i = 1; i < len; i++) {
            if (smallSofar < price[i]) {
                max = Math.max(max, price[i] - smallSofar);
            } else {
                smallSofar = price[i];
            }
        }
        return max;
    }
}
