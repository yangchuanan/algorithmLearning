package two.point;

import org.junit.Test;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-12 18:30
 * @Descripe 判断链表是否存在环
 * 使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇。
 * @Version 0.0.1
 */
public class LinkedListCycle {

    @Test
    public void test() {

    }

    private boolean isCycle(ListNode head) {
        if (null == head) {
            return false;
        }
        ListNode first1 = head;
        ListNode first2 = head.next;
        while (null != first1 && null != first2 && null != head.next) {
            if (first1 == first2) {
                return true;
            }
            // 一次走一步
            first1 = first1.next;
            // 一次走两步
            first2 = first2.next.next;
        }
        return false;
    }
}
