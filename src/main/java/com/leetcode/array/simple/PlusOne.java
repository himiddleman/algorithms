package com.leetcode.array.simple;

import java.util.Arrays;

/**
 * author: tanguang
 * data: 2020/11/11
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 **/
public class PlusOne {
    public static void main(String[] args) {
        //了解Stream的中间操作和终端操作的流程 源码
//        int value = Stream.iterate(1, i -> i + 1)
//                .limit(10)
//                .filter(i -> i > 5)
//                .map(i -> i + 1)
//                .reduce(0, Integer::sum);
//        System.out.println(value);
//
//        System.out.println(Runtime.getRuntime().availableProcessors());


        PlusOne plusOne = new PlusOne();
        int[] array = {9};
        Arrays.stream(plusOne.plusOne(array)).forEach(System.out::println);
    }

    public int[] plusOne(int[] digits) {
        //思路：数组最后一位加一，和超过10时往前进一位

        //末位数+1 不进位
        if (digits[digits.length - 1] + 1 < 10) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }

        //进位
        boolean first = false;
        for (int i = 0; i < digits.length; i++) {
            int last = digits[digits.length - 1 - i] + 1;
            if (last >= 10) {
                //往前进一位
                if (i == digits.length - 1) {
                    first = true;
                }
                digits[digits.length - 1 - i] = 0;
            } else {
                digits[digits.length - 1 - i] = last;
                break;
            }

            //第一位发生了进位，数组扩容
            if (first) {
                int[] array = new int[digits.length + 1];
                array[0] = 1;
                System.arraycopy(digits, 0, array, 1, digits.length);
                return array;
            }
        }
        return digits;
    }

//    public int[] plusOne(int[] digits) {
//        //思路：将原数组的值取出+1后放入到新的数组中
//        int source = 0;
//        for (int i = 0; i < digits.length; i++) {
//            source += digits[i] * Math.pow(10, digits.length - 1 - i);
//        }
//        int target = source + 1;
//        String[] stringArray = String.valueOf(target).split("");
//        int[] array = new int[stringArray.length];
//        for (int i = 0; i < stringArray.length; i++) {
//            //存在int 溢出问题
//            array[i] = Integer.valueOf(stringArray[i]);
//        }
//        return array;
//    }


}
