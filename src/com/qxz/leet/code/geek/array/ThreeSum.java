package com.qxz.leet.code.geek.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://leetcode-cn.com/problems/3sum/
public class ThreeSum {

    public static void main(String[] args) {
//        int[] data = new int[]{-2, 0, 0, 2, 2};
        int[] data = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum3(data);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println("");
        }

    }

    // 三重循环暴力解决法
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        ArrayList<Integer> integers = new ArrayList<>();
                        integers.add(nums[k]);
                        integers.add(nums[j]);
                        integers.add(nums[i]);
                        result.add(integers);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 双指针法
     * + HashMap
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // 第一层循环
        int length = nums.length;
        HashMap<String, List<Integer>> filter = new HashMap<>();

        // 去除另外两个指针的下标
        for (int i = 0; i < length - 2; i++) {

            //目标等于当前正数
            int target = -nums[i];
            //左右向中间
            for (int left = i + 1, right = length - 1; left < right; ) {
                if (nums[left] + nums[right] == target) {
                    StringBuilder key = new StringBuilder();
                    key.append(nums[i])
                            .append(nums[left])
                            .append(nums[right]);
                    if (!filter.containsKey(key.toString())) {
                        ArrayList<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[left]);
                        integers.add(nums[right]);
                        result.add(integers);
                        filter.put(key.toString(), integers);
                    }
                    left++;
                } else if (nums[left] + nums[right] < target) {
                    // 那边小，往那边移动
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            for (int left = i + 1, right = length - 1; left < right; ) {
                int sum = nums[right] + nums[left];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
