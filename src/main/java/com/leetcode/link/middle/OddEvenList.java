package com.leetcode.link.middle;

import com.leetcode.link.ListNode;

/**
 * author: tanguang
 * data: 2020/12/2
 * <p>
 * #328
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 **/
public class OddEvenList {
    //1->3->5
    public static void main(String[] args) {
        OddEvenList oddEvenList = new OddEvenList();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        oddEvenList.oddEvenList(listNode);
    }

    public ListNode oddEvenList(ListNode head) {
        //思路：取出链表中的编号为奇数的结点，取出链表中编号为偶数的结点，拼接
        if (head == null || head.next == null) {
            return head;
        }

        //输入: 1->2->3->4->5->NULL
        ListNode odd = head;
        ListNode dummy = new ListNode(-1);
        ListNode even = dummy;
        while (odd != null && odd.next != null) {
            //偶数结点
            even.next = odd.next;
            even = odd.next;
            //基数结点
            odd.next = odd.next.next;
            odd = odd.next == null ? odd : odd.next;
        }
        //避免环出现
        even.next = null;

        //链表拼接
        odd.next = dummy.next;

        return head;
    }
}
