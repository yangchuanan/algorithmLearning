package greed.thinking;

import org.junit.Test;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-19 14:32
 * @Descripe 给定一个整形数组，其中的第i个元素代表股票第i天的价格。
 * 在一开始，你手里有足够的钱，但没有股票。
 * 可以进行多次交易，多次交易之间不能交叉进行，或者不买不卖。
 * 输出你可能的最大盈利值。
 * @Version 0.0.1
 */
public class BestTimetoBuyandSellStock2 {
    @Test
    public void test() {
        int[] a = new int[]{7, 1, 5, 3, 6, 4};
        int[] b = new int[]{7, 6, 5, 4, 3, 2};
        System.out.println(getMax(a));
        System.out.println(getMax(b));
    }

    /**
     * 对于 [a, b, c, d]，如果有 a <= b <= c <= d ，
     * 那么最大收益为 d - a。而 d - a = (d - c) + (c - b) + (b - a) ，
     * 因此当访问到一个 prices[i] 且 prices[i] - prices[i-1] > 0，
     * 那么就把 prices[i] - prices[i-1] 添加到收益中。
     */
    private int getMax(int[] price) {
        if (null == price || price.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i < price.length; i++) {
            if (price[i] - price[i - 1] > 0) {
                max = max + price[i] - price[i - 1];
            }
        }
        return max;
    }
}
