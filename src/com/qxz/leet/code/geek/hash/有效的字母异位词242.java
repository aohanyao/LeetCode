package com.qxz.leet.code.geek.hash;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class 有效的字母异位词242 {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";

        System.out.println(isAnagram2(s, t));
    }


    /**
     * 暴力求解法，直接排成一样的顺序进行对比
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

    /**
     * 哈希映射表
     * 1.首先判断两个字符串长度是否相等，不相等则直接返回 false
     * 2.若相等，则初始化 26 个字母哈希表，遍历字符串 s 和 t
     * 3.s 负责在对应位置增加，t 负责在对应位置减少
     * 4.如果哈希表的值都为 0，则二者是字母异位词
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        int length = s.length();
        if (length != t.length())
            return false;

        int[] hash = new int[26];
        // 遍历  - 'a' 的操作是ASCII 编码的位置
        for (int i = 0; i < length; i++) {

            hash[s.charAt(i) - 'a']++;
            hash[t.charAt(i) - 'a']--;
        }

        for (int i : hash) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
