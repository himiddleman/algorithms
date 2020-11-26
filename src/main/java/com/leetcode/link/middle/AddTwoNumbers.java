package com.leetcode.link.middle;

import com.leetcode.link.ListNode;

/**
 * author: tanguang
 * data: 2020/11/26
 * #2
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 **/
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6));
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //两个链表的长度可能不相等
        ListNode head = null;
        ListNode tail = null;
        //i为进位标识
        int i = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + i;
            if (sum >= 10) {
                i = 1;
                sum = sum % 10;
            } else {
                i = 0;
            }
            //尾插法
            ListNode listNode = new ListNode(sum);
            if (head == null) {
                head = tail = listNode;
            } else {
                tail.next = listNode;
                tail = listNode;
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        //对最后一次进位的处理
        if (i == 1) {
            ListNode listNode = new ListNode(1);
            tail.next = listNode;
        }
        return head;
    }
}

