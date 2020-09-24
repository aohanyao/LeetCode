package com.qxz.leet.code.geek.array;

//https://leetcode-cn.com/problems/container-with-most-water/
// 盛水最多的容器
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] data = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea1(data));
        System.out.println(maxArea2(data));
    }

    /**
     * 思路1：双重遍历法
     *
     * @param height
     * @return
     */
    public static int maxArea1(int[] height) {
        int max = 0;
        // 双重遍历法。每一个柱子之间都去乘
        // 1 *2   1*3   1*4
        // 2 *3   2*4   2*5
        // 上面这种思路，得出每个块的大小
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(area, max);
            }
        }
        return max;
    }

    /**
     * 夹逼法
     *
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        // 左右夹逼法，那个小，就往中间移动
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHeight = height[i] > height[j] ? height[j--] : height[i++];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;
    }
}
