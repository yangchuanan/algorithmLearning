package sort.problem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-14 22:38
 * @Descripe 只有 0/1/2 三种颜色。 荷兰国旗问题
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * @Version 0.0.1
 */
@RunWith(JUnit4.class)
public class SortColors {

    @Test
    public void test(){
        int a[] = new int[]{2, 0, 2, 1, 1, 0};
        sorted(a);
        for(int i=0;i<6;i++){
            System.out.print(a[i]);
        }
    }

    /**
     * @Author Chuanan YANG
     * @DateTime 2020/4/14 22:55
     * @Description 三个指针进行移动
     */
    private void sorted(int[] a) {
        int zero = -1, one = 0, two = a.length;
        while (one < two) {
            // 如果是0，两个指针向前移动，不交换
            if (a[one] == 0) {
                swap(a, ++zero, one++);
                // 如果是2交换到最后面
            } else if (a[one] == 2) {
                swap(a, one, --two);
                // 如果是1只移动one指针
            } else {
                ++one;
            }
        }
    }

    /**
     * @Author Chuanan YANG
     * @DateTime 2020/4/14 22:41
     * @Description 交换指定下标的元素
     */
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
