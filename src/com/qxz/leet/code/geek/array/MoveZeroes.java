package com.qxz.leet.code.geek.array;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 0, 3, 12};
        moveZeroes2(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    //https://leetcode-cn.com/problems/move-zeroes/

    /**
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 不是0的那个记录下来
                int temp = nums[i];
                // 把不是0的那个位置换成0
                nums[i] = nums[j];
                // 把0的那个换成temp
                nums[j++] = temp;
            }
        }
    }

    /**
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        // 将数组中的0移动到数组的末尾，并且保持数组其它元素的顺序不变
        // 核心思想：升纬，空间换时间
        // 思路：相互置换法
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k++] = temp;
            }
        }
    }

    public static void moveZeroes3(int[] nums) {
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[r];
                nums[r++] = temp;
            }
        }
    }
}
