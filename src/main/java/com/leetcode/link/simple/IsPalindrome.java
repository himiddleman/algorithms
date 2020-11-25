package com.leetcode.link.simple;

/**
 * author: tanguang
 * data: 2020/11/25
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 **/
public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        isPalindrome.isPalindrome(null);
    }

    public boolean isPalindrome(ListNode head) {
        ListNode compare = head;
        //首先反转链表
        ListNode newNode = null;
        //思路：头插法反转链表
        while (head != null) {
            ListNode p = new ListNode(head.val);
            if (newNode == null) {
                newNode = p;
            } else {
                p.next = newNode;
                newNode = p;
            }
            head = head.next;
        }
        //比较每一个值
        while (compare != null) {
            if (compare.val != newNode.val) {
                return false;
            }
            compare = compare.next;
            newNode = newNode.next;
        }

        return true;
    }
}
