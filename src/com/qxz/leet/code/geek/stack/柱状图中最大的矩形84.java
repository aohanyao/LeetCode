package com.qxz.leet.code.geek.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 理解能力不足，待定
 */
@Deprecated
public class 柱状图中最大的矩形84 {
    public static void main(String[] args) {

        int[] data1 = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea2(data1));

    }
    // 最大矩形范围
    // https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/


    /**
     * 暴力求解法
     * 循环，左右扩散法，以当前的柱子为中心点，左右进行扩散，找到大于等于自己高度的柱子，计算面积
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea1(int[] heights) {
        int length = heights.length;
        if (length == 0) {
            return 0;
        }
        int area = 0;
        for (int i = 0; i < length; i++) {
            int currentHeight = heights[i];
            int left = i;
            while (left > 0 && heights[left - 1] >= currentHeight) left--;
            int right = i;
            while (right < length - 1 && heights[right + 1] >= currentHeight) right++;
            // +1 是当前中心那个柱子
            int width = right - left + 1;
            area = Math.max(area, width * currentHeight);
        }
        return area;
    }

    /**
     * 有效最大面积 ：哨兵解法 左右增加一个元素0的的元素
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
     * 未掌握
     * @param heights
     * @return
     */
    public static int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        // 创建一个新的数组，比原本的大两位
        int[] newHeights = new int[len + 2];
        // 第一位赋值为0
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        // 最后一位赋值为0
        newHeights[len + 1] = 0;
        len += 2;
        // 赋值回去
        heights = newHeights;
        // 创建栈
        Deque<Integer> stack = new ArrayDeque<>(len);
        // 添加栈底为0
        stack.addLast(0);

        int area = 0;
        for (int i = 1; i < len; i++) {
            // 当前下标的和上一个最后一个的对比
            while (heights[i] < heights[stack.peekLast()]) {
                // 移出一个
                int currentHeight = heights[stack.pollLast()];
                // 当前
                int currentWidth = i - stack.peekLast() - 1;
                area = Math.max(area, currentHeight * currentWidth);
            }
            stack.addLast(i);
        }

        return area;
    }
}
