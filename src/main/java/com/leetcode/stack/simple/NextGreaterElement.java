package com.leetcode.stack.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * author: tanguang
 * data: 2020/12/29
 * #496
 * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。
 * 如果不存在，对应位置输出 -1 。
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 **/
public class NextGreaterElement {
    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        int[] num1 = {4, 1, 2};
        int[] num2 = {1, 3, 4, 2};
        Arrays.stream(nextGreaterElement.nextGreaterElement(num1, num2)).forEach(System.out::println);
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //找出num2中每个元素的下一个更大的元素并存入到map中。需要用到单调栈
        Stack<Integer> stack = new Stack();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (stack.empty()) {
                stack.push(nums2[i]);
            } else {
                while (!stack.empty() && stack.peek().compareTo(nums2[i]) <= 0) {
                    map.put(stack.pop(), nums2[i]);
                }
                stack.push(nums2[i]);
            }
        }

        //剩余的栈中的元素表示未找到更大的值，用-1表示
        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }

        //遍历num1可得到答案。
        int[] target = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            target[i] = map.get(nums1[i]);
        }

        return target;
    }
}
