package com.qxz.leet.code.array

fun main() {
//    println(searchInsert(intArrayOf(1, 3, 5, 6), 5))
//    println(searchInsert(intArrayOf(1, 3, 5, 6), 2))
//    println(searchInsert(intArrayOf(1, 3, 5, 6), 7))
    var start = System.currentTimeMillis()
    println(searchInsert(intArrayOf(-1, 3, 5, 6), -2))
    println("耗时：${ System.currentTimeMillis() - start}")
}

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 输入: [1,3,5,6], 7
 * 输出: 4
 */
fun searchInsert(nums: IntArray, target: Int): Int {
    if (nums[0] > target) return 0
    var targetIndex = -1
    nums.forEachIndexed { index, element ->
        if (element <= target) {
            //记录下标
            targetIndex = index
            if (element == target) {
                return index
            }
        }
    }
    return targetIndex + 1
}