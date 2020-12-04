package com.leetcode.link.middle;

import com.leetcode.link.ListNode;

/**
 * author: tanguang
 * data: 2020/12/4
 * #1171
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * <p>
 * 删除完毕后，请你返回最终结果链表的头节点。
 * <p>
 *  
 * <p>
 * 你可以返回任何满足题目要求的答案。
 * <p>
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 * 示例 2：
 * <p>
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 * 示例 3：
 * <p>
 * 输入：head = [1,2,3,-3,-2]
 * 输出：[1]
 **/
public class RemoveZeroSumSublists {

    public ListNode removeZeroSumSublists(ListNode head) {
        //思路：递归删除，设置哑结点

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = head;
        while (p != null) {
            ListNode inner = p.next;
            int sum = p.val;
            //0001-12
            //0
            pre.next = p;
            if (sum == 0) {
                p = p.next;
                pre.next = p;
                continue;
            }

            while (inner != null) {
                sum += inner.val;
                if (sum == 0) {
                    pre.next = inner.next;
                    break;
                }
                inner = inner.next;
            }

            if (sum == 0) {
                p = pre.next;
            } else {
                pre = pre.next;
                p = p.next;
            }
        }
        return dummy.next;
    }
}
