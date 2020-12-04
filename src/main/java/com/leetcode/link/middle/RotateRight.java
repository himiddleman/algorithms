package com.leetcode.link.middle;

import com.leetcode.link.ListNode;

/**
 * author: tanguang
 * data: 2020/12/3
 * <p>
 * #61
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 **/
public class RotateRight {
    public static void main(String[] args) {
        RotateRight rotateRight = new RotateRight();
        ListNode listNode = new ListNode(1);
        rotateRight.rotateRight(listNode, 0);
    }

    public ListNode rotateRight(ListNode head, int k) {
        //思路：每次往右移动一个单位，执行k此，时间复杂度为O(nk)

        //每次往右移动一个单位，就是将最后一位放在最前
        // 1->2->3->4->5->NULL
        if (head == null || head.next == null) {
            return head;
        }

        //过滤次数
        int count = 0;
        ListNode countNode = head;
        while (countNode != null) {
            countNode = countNode.next;
            count++;
        }
        k = k % count;

        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            while (temp.next != null) {
                //避免空指针
                ListNode p = temp.next;
                if (temp.next.next == null) {
                    //避免出现环
                    temp.next = null;
                }
                temp = p;
            }
            temp.next = head;
            head = temp;
        }

        return head;
    }
}
