package com.leetcode.link.middle;

import com.leetcode.link.ListNode;

/**
 * author: tanguang
 * data: 2020/12/1
 * #92
 * <p>
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 **/
public class ReverseBetween {
    public static void main(String[] args) {
        ReverseBetween reverseBetween = new ReverseBetween();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        reverseBetween.reverseBetween(listNode, 2, 4);
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        //思路：将原链表分割成3部分，中间部分反转，再将三部分拼接起来。
        if (head == null || m == n) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        int index = 0;
        ListNode pre = dummyHead;
        ListNode middle = null;
        ListNode tail = null;
        while (temp != null && index <= n) {
            ListNode p = temp.next;
            if (index < m) {
                pre = temp;
            }
            if (index == m) {
                tail = temp;
            }
            if (index >= m) {
                //中间部分的反转最复杂
                //首先将第一个结点的下一个结点置为null,然后使用头插法
                //不能使用p.next=middle;middle=temp，这样会使链表断开了
                temp.next = middle;
                middle = temp;
            }

            index++;
            temp = p;
        }

        pre.next = middle;
        tail.next = temp;

        return dummyHead.next;
    }
}
