package com.qxz.leet.code.geek.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 滑动窗口最大值239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] integers = maxSlidingWindow2(nums, k);
        System.out.println("");
        for (Integer integer : integers) {
            System.out.print(integer + ",");
        }
    }


    /**
     * 暴力求解法
     * 直接遍历每一个窗口
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> tempRes = new ArrayList<>();
        int length = nums.length;
        // 滑动窗口+1
        for (int i = 0; i < length - k + 1; i++) {
            int max = nums[i];
            for (int j = 0; j < k; j++) {
                max = Math.max(max, nums[j + i]);
            }
            tempRes.add(max);
        }
        int[] res = new int[tempRes.size()];

        for (int i = 0; i < tempRes.size(); i++) {
            res[i] = tempRes.get(i);
        }
        return res;
    }


    /**
     * 双端队列解法-未掌握
     * <img src="https://pic.leetcode-cn.com/1598322676-LKPmOw-image.png"/>
     * https://leetcode-cn.com/problems/sliding-window-maximum/solution/3chong-jie-jue-fang-shi-by-sdwwld/
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int res[] = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> qeque = new ArrayDeque<>();

        // 循环遍历
        for (int i = 0; i < nums.length; i++) {
            // 如果队列中队头元素和当前元素位置相差i-k，相当于队头元素要出窗口了，就把队头元素给移除，
            // 注意队列中存储/的是元素的下标（函数peekFirst()表示的是获取队头的下标，函数
            // pollFirst()表示的是移除队头元素的下标）
            if (!qeque.isEmpty() && qeque.peekFirst() <= i - k) {
                qeque.pollFirst();
            }
            // 在添加一个值之前，前面比他小的都要被移除掉，并且还要保证窗口
            // 中队列头部元素永远是队列中最大的
            while (!qeque.isEmpty() && nums[qeque.peekLast()] < nums[i]) {
                qeque.pollLast();
            }
            // 当前元素的下标加入到队列的尾部
            qeque.addLast(i);
            // 当窗口的长度大于等于k个的时候才开始计算（注意这里的i是从0开始的）
            if (i >= k - 1) {
                //队头元素是队列中最大的，把队列头部的元素加入到数组中
                res[index++] = nums[qeque.peekFirst()];
            }
        }


        return res;
    }
}
