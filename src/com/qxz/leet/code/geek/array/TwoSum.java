package com.qxz.leet.code.geek.array;

public class TwoSum {


    public static int[] twoSum(int[] nums, int target) {

        if (nums.length < 2) {
            return null;
        }
        int[] result = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }
}
