package com.qxz.leet.code.daily

import kotlin.test.currentStackTrace

/**
 * https://leetcode-cn.com/problems/count-binary-substrings/
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * 重复出现的子串要计算它们出现的次数。
 *
 * 示例1
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 *
 * 示例2
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 */

fun main() {
    print("有${countBinarySubstrings2("00110011")}个")
}

/**
 * 方法一：按字符分组
 * 思路与算法
 * 我们可以将字符串 ss 按照 00 和 11 的连续段分组，存在 \rm countscounts 数组中，例如 s = 00111011s=00111011，
 * 可以得到这样的 \rm countscounts 数组：{\rm counts} = \{2, 3, 1, 2\}counts={2,3,1,2}。
 * 这里 \rm countscounts 数组中两个相邻的数一定代表的是两种不同的字符。假设 \rm countscounts
 * 数组中两个相邻的数字为 uu 或者 vv，它们对应着 uu 个 00 和 vv 个 11，或者 uu 个 11 和 vv 个 00。
 * 它们能组成的满足条件的子串数目为 \min \{ u, v \}min{u,v}，即一对相邻的数字对答案的贡献。
 * 我们只要遍历所有相邻的数对，求它们的贡献总和，即可得到答案。
 * 不难得到这样的实现：
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/count-binary-substrings/solution/ji-shu-er-jin-zhi-zi-chuan-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
fun countBinarySubstrings(s: String): Int {
    // 获取字符串的长度
    val length = s.length
    // 总相邻
    var sum = 0
    var pre = 0
    var cur = 0
    var index = 0
    while (index < length) {
        pre = cur
        cur = 1
        index++
        while (index < length) {
            if (s[index] == s[index - 1]) {
                cur++
                index++
            } else {
                break
            }
        }
        sum += Math.min(pre, cur)
    }
    return sum
}

fun countBinarySubstrings2(s: String): Int {
    val charArray = s.toCharArray().toMutableList()

    var sumCount = 0
    for (i in 0..charArray.size - 2) {
        // 00110011
        // 00 001 0011 00110 001100
        // 偶数，最大不能超过 字符串长度
        // 先求出偶数
        var loopChart: String = charArray[i].toString()
        for (j in (i + 1)..charArray.size - 2) {
            // 拼接相应的字符串
            loopChart += charArray[j].toString()

            if (loopChart.length % 2 == 0) {
                println(loopChart+"前截取："+loopChart.substring(0, loopChart.length / 2))
                println(loopChart+"后截取："+loopChart.substring(loopChart.length / 2,
                    loopChart.length))
                println("------")

                if (loopChart.substring(0, loopChart.length / 2) == loopChart.substring(
                        loopChart.length / 2,
                        loopChart.length
                    )
                ) {
                    sumCount++
                }
            }
        }
    }

    return sumCount
}
