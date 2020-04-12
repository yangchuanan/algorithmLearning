package two.point;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-12 18:34
 * @Descripe 链表节点
 * @Version 0.0.1
 */
public class ListNode<E> {
    E item;
    ListNode<E> next;
    ListNode<E> prev;

    ListNode(ListNode<E> prev, E element, ListNode<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}
